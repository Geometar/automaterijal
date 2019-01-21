package com.automaterijal.application.services.email;

import com.automaterijal.application.domain.dto.email.Email;
import com.automaterijal.application.domain.dto.email.RegistracijaDto;
import com.automaterijal.application.domain.dto.email.ZaboravljenaSifraDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.PartnerService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.MailException;
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

    public void posaljiZaboravljenaSifraMail(final ZaboravljenaSifraDto dto, final String host) {
        final Optional<Partner> optionalPartner = partnerService.pronadjiPartneraPoMejlu(dto.getEmail());
        if(optionalPartner.isPresent()) {
            final Partner partner = optionalPartner.get();
            final Context context = popuniKontextZaborvaljeneSifreEmaila(partner, host);
            pripremiIPosaljiEmail(Email.AUTOMATERIJAL_EMAIL, dto.getEmail(), dto.NASLOV, dto.TEMPLATE, context);
        } else {
            throw new MailSendException("Mail not found");
        }

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

        try {
            emailSender.send(preparator);
        } catch (final MailException e) {
            e.printStackTrace();
        }
    }

    private Context popuniKontextRegistracionogEmaila(final RegistracijaDto dto) {
        final Context context = new Context();
        if(dto.getDaLiJePravnoLice() == true) {
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
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")) + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        );
        context.setVariable("daLiJePravnoLice", dto.getDaLiJePravnoLice());
        return context;
    }
    private Context popuniKontextZaborvaljeneSifreEmaila(final Partner partner, final String host) {
        final Context context = new Context();
        final String customerIdParam = "?id=" + partner.getPpid();
        final String url ="http://" + host + "/reset-sifre/" + partner.getUsers().getPassword() + customerIdParam;
        context.setVariable("url", url);
        return context;
    }
}
