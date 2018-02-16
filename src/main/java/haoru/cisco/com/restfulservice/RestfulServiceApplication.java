package haoru.cisco.com.restfulservice;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haoru.cisco.com.restfulservice.model.Account;
import haoru.cisco.com.restfulservice.model.AccountRepository;
import haoru.cisco.com.restfulservice.model.Bookmark;
import haoru.cisco.com.restfulservice.model.BookmarkRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
		return (evt) -> Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
            .forEach(a -> {
                    log.info("Processing {}", a);
					Account account = accountRepository.save(new Account(a, "password"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
				});
	}

}
