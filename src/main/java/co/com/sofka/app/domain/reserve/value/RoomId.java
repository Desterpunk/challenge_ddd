package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.domain.generic.Identity;

public class RoomId extends Identity {
    public RoomId(){

    }

    public RoomId(String id){
        super(id);
    }

    public static RoomId of(String id){
        return new RoomId(id);
    }
}
