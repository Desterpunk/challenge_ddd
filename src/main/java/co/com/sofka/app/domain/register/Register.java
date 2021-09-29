package co.com.sofka.app.domain.register;
import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.entity.Doctor;
import co.com.sofka.app.domain.register.entity.Progress;
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
    }

    private Register(RegisterId registerId) {
        super(registerId);
    }

    public static Register from(RegisterId registerId, List<DomainEvent> events){
        var register = new Register(registerId);
        events.forEach(register::applyEvent);
        return register;
    }
}
