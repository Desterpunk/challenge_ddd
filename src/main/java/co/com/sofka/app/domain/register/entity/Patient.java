package co.com.sofka.app.domain.register.entity;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.Eps;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.domain.generic.Entity;

public class Patient extends Entity<PatientId> {
    protected IdType idType;
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected Eps eps;

    public Patient(PatientId entityId, IdType idType, Name name, PhoneNumber phoneNumber, Eps eps) {
        super(entityId);
        this.idType = idType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.eps = eps;
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
