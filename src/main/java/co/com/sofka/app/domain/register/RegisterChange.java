package co.com.sofka.app.domain.register;

import co.com.sofka.app.domain.register.entity.Doctor;
import co.com.sofka.app.domain.register.events.AddedDoctor;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.events.AssignedPatient;
import co.com.sofka.domain.generic.EventChange;

public class RegisterChange extends EventChange {
    public RegisterChange (Register register){
        apply((AddedRegister event) ->
            register.day = event.getDay()
        );

        apply((AddedDoctor event) -> {
            register.doctors.add(new Doctor(
                    event.getDoctorId(),
                    event.getIdType(),
                    event.getName(),
                    event.getPhoneNumber(),
                    event.getSpecialty()
            ));
        });

        apply((AssignedPatient event) -> {
            register.patientId = event.getPatientId();
        });
    }
}
