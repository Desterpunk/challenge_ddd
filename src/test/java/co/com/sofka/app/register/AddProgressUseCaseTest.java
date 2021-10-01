package co.com.sofka.app.register;

import co.com.sofka.app.domain.generic.*;
import co.com.sofka.app.domain.register.commands.AddDoctor;
import co.com.sofka.app.domain.register.commands.AddProgress;
import co.com.sofka.app.domain.register.events.AddedDoctor;
import co.com.sofka.app.domain.register.events.AddedProgress;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.value.*;
import co.com.sofka.app.usecase.register.AddDoctorUseCase;
import co.com.sofka.app.usecase.register.AddProgressUseCase;
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

public class AddProgressUseCaseTest {
    private AddProgressUseCase addProgressUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        addProgressUseCase = new AddProgressUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        addProgressUseCase.addRepository(repository);
    }

    @Test
    void addProgressHappyPath(){
        var command = new AddProgress(
                RegisterId.of("01"),
                new ProgressId("2121"),
                new Status("mejorando"),
                new Temperature(42.0),
                new BreathingFrequency(20),
                new Observation("El paciente va mejorando")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(addProgressUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AddedProgress event = (AddedProgress) events.get(0);
        Assertions.assertEquals("2121", event.getProgressId().value());
        Assertions.assertEquals("mejorando", event.getStatus().value());
        Assertions.assertEquals(42.0, event.getTemperature().value());
        Assertions.assertEquals(20, event.getBreathingFrequency().value());
        Assertions.assertEquals("El paciente va mejorando", event.getObservation().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedRegister(
                        new Day(new Date(1999,01,18))
                ));
    }
}
