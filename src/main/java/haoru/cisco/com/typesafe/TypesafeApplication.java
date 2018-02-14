package haoru.cisco.com.typesafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import haoru.cisco.com.typesafe.properties.ConfigProperties;
import haoru.cisco.com.typesafe.properties.FooProperties;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TypesafeApplication implements CommandLineRunner {

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    FooProperties fooProperties;


	public static void main(String[] args) {
		SpringApplication.run(TypesafeApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        log.info("configProperties: {}", configProperties);
        log.info("fooProperties: {}", fooProperties);
    }
}
