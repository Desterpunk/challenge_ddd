package co.com.sofka.app.domain.register.entity;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.DoctorId;
import co.com.sofka.app.domain.register.value.Specialty;
import co.com.sofka.domain.generic.Entity;

public class Doctor extends Entity<DoctorId> {
    protected IdType idType;
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected Specialty specialty;

    public Doctor(DoctorId entityId, IdType idType, Name name, PhoneNumber phoneNumber, Specialty specialty) {
        super(entityId);
        this.idType = idType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
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

    public Specialty getSpecialty() {
        return specialty;
    }
}
