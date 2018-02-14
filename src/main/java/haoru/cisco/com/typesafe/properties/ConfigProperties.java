package haoru.cisco.com.typesafe.properties;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Configuration
@Validated
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix="mail")
public class ConfigProperties {

	@Getter
	@Setter
    @ToString
    public static class Credentials {
        @Length(max=4, min=1)
        private String authMethod;
        private String username;
        private String password;
    }


    @NotBlank
    private String host;
    @Min(1025)
    @Max(65536)
    private int port;
    @Pattern(regexp="^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String from;

    // In order to validate values of nested properties,
    // you must annotate the associated field as @Valid to trigger its validation.
    @Valid
    private Credentials credentials;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;

}