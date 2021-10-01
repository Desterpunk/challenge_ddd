package co.com.sofka.app.domain.reserve.events;

import co.com.sofka.domain.generic.DomainEvent;

public class SentNotification extends DomainEvent {
    private String message;

    public SentNotification(String message) {
        super("domain.reserve.sentnotification");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
