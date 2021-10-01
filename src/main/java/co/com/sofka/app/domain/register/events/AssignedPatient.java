package co.com.sofka.app.domain.register.events;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.Eps;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.domain.generic.DomainEvent;

public class AssignedPatient extends DomainEvent {
    private final PatientId patientId;

    public AssignedPatient(PatientId patientId){
        super("domain.register.assignedpatient");
        this.patientId = patientId;
    }

    public PatientId getPatientId() {
        return patientId;
    }
}
