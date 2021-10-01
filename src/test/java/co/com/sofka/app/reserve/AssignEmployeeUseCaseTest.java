package co.com.sofka.app.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.commands.AssignEmployee;
import co.com.sofka.app.domain.reserve.commands.AssignRegister;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.events.AssignedEmployee;
import co.com.sofka.app.domain.reserve.events.AssignedRegister;
import co.com.sofka.app.domain.reserve.events.CreatedEmployee;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.License;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.usecase.reserve.AssignEmployeeUseCase;
import co.com.sofka.app.usecase.reserve.AssignRegisterUseCase;
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

class AssignEmployeeUseCaseTest {
    private AssignEmployeeUseCase assignEmployeeUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        assignEmployeeUseCase = new AssignEmployeeUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        assignEmployeeUseCase.addRepository(repository);
    }

    @Test
    void assignEmployeeHappyPath(){
        var command = new AssignEmployee(
                ReserveId.of("01"),
                EmployeeId.of("015")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(assignEmployeeUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AssignedEmployee event = (AssignedEmployee) events.get(0);
        Assertions.assertEquals("015",event.getEmployeeId().value());
        Mockito.verify(repository).getEventsBy(ArgumentMatchers.any());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedReserve(
                        new Day(new Date(1999,1,8)),
                        new PaymentStatus(true)),
                new CreatedEmployee(
                        new EmployeeId("015"),
                        new IdType("CC"),
                        new Name("maria"),
                        new PhoneNumber("2123123123"),
                        new License("1231232")
                )
        );
    }
}
