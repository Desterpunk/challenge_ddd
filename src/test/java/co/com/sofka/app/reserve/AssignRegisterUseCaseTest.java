package co.com.sofka.app.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.commands.AddRoom;
import co.com.sofka.app.domain.reserve.commands.AssignRegister;
import co.com.sofka.app.domain.reserve.commands.CreateReserve;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.events.AddedRoom;
import co.com.sofka.app.domain.reserve.events.AssignedRegister;
import co.com.sofka.app.domain.reserve.value.BedsAmount;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.domain.reserve.value.RoomId;
import co.com.sofka.app.usecase.reserve.AddRoomUseCase;
import co.com.sofka.app.usecase.reserve.AssignRegisterUseCase;
import co.com.sofka.app.usecase.reserve.CreateReserveUseCase;
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

public class AssignRegisterUseCaseTest {
    private AssignRegisterUseCase assignRegisterUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        assignRegisterUseCase = new AssignRegisterUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        assignRegisterUseCase.addRepository(repository);
    }

    @Test
    void addRoomHappyPath(){
        var command = new AssignRegister(
                ReserveId.of("01"),
                new RegisterId("01")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(assignRegisterUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AssignedRegister event = (AssignedRegister) events.get(0);
        Assertions.assertEquals("01",event.getRegisterId().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedReserve(
                        new Day(new Date(1999,1,8)),
                        new PaymentStatus(true))
        );
    }
}
