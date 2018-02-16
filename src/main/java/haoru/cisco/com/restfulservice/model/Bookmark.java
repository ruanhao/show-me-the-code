package haoru.cisco.com.restfulservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Entity
@Getter
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    private String uri;

    private String description;

    @SuppressWarnings("unused")
	private Bookmark() { } // JPA only

    public Bookmark(final Account account, final String uri, final String description) {
        this.uri = uri;
        this.description = description;
        this.account = account;
    }

}