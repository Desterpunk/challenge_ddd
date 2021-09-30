package co.com.sofka.app.domain.reserve.events;

import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.domain.generic.DomainEvent;

public class AssignedRegister extends DomainEvent {
    private final RegisterId registerId;

    public AssignedRegister(RegisterId registerId){
        super("domain.reserve.assignedregister");
        this.registerId = registerId;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }
}
