package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.domain.generic.Identity;

public class ReserveId extends Identity {
    public ReserveId(){

    }

    private ReserveId(String id){
        super(id);
    }

    public static ReserveId of(String id){
        return new ReserveId(id);
    }
}
