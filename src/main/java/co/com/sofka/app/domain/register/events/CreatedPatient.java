package co.com.sofka.app.domain.register.events;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.Eps;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.domain.generic.DomainEvent;

public class CreatedPatient extends DomainEvent {
    private final PatientId patientId;
    private final IdType idType;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Eps eps;

    public CreatedPatient(PatientId patientId, IdType idType, Name name, PhoneNumber phoneNumber, Eps eps){
        super("domain.register.assignedpatient");
        this.patientId = patientId;
        this.idType = idType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.eps = eps;
    }

    public PatientId getPatientId() {
        return patientId;
    }

    public IdType getIdType() {
        return idType;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Eps getEps() {
        return eps;
    }
}
