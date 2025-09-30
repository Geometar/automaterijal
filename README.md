# automaterijal
Web App created in Java 11, Spring Boot V2, Angular 6, MySql

This app is made for spare car parts web shop and representation of company Automaterijal from Serbia.

Ui and BE are integrated as a single app. 

## Product sitemap refresh

- Product sitemap XML files are pre-generated and cached in memory for quick responses.
- The cache refreshes on application startup and then daily at 02:00 (UTC) via the cron defined in `sitemap.products.refresh-cron`.
- Adjust the refresh interval per environment by overriding the same property in the relevant `application-*.yml` profile.
- To force a refresh outside the schedule, restart the application or temporarily change the cron expression and redeploy.
