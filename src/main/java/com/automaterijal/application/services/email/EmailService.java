package com.automaterijal.application.services.email;

import com.automaterijal.application.domain.dto.email.*;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.PartnerService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailService {

    @NonNull
    final JavaMailSender emailSender;

    @NonNull
    final MailContentBuilder mailContentBuilder;

    @NonNull
    final PartnerService partnerService;

    public void posaljiRegistracioniEmail(final RegistracijaDto dto) {
        final Context context = popuniKontextRegistracionogEmaila(dto);
        pripremiIPosaljiEmail(dto.AUTOMATERIJAL_EMAIL, dto.AUTOMATERIJAL_EMAIL, dto.NASLOV, dto.TEMPLATE, context);
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

    public void posaljiZaboravljenaSifraMail(final ZaboravljenaSifraDto dto, final String host) {
        Optional<Partner> optionalPartner = partnerService.pronadjiPartneraPoMejlu(dto.getEmail());

        if (optionalPartner.isPresent()) {
            zaboravljenaSifraPripremaISlanje(dto, optionalPartner.get(), host);
        } else {
            optionalPartner = partnerService.vratiPartneraPomocuKorisnickogImena(dto.getEmail());
            if (optionalPartner.isPresent()) {
                zaboravljenaSifraPripremaISlanje(dto, optionalPartner.get(), host);
            } else {
                throw new MailSendException("Mail not found");

            }
        }
    }

    private void zaboravljenaSifraPripremaISlanje(final ZaboravljenaSifraDto dto, final Partner partner, final String host) {
        final Context context = popuniKontextZaborvaljeneSifreEmaila(partner, host);
        pripremiIPosaljiEmail(Email.AUTOMATERIJAL_EMAIL, partner.getEmail(), dto.NASLOV, dto.TEMPLATE, context);
    }

    private Context popuniKontextZaborvaljeneSifreEmaila(final Partner partner, final String host) {
        final Context context = new Context();
        final String customerIdParam = "?id=" + partner.getPpid();
        final String url = "http://" + host + "/reset-sifre/" + partner.getUsers().getPassword() + customerIdParam;
        context.setVariable("url", url);
        return context;
    }

    public void posaljiPoruku(final PorukaDto porukaDto) {
        final Context context = popuniKontekstPorukeEmail(porukaDto);
        pripremiIPosaljiEmail(Email.AUTOMATERIJAL_EMAIL, Email.AUTOMATERIJAL_EMAIL, porukaDto.NASLOV, porukaDto.TEMPLATE, context);
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
        pripremiIPosaljiEmail(Email.AUTOMATERIJAL_EMAIL, Email.AUTOMATERIJAL_EMAIL, upitDto.NASLOV, upitDto.TEMPLATE, context);
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

    private void pripremiIPosaljiEmail(final String emailPosaljioca, final String emailprimaoca, final String naslov, final String template, final Context context) {
        final MimeMessagePreparator preparator = mimeMessage -> {
            final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(emailPosaljioca);
            messageHelper.setTo(emailprimaoca);
            messageHelper.setSubject(naslov);
            final String text = mailContentBuilder.build(template, context);
            messageHelper.setText(text, true);
        };

        emailSender.send(preparator);
    }
}
