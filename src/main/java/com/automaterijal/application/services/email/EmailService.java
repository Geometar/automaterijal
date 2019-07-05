package com.automaterijal.application.services.email;

import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.email.*;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.PartnerService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailService {

    @NonNull
    final PartnerService partnerService;

    @NonNull
    final SendEmail sendEmail;

    public void posaljiRegistracioniEmail(final RegistracijaDto dto) {
        final Context context = popuniKontextRegistracionogEmaila(dto);
        sendEmail.pripremiIPosaljiEmail(dto.EMAIL_ZA_PRIMANJE, dto.NASLOV, dto.TEMPLATE, context);
    }

    private Context popuniKontextRegistracionogEmaila(final RegistracijaDto dto) {
        final Context context = new Context();
        if (dto.getDaLiJePravnoLice() == true) {
            context.setVariable("naziv", dto.getNazivFirme());
            context.setVariable("pib", dto.getPib());
        } else {
            context.setVariable("imeIPrezime", dto.getImeIPrezime());
        }
        context.setVariable("grad", dto.getGrad());
        context.setVariable("adresa", dto.getAdresa());
        context.setVariable("email", dto.getEmail());
        context.setVariable("telefon", dto.getKontaktTelefon());
        context.setVariable(
                "vreme",
                vratiVremeSlanja()
        );
        context.setVariable("daLiJePravnoLice", dto.getDaLiJePravnoLice());
        return context;
    }

    public void posaljiMailONedovoljnimKolicinama(final FakturaDto faktura, final Partner partner) {
        final var context = new Context();
        final var naslov = "Obavestenje o potvrdjenoj robi";
        final var template = "fakturaFaliRoba";

        context.setVariable("faktura", faktura);
        sendEmail.pripremiIPosaljiEmail(partner.getEmail(), naslov, template, context);

    }

    public void posaljiZaboravljenaSifraMail(final ZaboravljenaSifraDto dto, final String host) {
        var optionalPartner = partnerService.pronadjiPartneraPoMejlu(dto.getEmail());
        if (!optionalPartner.isPresent()) {
            optionalPartner = partnerService.vratiPartneraPomocuKorisnickogImena(dto.getEmail());
        }

        if (optionalPartner.isPresent()) {
            zaboravljenaSifraPripremaISlanje(dto, optionalPartner.get(), host);
        } else {
            throw new MailSendException("Mail not found");
        }
    }

    private void zaboravljenaSifraPripremaISlanje(final ZaboravljenaSifraDto dto, final Partner partner, final String host) {
        final Context context = popuniKontextZaborvaljeneSifreEmaila(partner, host);
        sendEmail.pripremiIPosaljiEmail(partner.getEmail(), dto.NASLOV, dto.TEMPLATE, context);
    }

    private Context popuniKontextZaborvaljeneSifreEmaila(final Partner partner, final String host) {
        final Context context = new Context();
        final String customerIdParam = "?id=" + partner.getPpid();
        final String url = "http://" + host + "/automaterijal/reset-sifre/" + partner.getUsers().getPassword() + customerIdParam;
        context.setVariable("url", url);
        return context;
    }

    public void posaljiPoruku(final PorukaDto porukaDto) {
        final Context context = popuniKontekstPorukeEmail(porukaDto);
        sendEmail.pripremiIPosaljiEmail(Email.EMAIL_ZA_PRIMANJE, porukaDto.NASLOV, porukaDto.TEMPLATE, context);
    }

    private Context popuniKontekstPorukeEmail(final PorukaDto dto) {
        final Context context = new Context();
        context.setVariable("ime", dto.getIme());
        context.setVariable("prezime", dto.getPrezime());
        context.setVariable("firma", dto.getFirma());
        context.setVariable("telefon", dto.getTelefon());
        context.setVariable("posta", dto.getPosta());
        context.setVariable("poruka", dto.getPoruka());
        context.setVariable("vreme", vratiVremeSlanja());
        return context;
    }

    private String vratiVremeSlanja() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")) + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void posaljiUpitMail(final UpitDto upitDto) {
        final Context context = popuniKontekstUpitEmail(upitDto);
        sendEmail.pripremiIPosaljiEmail(Email.EMAIL_ZA_PRIMANJE, upitDto.NASLOV, upitDto.TEMPLATE, context);
    }

    private Context popuniKontekstUpitEmail(final UpitDto dto) {
        final Context context = new Context();
        context.setVariable("emailTelefon", dto.getEmailTelefon());
        context.setVariable("markaModel", dto.getMarkaModel());
        context.setVariable("kilovati", dto.getKilovati());
        context.setVariable("kubikaza", dto.getKubikaza());
        context.setVariable("godiste", dto.getGodiste());
        context.setVariable("pogon", dto.getPogon());
        context.setVariable("gorivo", dto.getGorivo());
        context.setVariable("interesujeMe", dto.getInteresujeMe());
        context.setVariable("drugo", dto.getDrugo());
        context.setVariable("vreme", vratiVremeSlanja());
        return context;
    }
}
