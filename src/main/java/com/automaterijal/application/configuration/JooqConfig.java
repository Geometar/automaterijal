package com.automaterijal.application.configuration;

import javax.sql.DataSource;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JooqConfig {

  @Bean
  public DSLContext dslContext(Configuration configuration) {
    return DSL.using(configuration);
  }

  @Bean
  public Configuration jooqConfiguration(DataSource dataSource) {
    DefaultConfiguration configuration = new DefaultConfiguration();
    configuration.set(dataSource);
    configuration.set(SQLDialect.MYSQL); // Use your appropriate SQLDialect (e.g., MYSQL, MARIADB)

    return configuration;
  }
}
