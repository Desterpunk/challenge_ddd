package co.com.sofka.app.usecase.register;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.register.commands.CreateRegister;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import java.util.Date;

public class CreateRegisterUseCase extends UseCase<RequestCommand<CreateRegister>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateRegister> createRegisterRequestCommand) {
        var command = createRegisterRequestCommand.getCommand();
        Date actualDate = new Date();
        actualDate.setYear(actualDate.getYear()+1900);

        Register register;
        if (command.getDay().date.before(actualDate)){
            register = new Register(
                    command.getRegisterId(),
                    new Day(actualDate)
            );
        } else {
            register = new Register(
                    command.getRegisterId(),
                    command.getDay()
            );
        }
        emit().onResponse(new ResponseEvents(register.getUncommittedChanges()));
    }
}
