package co.com.sofka.app.domain.reserve;
import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.entity.Kit;
import co.com.sofka.app.domain.reserve.entity.Room;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.events.AddedRoom;
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

    public Reserve(ReserveId entityId, Day day, PaymentStatus paymentStatus) {
        super(entityId);
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

    public void addRoom(RoomId roomId, Type type, Status status, BedsAmount bedsAmount){
        Objects.requireNonNull(roomId);
        Objects.requireNonNull(type);
        Objects.requireNonNull(status);
        Objects.requireNonNull(bedsAmount);
        appendChange(new AddedRoom(roomId,type,status,bedsAmount)).apply();
    }
}
