package co.com.sofka.app.domain.register.events;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedRegister extends DomainEvent {
    private final Day day;

    public AddedRegister(Day day){
        super("domain.reserve.addedregister");
        this.day = day;
    }

    public Day getDay() {
        return day;
    }
}
