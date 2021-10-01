package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.events.AssignedRegister;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class NotificationRegisterAssignedUseCase extends UseCase<TriggeredEvent<AssignedRegister>, ResponseEvents>{

    @Override
    public void executeUseCase(TriggeredEvent<AssignedRegister> assignedRegisterTriggeredEvent) {
        var event = assignedRegisterTriggeredEvent.getDomainEvent();
        var reserve = Reserve.from(ReserveId.of(event.aggregateRootId()), this.retrieveEvents());
        reserve.sendNotification("Assigned register");

        emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
    }
}
