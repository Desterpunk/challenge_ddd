package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.Identity;

public class RegisterId extends Identity {
    public RegisterId(){

    }

    private RegisterId(String id){
        super(id);
    }

    public static RegisterId of(String id){
        return new RegisterId(id);
    }
}
