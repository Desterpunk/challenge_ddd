package co.com.sofka.app.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.commands.AddKit;
import co.com.sofka.app.domain.reserve.events.AddedKit;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.value.*;
import co.com.sofka.app.usecase.reserve.AddKitUseCase;
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

class AddKitUseCaseTest {
    private AddKitUseCase addKitUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        addKitUseCase = new AddKitUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        addKitUseCase.addRepository(repository);
    }

    @Test
    void addKitHappyPath(){
        var command = new AddKit(
                ReserveId.of("01"),
                new KitId("01"),
                new Type("Urgency"),
                new Medicine("Acetaminophen"),
                new Supplie("serum")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(addKitUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AddedKit event = (AddedKit) events.get(0);
        Assertions.assertEquals("01",event.getKitId().value());
        Assertions.assertEquals("Urgency",event.getKind().value());
        Assertions.assertEquals("Acetaminophen",event.getMedicine().value());
        Assertions.assertEquals("serum",event.getSupplie().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedReserve(
                        new Day(new Date(1999,1,8)),
                        new PaymentStatus(true))
        );
    }
}
