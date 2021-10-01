package co.com.sofka.app.usecase.register;

import co.com.sofka.app.domain.register.Register;
import co.com.sofka.app.domain.register.commands.AssignPatient;
import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AssignPatientUseCase extends UseCase<RequestCommand<AssignPatient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignPatient> assignPatientRequestCommand) {
        var command = assignPatientRequestCommand.getCommand();
        var register = Register.from(command.getRegisterId(), retrieveEvents(command.getPatientId().value()));
        try {
            register.assignPatient(command.getPatientId());
            emit().onResponse(new ResponseEvents(register.getUncommittedChanges()));
        } catch (Exception e){
            emit().onError(new RuntimeException("No se encontro un paciente con ese id"));
        }

    }
}
