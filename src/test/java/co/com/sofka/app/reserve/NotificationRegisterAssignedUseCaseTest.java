package co.com.sofka.app.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.commands.AssignEmployee;
import co.com.sofka.app.domain.reserve.commands.AssignRegister;
import co.com.sofka.app.domain.reserve.events.*;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.License;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.usecase.reserve.AssignEmployeeUseCase;
import co.com.sofka.app.usecase.reserve.NotificationRegisterAssignedUseCase;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class NotificationRegisterAssignedUseCaseTest {
    private NotificationRegisterAssignedUseCase notificationRegisterAssignedUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        notificationRegisterAssignedUseCase = new NotificationRegisterAssignedUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        notificationRegisterAssignedUseCase.addRepository(repository);
    }

    @Test
    void notificationRegisterAssignedHappyPath(){
        var aggregateId = "xxx-xxx";
        var event = new AssignedRegister(new RegisterId("01"));
        event.setAggregateRootId(aggregateId);

        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(notificationRegisterAssignedUseCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        SentNotification actualEvent = (SentNotification) events.get(0);
        Assertions.assertEquals("Assigned register",actualEvent.getMessage());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedReserve(
                        new Day(new Date(1999,1,8)),
                        new PaymentStatus(true))
        );
    }

}