package co.com.sofka.app.domain.reserve;
import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.entity.Kit;
import co.com.sofka.app.domain.reserve.entity.Room;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
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
    }

    private Reserve(ReserveId reserveId) {
        super(reserveId);
    }

    public static Reserve from(ReserveId reserveId, List<DomainEvent> events){
        var reserve = new Reserve(reserveId);
        events.forEach(reserve::applyEvent);
        return reserve;
    }
}
