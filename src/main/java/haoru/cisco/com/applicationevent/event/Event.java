package haoru.cisco.com.applicationevent.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Event extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    @Getter
    private String message;

    public Event(Object source, String message) {
        super(source);
        this.message = message;
    }

}
