package co.com.sofka.app.usecase.register;

import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.register.commands.AddDoctor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddDoctorUseCase extends UseCase<RequestCommand<AddDoctor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDoctor> addDoctorRequestCommand) {
        var command = addDoctorRequestCommand.getCommand();
        var register = Register.from(command.getRegisterId(), retrieveEvents(command.getRegisterId().value()));
        register.addDoctor(
                command.getDoctorId(),
                command.getIdType(),
                command.getName(),
                command.getPhoneNumber(),
                command.getSpecialty());
        emit().onResponse(new ResponseEvents(register.getUncommittedChanges()));
    }
}
