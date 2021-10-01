package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.commands.AddKit;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddKitUseCase extends UseCase<RequestCommand<AddKit>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddKit> addKitRequestCommand) {
        var command = addKitRequestCommand.getCommand();
        var reserve = Reserve.from(command.getReserveId(), retrieveEvents(command.getReserveId().value()));
        reserve.addKit(
                command.getKitId(),
                command.getType(),
                command.getMedicine(),
                command.getSupplie());
        emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
    }
}
