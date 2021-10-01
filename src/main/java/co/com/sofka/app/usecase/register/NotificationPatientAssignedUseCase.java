package co.com.sofka.app.usecase.register;

import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.register.events.AssignedPatient;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class NotificationPatientAssignedUseCase extends UseCase<TriggeredEvent<AssignedPatient>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<AssignedPatient> assignedPatientTriggeredEvent) {
        var event = assignedPatientTriggeredEvent.getDomainEvent();
        var register = Register.from(RegisterId.of(event.aggregateRootId()), this.retrieveEvents());
        register.sendNotification("Assigned patient");

        emit().onResponse(new ResponseEvents(register.getUncommittedChanges()));
    }
}
