package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.domain.generic.Identity;

public class KitId extends Identity {
    public KitId(){

    }

    public KitId(String id){
        super(id);
    }

    public static KitId of(String id){
        return new KitId(id);
    }
}
