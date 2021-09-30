package co.com.sofka.app.domain.register;

import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.domain.generic.EventChange;

public class RegisterChange extends EventChange {
    public RegisterChange (Register register){
        apply((AddedRegister event) ->
            register.day = event.getDay()
        );
    }
}
