package co.com.sofka.app.domain.reserve.value;


import co.com.sofka.domain.generic.Identity;

public class EmployeeId extends Identity {
    public EmployeeId(){

    }

    public EmployeeId(String id){
        super(id);
    }

    public static EmployeeId of(String id){
        return new EmployeeId(id);
    }
}
