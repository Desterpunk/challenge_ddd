package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.Identity;

public class PatientId extends Identity {
    public PatientId(){

    }

    private PatientId(String id){
        super(id);
    }

    public static PatientId of(String id){
        return new PatientId(id);
    }
}
