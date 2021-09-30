package co.com.sofka.app.domain.reserve.commands;

import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.domain.generic.Command;

public class AssignRegister implements Command {
    private final ReserveId reserveId;
    private final RegisterId registerId;

    public AssignRegister(ReserveId reserveId, RegisterId registerId){
        this.reserveId = reserveId;
        this.registerId = registerId;
    }

    public ReserveId getReserveId() {
        return reserveId;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }
}
