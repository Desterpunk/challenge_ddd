package co.com.sofka.app.domain.reserve.commands;

import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.value.BedsAmount;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.domain.reserve.value.RoomId;
import co.com.sofka.domain.generic.Command;

public class AddRoom implements Command {
    private final ReserveId reserveId;
    private final RoomId roomId;
    private final Type type;
    private final Status status;
    private final BedsAmount bedsAmount;

    public AddRoom(ReserveId reserveId, RoomId roomId, Type type, Status status, BedsAmount bedsAmount){
        this.reserveId = reserveId;
        this.roomId = roomId;
        this.type = type;
        this.status = status;
        this.bedsAmount = bedsAmount;
    }

    public ReserveId getReserveId() {
        return reserveId;
    }

    public RoomId getRoomId() {
        return roomId;
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
