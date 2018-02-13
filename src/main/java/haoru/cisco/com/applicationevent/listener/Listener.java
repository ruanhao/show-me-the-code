package haoru.cisco.com.applicationevent.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import haoru.cisco.com.applicationevent.event.Event;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Listener {

    @EventListener
    public void handlerEvent(Event event) {
        log.info("Receive event: {}", event);
    }

}
