package co.com.sofka.app.register;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.events.AssignedPatient;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.events.AssignedRegister;
import co.com.sofka.app.domain.reserve.events.SentNotification;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.usecase.register.NotificationPatientAssignedUseCase;
import co.com.sofka.app.usecase.reserve.NotificationRegisterAssignedUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

public class NotificationPatientAssignedUseCaseTest {
    private NotificationPatientAssignedUseCase notificationPatientAssignedUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        notificationPatientAssignedUseCase = new NotificationPatientAssignedUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        notificationPatientAssignedUseCase.addRepository(repository);
    }

    @Test
    void notificationPatientAssignedHappyPath(){
        var aggregateId = "xxx-xxx";
        var event = new AssignedPatient(new PatientId("01"));
        event.setAggregateRootId(aggregateId);

        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(notificationPatientAssignedUseCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        SentNotification actualEvent = (SentNotification) events.get(0);
        Assertions.assertEquals("Assigned patient",actualEvent.getMessage());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedRegister(
                        new Day(new Date(1999,1,8)))
        );
    }
}
