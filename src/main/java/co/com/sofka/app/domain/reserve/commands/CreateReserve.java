package co.com.sofka.app.domain.reserve.commands;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.domain.generic.Command;

public class CreateReserve implements Command {
    private final ReserveId reserveId;
    private final Day day;
    private final PaymentStatus paymentStatus;

    public CreateReserve(ReserveId reserveId, Day day, PaymentStatus paymentStatus){
        this.reserveId = reserveId;
        this.day = day;
        this.paymentStatus = paymentStatus;
    }

    public ReserveId getReserveId() {
        return reserveId;
    }

    public Day getDay() {
        return day;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
