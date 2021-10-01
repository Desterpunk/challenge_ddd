package co.com.sofka.app.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.commands.AddRoom;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.events.AddedRoom;
import co.com.sofka.app.domain.reserve.value.BedsAmount;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.domain.reserve.value.RoomId;
import co.com.sofka.app.usecase.reserve.AddRoomUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;


class AddRoomUseCaseTest {
    private AddRoomUseCase addRoomUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        addRoomUseCase = new AddRoomUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        addRoomUseCase.addRepository(repository);
    }

    @Test
    void addRoomHappyPath(){
        var command = new AddRoom(
                ReserveId.of("01"),
                new RoomId("01"),
                new Type("normal"),
                new Status("clean and fresh"),
                new BedsAmount(1)
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(addRoomUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AddedRoom event = (AddedRoom) events.get(0);
        Assertions.assertEquals("01",event.getRoomId().value());
        Assertions.assertEquals("normal",event.getKind().value());
        Assertions.assertEquals("clean and fresh",event.getStatus().value());
        Assertions.assertEquals(1,event.getBedsAmount().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedReserve(
                        new Day(new Date(1999,1,8)),
                        new PaymentStatus(true))
        );
    }
}
