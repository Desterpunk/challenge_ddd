package co.com.sofka.app.register;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.commands.AssignPatient;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.events.AssignedPatient;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.commands.AssignEmployee;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.events.AssignedEmployee;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.usecase.register.AssignPatientUseCase;
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

public class AssignPatientUseCaseTest {
    private AssignPatientUseCase assignPatientUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        assignPatientUseCase = new AssignPatientUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        assignPatientUseCase.addRepository(repository);
    }

    @Test
    void assignPatientHappyPath(){
        var command = new AssignPatient(
                RegisterId.of("01"),
                PatientId.of("01")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(assignPatientUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AssignedPatient event = (AssignedPatient) events.get(0);
        Assertions.assertEquals("01",event.getPatientId().value());
        Mockito.verify(repository).getEventsBy(ArgumentMatchers.any());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedRegister(
                        new Day(new Date(1999,1,8)))
        );
    }
}
