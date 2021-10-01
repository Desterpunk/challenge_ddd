package co.com.sofka.app.register;


import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.commands.AddDoctor;
import co.com.sofka.app.domain.register.events.AddedDoctor;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.value.DoctorId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.register.value.Specialty;
import co.com.sofka.app.usecase.register.AddDoctorUseCase;
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

class AddDoctorUseCaseTest {
    private AddDoctorUseCase addDoctorUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        addDoctorUseCase = new AddDoctorUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        addDoctorUseCase.addRepository(repository);
    }

    @Test
    void addDoctorHappyPath(){
        var command = new AddDoctor(
                RegisterId.of("01"),
                new DoctorId("1011212"),
                new IdType("RC"),
                new Name("Carlos"),
                new PhoneNumber("212121155"),
                new Specialty("Neurologic")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(addDoctorUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        AddedDoctor event = (AddedDoctor) events.get(0);
        Assertions.assertEquals("1011212", event.getDoctorId().value());
        Assertions.assertEquals("RC", event.getIdType().value());
        Assertions.assertEquals("Carlos", event.getName().value());
        Assertions.assertEquals("212121155", event.getPhoneNumber().value());
        Assertions.assertEquals("Neurologic", event.getSpecialty().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedRegister(
                        new Day(new Date(1999,01,18))
        ));
    }
}
