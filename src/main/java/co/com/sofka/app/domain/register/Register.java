package co.com.sofka.app.domain.register;
import co.com.sofka.app.domain.generic.*;
import co.com.sofka.app.domain.register.entity.Doctor;
import co.com.sofka.app.domain.register.entity.Progress;
import co.com.sofka.app.domain.register.events.*;
import co.com.sofka.app.domain.register.value.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Register extends AggregateEvent<RegisterId>{
    protected PatientId patientId;
    protected Day day;
    protected Set<Doctor> doctors;
    protected Set<Progress> progresses;

    public Register(RegisterId registerId, Day day){
        super(registerId);
        appendChange(new AddedRegister(day)).apply();
    }

    private Register(RegisterId registerId) {
        super(registerId);
        subscribe(new RegisterChange(this));
    }

    public static Register from(RegisterId registerId, List<DomainEvent> events){
        var register = new Register(registerId);
        events.forEach(register::applyEvent);
        return register;
    }

    public PatientId getPatientId() {
        return patientId;
    }

    public Day getDay() {
        return day;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public Set<Progress> getProgresses() {
        return progresses;
    }

    protected Optional<Doctor> getDoctorById(DoctorId doctorId){
        return doctors
                .stream()
                .filter(doctor -> doctor.identity().equals(doctorId))
                .findFirst();
    }

    public void assignPatient(PatientId patientId){
        appendChange(new AssignedPatient(patientId)).apply();
    }

    public void addDoctor(DoctorId doctorId, IdType idType, Name name, PhoneNumber phoneNumber, Specialty specialty){
        Objects.requireNonNull(doctorId);
        Objects.requireNonNull(idType);
        Objects.requireNonNull(name);
        Objects.requireNonNull(phoneNumber);
        Objects.requireNonNull(specialty);
        appendChange(new AddedDoctor(doctorId, idType, name, phoneNumber, specialty)).apply();
    }

    public void addProgress(ProgressId progressId, Status status, Temperature temperature, BreathingFrequency breathingFrequency, Observation observation){
        Objects.requireNonNull(progressId);
        Objects.requireNonNull(status);
        Objects.requireNonNull(temperature);
        Objects.requireNonNull(breathingFrequency);
        Objects.requireNonNull(observation);
        appendChange(new AddedProgress(progressId,status,temperature,breathingFrequency,observation)).apply();
    }

    public void updatePhoneNumberDoctor(DoctorId doctorId, PhoneNumber phoneNumber){
        Objects.requireNonNull(doctorId);
        Objects.requireNonNull(phoneNumber);
        appendChange(new UpdatedPhoneNumberDoctor(doctorId,phoneNumber)).apply();
    }
}
