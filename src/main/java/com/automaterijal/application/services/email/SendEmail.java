package com.automaterijal.application.services.email;

import com.automaterijal.application.domain.dto.email.Email;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SendEmail {

    @NonNull
    final JavaMailSender emailSender;

    @NonNull
    final MailContentBuilder mailContentBuilder;

    @Async
    public void pripremiIPosaljiEmail(final String emailprimaoca, final String naslov, final String template, final Context context) {
        final MimeMessagePreparator preparator = mimeMessage -> {
            final var messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(Email.EMAIL_ZA_SLANJE);
            messageHelper.setTo(new String[]{emailprimaoca, Email.RADOV_EMAIL});
            messageHelper.setSubject(naslov);
            final String text = mailContentBuilder.build(template, context);
            messageHelper.setText(text, true);
        };

        emailSender.send(preparator);
    }
}
