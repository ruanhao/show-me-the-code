package haoru.cisco.com.asyncmethod.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown=true)
@ToString
@Setter
@Getter
public class User {

    private String name;
    private String blog;
}
