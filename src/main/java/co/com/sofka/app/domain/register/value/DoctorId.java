package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.Identity;

public class DoctorId extends Identity {
    public DoctorId(){

    }

    private DoctorId(String id){
        super(id);
    }

    public static DoctorId of(String id){
        return new DoctorId(id);
    }
}
