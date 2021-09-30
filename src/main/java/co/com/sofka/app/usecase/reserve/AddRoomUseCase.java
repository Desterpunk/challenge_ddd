package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.Reserve;
import co.com.sofka.app.domain.reserve.commands.AddRoom;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddRoomUseCase extends UseCase<RequestCommand<AddRoom>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddRoom> addRoomRequestCommand) {
        var command = addRoomRequestCommand.getCommand();
        var room = Reserve.from(command.getReserveId(), retrieveEvents(command.getReserveId().value()));
        room.addRoom(
                command.getRoomId(),
                command.getType(),
                command.getStatus(),
                command.getBedsAmount());
        emit().onResponse(new ResponseEvents(room.getUncommittedChanges()));
    }
}
