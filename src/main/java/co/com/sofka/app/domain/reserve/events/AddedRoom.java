package co.com.sofka.app.domain.reserve.events;

import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.value.BedsAmount;
import co.com.sofka.app.domain.reserve.value.RoomId;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedRoom extends DomainEvent {
    private final RoomId roomId;
    private final Type kind;
    private final Status status;
    private final BedsAmount bedsAmount;

    public AddedRoom(RoomId roomId, Type type, Status status, BedsAmount bedsAmount) {
        super("domain.reserve.addedroom");
        this.roomId = roomId;
        this.kind = type;
        this.status = status;
        this.bedsAmount = bedsAmount;
    }

    public RoomId getRoomId() {
        return roomId;
    }

    public Type getKind() {
        return kind;
    }

    public Status getStatus() {
        return status;
    }

    public BedsAmount getBedsAmount() {
        return bedsAmount;
    }
}
