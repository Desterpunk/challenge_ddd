package co.com.sofka.app.domain.reserve;

import co.com.sofka.app.domain.reserve.entity.Kit;
import co.com.sofka.app.domain.reserve.entity.Room;
import co.com.sofka.app.domain.reserve.events.*;
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

        apply((AddedRoom event) -> reserve.rooms.add(new Room(
                event.getRoomId(),
                event.getKind(),
                event.getStatus(),
                event.getBedsAmount()
        )));

        apply((AddedKit event) -> reserve.kits.add(new Kit(
                event.getKitId(),
                event.getKind(),
                event.getMedicine(),
                event.getSupplie()
        )));

        apply((AssignedRegister event) -> reserve.registerId = event.getRegisterId());

        apply((CreatedEmployee event) -> reserve.employeeId = event.getEmployeeId());

        apply((AssignedEmployee event) -> {
            if (!reserve.employeeId.equals(event.getEmployeeId())){
                throw new IllegalArgumentException("No se encontro un empleado con ese id");
            }
            reserve.employeeId = event.getEmployeeId();
        });
    }
}
