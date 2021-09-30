package co.com.sofka.app.domain.register.commands;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.domain.generic.Command;

public class CreateRegister implements Command{
    private final RegisterId registerId;
    private final Day day;

    public CreateRegister(RegisterId registerId, Day day){
        this.registerId = registerId;
        this.day = day;
    }

    public RegisterId getRegisterId() {
        return registerId;
    }

    public Day getDay() {
        return day;
    }
}
