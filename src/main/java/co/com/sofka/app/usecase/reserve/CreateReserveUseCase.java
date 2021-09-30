package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.commands.CreateReserve;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CreateReserveUseCase extends UseCase<RequestCommand<CreateReserve>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateReserve> createReserveRequestCommand) {
        var command = createReserveRequestCommand.getCommand();
        var reserve = new Reserve(command.getReserveId(),
                                  command.getDay(),
                                  command.getPaymentStatus());
        emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
    }
}
