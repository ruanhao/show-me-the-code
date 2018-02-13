package haoru.cisco.com.applicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import haoru.cisco.com.applicationevent.publisher.Publisher;

@SpringBootApplication
public class ApplicationEventApplication implements CommandLineRunner {

    @Autowired
    Publisher publisher;

    @Bean(name="applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
            = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEventApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        publisher.publish("test");
    }
}
