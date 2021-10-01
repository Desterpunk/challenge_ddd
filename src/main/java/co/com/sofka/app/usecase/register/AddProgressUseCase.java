package co.com.sofka.app.usecase.register;

import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.register.commands.AddProgress;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddProgressUseCase extends UseCase<RequestCommand<AddProgress>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddProgress> addProgressRequestCommand) {
        var command = addProgressRequestCommand.getCommand();
        var register = Register.from(command.getRegisterId(), retrieveEvents(command.getRegisterId().value()));
        register.addProgress(
                command.getProgressId(),
                command.getStatus(),
                command.getTemperature(),
                command.getBreathingFrequency(),
                command.getObservation()
        );

        emit().onResponse(new ResponseEvents(register.getUncommittedChanges()));
    }
}
