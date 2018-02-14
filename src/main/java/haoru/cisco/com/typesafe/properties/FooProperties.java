package haoru.cisco.com.typesafe.properties;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties("foo")
@Validated
@Setter
@Getter
@ToString
public class FooProperties {

    private boolean enabled;
    @NotNull
    private InetAddress remoteAddress;
    @Valid
    private final Security security = new Security();

    @Setter
    @Getter
    @ToString
    public static class Security {

        @NotEmpty
        private String username;
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

    }
}