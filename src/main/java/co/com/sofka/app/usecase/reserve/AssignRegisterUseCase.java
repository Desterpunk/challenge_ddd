package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.commands.AssignRegister;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AssignRegisterUseCase extends UseCase<RequestCommand<AssignRegister>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AssignRegister> assignRegisterRequestCommand) {
        var command = assignRegisterRequestCommand.getCommand();
        var reserve = Reserve.from(command.getReserveId(), retrieveEvents(command.getRegisterId().value()));
        reserve.assignRegister(command.getRegisterId());

        emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
    }
}
