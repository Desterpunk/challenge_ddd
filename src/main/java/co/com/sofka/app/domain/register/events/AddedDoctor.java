package co.com.sofka.app.domain.register.events;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.DoctorId;
import co.com.sofka.app.domain.register.value.Specialty;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedDoctor extends DomainEvent {
    private final DoctorId doctorId;
    private final IdType idType;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Specialty specialty;

    public AddedDoctor(DoctorId doctorId, IdType idType, Name name, PhoneNumber phoneNumber, Specialty specialty) {
        super("domain.register.addeddoctor");
        this.doctorId = doctorId;
        this.idType = idType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    public DoctorId getDoctorId() {
        return doctorId;
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
