package co.com.sofka.app.domain.reserve.entity;

import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.value.BedsAmount;
import co.com.sofka.app.domain.reserve.value.RoomId;
import co.com.sofka.domain.generic.Entity;

public class Room extends Entity<RoomId> {
    protected Type type;
    protected Status status;
    protected BedsAmount bedsAmount;

    public Room(RoomId entityId, Type type, Status status, BedsAmount bedsAmount) {
        super(entityId);
        this.type = type;
        this.status = status;
        this.bedsAmount = bedsAmount;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public BedsAmount getBedsAmount() {
        return bedsAmount;
    }
}
