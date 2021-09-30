package co.com.sofka.app.domain.register;
import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.entity.Doctor;
import co.com.sofka.app.domain.register.entity.Progress;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
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

    public static Register from(RegisterId registerId, List<DomainEvent> events){
        var register = new Register(registerId);
        events.forEach(register::applyEvent);
        return register;
    }
}
