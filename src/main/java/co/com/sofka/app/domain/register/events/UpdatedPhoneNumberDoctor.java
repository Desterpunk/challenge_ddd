package co.com.sofka.app.domain.register.events;

import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.DoctorId;

import co.com.sofka.domain.generic.DomainEvent;



public class UpdatedPhoneNumberDoctor extends DomainEvent {
    private final DoctorId doctorId;
    private final PhoneNumber phoneNumber;

    public UpdatedPhoneNumberDoctor(DoctorId doctorId, PhoneNumber phoneNumber) {
        super("domain.register.updatedphonenumberpatient");
        this.doctorId = doctorId;
        this.phoneNumber = phoneNumber;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
