package co.com.sofka.app.domain.reserve;
import co.com.sofka.app.domain.generic.*;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.entity.Kit;
import co.com.sofka.app.domain.reserve.entity.Room;
import co.com.sofka.app.domain.reserve.events.*;
import co.com.sofka.app.domain.reserve.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Reserve extends AggregateEvent<ReserveId> {
    protected RegisterId registerId;
    protected EmployeeId employeeId;
    protected Day day;
    protected Set<Room> rooms;
    protected Set<Kit> kits;
    protected PaymentStatus paymentStatus;

    public Reserve(ReserveId reserveId, Day day, PaymentStatus paymentStatus) {
        super(reserveId);
        appendChange(new AddedReserve(day,paymentStatus)).apply();
    }

    private Reserve(ReserveId reserveId) {
        super(reserveId);
        subscribe(new ReserveChange(this));
    }

    public static Reserve from(ReserveId reserveId, List<DomainEvent> events){
        var reserve = new Reserve(reserveId);
        events.forEach(reserve::applyEvent);
        return reserve;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Day getDay() {
        return day;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public Set<Kit> getKits() {
        return kits;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void assignRegister(RegisterId registerId){
        appendChange(new AssignedRegister(registerId)).apply();
    }

    public void assignEmployee(EmployeeId employeeId){
        appendChange(new AssignedEmployee(employeeId)).apply();
    }

    public void addRoom(RoomId roomId, Type type, Status status, BedsAmount bedsAmount){
        Objects.requireNonNull(roomId);
        Objects.requireNonNull(type);
        Objects.requireNonNull(status);
        Objects.requireNonNull(bedsAmount);
        appendChange(new AddedRoom(roomId,type,status,bedsAmount)).apply();
    }

    public void addKit(KitId kitId,Type type,Medicine medicine,Supplie supplie){
        Objects.requireNonNull(kitId);
        Objects.requireNonNull(type);
        Objects.requireNonNull(medicine);
        Objects.requireNonNull(supplie);
        appendChange(new AddedKit(kitId,type,medicine,supplie)).apply();
    }

    public void sendNotification(String message){
        appendChange(new SentNotification(message)).apply();
    }
}
