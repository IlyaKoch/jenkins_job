package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static java.lang.String.format;

@Tag("Owner")
public class OwnerTests {

    @Test
    void readCredentialsTest() {
        String login = TestBase.credentials.login();
        String password = TestBase.credentials.password();
        String url = TestBase.credentials.url();
        System.out.println(login);
        System.out.println(password);
        System.out.println(url);

        String message = format("i login as %s with password %s", login, password);
        System.out.println(message);
    }
}