package tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class OwnerTests {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();
        String url = credentials.url();
        System.out.println(login);
        System.out.println(password);
        System.out.println(url);

        String message = format("i login as %s with password %s", login, password);
        System.out.println(message);
    }
}