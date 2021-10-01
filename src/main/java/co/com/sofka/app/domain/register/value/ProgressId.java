package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.Identity;

public class ProgressId extends Identity {
    public ProgressId(){

    }

    public ProgressId(String id){
        super(id);
    }

    public static ProgressId of(String id){
        return new ProgressId(id);
    }
}
