package haoru.cisco.com.applicationevent.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import haoru.cisco.com.applicationevent.event.Event;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Publisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String message) {
        log.info("Sending message: {}", message);
        applicationContext.publishEvent(new Event(this, message));
    }

}
