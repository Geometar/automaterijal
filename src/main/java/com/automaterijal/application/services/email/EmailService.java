package com.automaterijal.application.services.email;

import com.automaterijal.application.domain.constants.PartnerAkcije;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.email.*;
import com.automaterijal.application.domain.dto.izvestaj.IzvestajDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.repository.PartnerRepository;
import com.automaterijal.application.services.security.UsersService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class EmailService {

    @NonNull
    final PartnerRepository partnerRepository;

    @NonNull
    final UsersService usersService;

    @NonNull
    final SendEmail sendEmail;

    /**
     * Kad partner promeni informaciju saljemo administratoru mejl da bi sinkovao sa
     * Automaterijalom glavnim
     */
    public void posaljiPromenaInformacijaMail(final PartnerDto partner, final PartnerAkcije partnerAkcije) {
        log.info("Slanje mejla za promenu informacije {} od strane korisnika {}", partnerAkcije.getOpis(), partner.getNaziv());

        final var naslov = "Obavestenje o promeni informacija korisnika";
        final var template = "promenaInformacija";

        final Context context = popuniKontextRegistracionogEmaila(partner, partnerAkcije);
        sendEmail.pripremiIPosaljiEmail(Email.RADOV_EMAIL, naslov, template, context);

    }

    private Context popuniKontextRegistracionogEmaila(final PartnerDto partner, final PartnerAkcije partnerAkcije) {
        final Context context = new Context();
        context.setVariable("partner", partner);
        context.setVariable("akcija", partnerAkcije.getOpis());
        switch (partnerAkcije) {
            case PROMENA_ADRESE:
                context.setVariable("informacija", partner.getAdresa());
                break;
            case PROMENA_SIFRE:
                context.setVariable("informacija", "nova-sifra");
                break;
            case PROMENA_MEJLA:
                context.setVariable("informacija", partner.getEmail());
                break;
            case PROMENA_IMENA:
                context.setVariable("informacija", partner.getWebKorisnik());
                break;
            default:
                log.error("Nepoznata promena informacije za korisnika!");
                context.setVariable("informacija", "Greska pogledaj logove!");

        }
        return context;
    }

    /**
     * Posalji podsetnike za izvestaj
     */
    public void posaljiIzvestajEmail(final IzvestajDto izvestajDto) {
        final Context context = popuniKontekstIzvestaja(izvestajDto);
        partnerRepository.findByPpid(izvestajDto.getKomentarDto().getPpid()).ifPresent(partner -> {
            log.info("Slanje izvestaja komercijalisti {}", partner.getNaziv());
            sendEmail.pripremiIPosaljiEmail(partner.getEmail(), "Podsetnik za izvestaj", "slanjeIzvestajPodsetnik", context);
        });

    }

    private Context popuniKontekstIzvestaja(IzvestajDto dto) {
        final Context context = new Context();
        context.setVariable("datumIzvestaja", dto.getKomentarDto().getDatumKreiranja());
        context.setVariable("ime", dto.getFirmaDto().getIme());
        context.setVariable("mesto", dto.getFirmaDto().getMesto());
        context.setVariable("adresa", dto.getFirmaDto().getAdresa());
        context.setVariable("kontakt", dto.getFirmaDto().getKontakt());
        context.setVariable("komentar", dto.getKomentarDto().getKomentar());
        return context;
    }

    /**
     * Servis za slanje mejla pri zahtevu za registraciju korisnika
     */
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

    /**
     * Servis za obavestavanja kupca o nedovoljnim kolicinama u magacinu
     */
    @Deprecated
    public void posaljiMailONedovoljnimKolicinama(final FakturaDto faktura, final Partner partner) {
        final var context = new Context();
        context.setVariable("faktura", faktura);
        final var naslov = "Obavestenje o potvrdjenoj robi";
        final var template = "fakturaFaliRoba";

        sendEmail.pripremiIPosaljiEmail(partner.getEmail(), naslov, template, context);

    }

    /**
     * Servis za slanje mejla sa linkom za promenu sifre
     */
    public void posaljiZaboravljenaSifraMail(final ZaboravljenaSifraDto dto, final String host) {
        var optionalPartner = partnerRepository.findByEmail(dto.getEmail());
        if (!optionalPartner.isPresent()) {
            optionalPartner = partnerRepository.findByWebKorisnik(dto.getEmail());
        }

        if (optionalPartner.isPresent()) {
            final Partner partner = optionalPartner.get();
            validateEmail(partner);
            zaboravljenaSifraPripremaISlanje(dto, partner, host);
        } else {
            log.error("Ne postoji email ili korisinicko ime korisnika u bazi", dto.getEmail());
            throw new MailSendException("Mail not found");
        }
    }

    private void validateEmail(final Partner partner) {
        try {
            if (partner.getEmail() == null) {
                throw new AddressException();
            }

            final InternetAddress address = new InternetAddress(partner.getEmail());
            address.validate();

        } catch (final AddressException e) {
            log.error("Partner {} nema validan mejl i ne moze da promeni sifru.", partner.getPpid());
            nevalidanMejlPripremiIPosalji(partner);
            throw new MailPreparationException("Email not valid");
        }
    }

    private void nevalidanMejlPripremiIPosalji(final Partner partner) {
        final String NASLOV = "Korisnik nema validan email";
        final String TEMPLATE = "nevalidanEmailTemplate";
        final Context context = popuniKontextNevalidnogMejla(partner);
        sendEmail.pripremiIPosaljiEmail(Email.EMAIL_ZA_PRIMANJE, NASLOV, TEMPLATE, context);
    }

    private Context popuniKontextNevalidnogMejla(final Partner partner) {
        final Context context = new Context();
        final String naziv = partner.getNaziv() != null ? partner.getNaziv() : partner.getPpid().toString();
        context.setVariable("naziv", naziv);
        return context;
    }

    private void zaboravljenaSifraPripremaISlanje(final ZaboravljenaSifraDto dto, final Partner partner, final String host) {
        if (partner.getUsers() == null) {
            final var users = usersService.sacuvajUsera(partner);
            partner.setUsers(users);
        }
        final Context context = popuniKontextZaborvaljeneSifreEmaila(partner, host);
        sendEmail.pripremiIPosaljiEmail(partner.getEmail(), dto.NASLOV, dto.TEMPLATE, context);
    }

    private Context popuniKontextZaborvaljeneSifreEmaila(final Partner partner, final String host) {
        final Context context = new Context();
        final String customerIdParam = "?id=" + partner.getPpid();
        final String url = "http://" + host + "/#/reset-sifre/" + partner.getUsers().getPassword() + customerIdParam;
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
