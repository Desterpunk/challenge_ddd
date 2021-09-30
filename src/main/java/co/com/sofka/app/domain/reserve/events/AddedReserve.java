package co.com.sofka.app.domain.reserve.events;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedReserve extends DomainEvent {
    private final Day day;
    private final PaymentStatus paymentStatus;

    public AddedReserve(Day day, PaymentStatus paymentStatus){
        super("domain.reserve.addedreserve");
        this.day = day;
        this.paymentStatus = paymentStatus;
    }

    public Day getDay() {
        return day;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
