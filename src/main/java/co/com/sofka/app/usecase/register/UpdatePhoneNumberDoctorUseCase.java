package co.com.sofka.app.usecase.register;

import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.register.commands.UpdatePhoneNumberDoctor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class UpdatePhoneNumberDoctorUseCase extends UseCase<RequestCommand<UpdatePhoneNumberDoctor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePhoneNumberDoctor> updatePhoneNumberDoctorRequestCommand) {
        var command = updatePhoneNumberDoctorRequestCommand.getCommand();
        var register = Register.from(command.getRegisterId(), retrieveEvents(command.getRegisterId().value()));

        try {
            register.updatePhoneNumberDoctor(
                    command.getDoctorId(),
                    command.getPhoneNumber()
            );
            emit().onResponse(new ResponseEvents(register.getUncommittedChanges()));
        } catch (Exception e){
            emit().onError(new RuntimeException("No se encontro un doctor con ese id"));
        }

    }
}
