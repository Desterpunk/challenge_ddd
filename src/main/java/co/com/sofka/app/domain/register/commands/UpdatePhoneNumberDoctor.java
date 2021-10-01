package co.com.sofka.app.domain.register.commands;

import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.DoctorId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.domain.generic.Command;

public class UpdatePhoneNumberDoctor implements Command {
    private final RegisterId registerId;
    private final DoctorId doctorId;
    private final PhoneNumber phoneNumber;

    public UpdatePhoneNumberDoctor(RegisterId registerId, DoctorId doctorId, PhoneNumber phoneNumber) {
        this.registerId = registerId;
        this.doctorId = doctorId;
        this.phoneNumber = phoneNumber;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
