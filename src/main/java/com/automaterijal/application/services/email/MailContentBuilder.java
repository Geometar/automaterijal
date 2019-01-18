package com.automaterijal.application.services.email;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailContentBuilder {

    @NonNull
    final TemplateEngine templateEngine;

    public String build(final String template, final Context context) {
        return templateEngine.process(template, context);
    }
}
