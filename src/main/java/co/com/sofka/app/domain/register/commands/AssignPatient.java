package co.com.sofka.app.domain.register.commands;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.Eps;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.domain.generic.Command;

public class AssignPatient implements Command {
    private final RegisterId registerId;
    private final PatientId patientId;

    public AssignPatient(RegisterId registerId, PatientId patientId) {
        this.registerId = registerId;
        this.patientId = patientId;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }

    public PatientId getPatientId() {
        return patientId;
    }
}
