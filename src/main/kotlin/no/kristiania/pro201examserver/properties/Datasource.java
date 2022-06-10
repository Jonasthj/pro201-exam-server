package no.kristiania.pro201examserver.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Datasource {

    @Value("${spring.datasource.database-url}")
    public String databaseUrl;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.sql.init.platform}")
    private String platform;

    @Override
    public String toString() {
        return "Datasource{" +
                "databaseUrl='" + databaseUrl + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
