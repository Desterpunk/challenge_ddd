package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.domain.generic.Identity;

public class EmployeeId extends Identity {
    public EmployeeId(){

    }

    private EmployeeId(String id){
        super(id);
    }

    public static EmployeeId of(String id){
        return new EmployeeId(id);
    }
}
