package co.com.sofka.app.domain.reserve;

import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ReserveChange extends EventChange {

    public ReserveChange(Reserve reserve){
        apply((AddedReserve event) -> {
            reserve.day = event.getDay();
            reserve.paymentStatus = event.getPaymentStatus();
            reserve.rooms = new HashSet<>();
            reserve.kits = new HashSet<>();
        });
    }
}
