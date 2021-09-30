package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.commands.CreateReserve;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Date;

public class CreateReserveUseCase extends UseCase<RequestCommand<CreateReserve>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateReserve> createReserveRequestCommand) {
        var command = createReserveRequestCommand.getCommand();
        Date actualDate = new Date();
        actualDate.setYear(actualDate.getYear()+1900);
        Reserve reserve;
        if (command.getDay().value.before(actualDate)){
            reserve = new Reserve(command.getReserveId(),
                    new Day(actualDate),
                    command.getPaymentStatus());
        } else {
            reserve = new Reserve(command.getReserveId(),
                    command.getDay(),
                    command.getPaymentStatus());
        }

        emit().onResponse(new ResponseEvents(reserve.getUncommittedChanges()));
    }
}
