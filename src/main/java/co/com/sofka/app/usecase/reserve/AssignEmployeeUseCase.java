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
        reserve.assignEmployee(command.getEmployeeId(), command.getIdType(), command.getName(), command.getPhoneNumber(),command.getLicense());

        emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
    }
}
