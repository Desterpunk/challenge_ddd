package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.commands.AssignEmployee;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AssignEmployeeUseCase extends UseCase<RequestCommand<AssignEmployee>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AssignEmployee> assignEmployeeRequestCommand) {
        var command = assignEmployeeRequestCommand.getCommand();
        var reserve = Reserve.from(command.getReserveId(), retrieveEvents(command.getEmployeeId().value()));
        try {
            reserve.assignEmployee(command.getEmployeeId());
            emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
        } catch (Exception e){
            emit().onError(new RuntimeException("No se encontro un empleado con ese id"));
        }

    }
}
