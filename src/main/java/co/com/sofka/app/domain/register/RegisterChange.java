package co.com.sofka.app.domain.register;

import co.com.sofka.app.domain.register.entity.Doctor;
import co.com.sofka.app.domain.register.entity.Progress;
import co.com.sofka.app.domain.register.events.AddedDoctor;
import co.com.sofka.app.domain.register.events.AddedProgress;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.events.AssignedPatient;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class RegisterChange extends EventChange {
    public RegisterChange (Register register){
        apply((AddedRegister event) -> {
            register.day = event.getDay();
            register.doctors = new HashSet<>();
            register.progresses = new HashSet<>();
        });

        apply((AddedDoctor event) -> {
            register.doctors.add(new Doctor(
                    event.getDoctorId(),
                    event.getIdType(),
                    event.getName(),
                    event.getPhoneNumber(),
                    event.getSpecialty()
            ));
        });

        apply((AddedProgress event) -> {
            register.progresses.add(new Progress(
                    event.getProgressId(),
                    event.getStatus(),
                    event.getTemperature(),
                    event.getBreathingFrequency(),
                    event.getObservation()
            ));
        });

        apply((AssignedPatient event) -> {
            register.patientId = event.getPatientId();
        });
    }
}
