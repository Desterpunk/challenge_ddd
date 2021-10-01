package co.com.sofka.app.register;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.commands.UpdatePhoneNumberDoctor;
import co.com.sofka.app.domain.register.events.AddedDoctor;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.events.UpdatedPhoneNumberDoctor;
import co.com.sofka.app.domain.register.value.DoctorId;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.register.value.Specialty;
import co.com.sofka.app.usecase.register.UpdatePhoneNumberDoctorUseCase;
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

class UpdatePhoneNumberDoctorUseCaseTest {
    private UpdatePhoneNumberDoctorUseCase updatePhoneNumberDoctorUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        updatePhoneNumberDoctorUseCase = new UpdatePhoneNumberDoctorUseCase();
        repository = Mockito.mock(DomainEventRepository.class);
        updatePhoneNumberDoctorUseCase.addRepository(repository);
    }

    @Test
    void updatePhonenumberDoctorHappyPath(){
        var command = new UpdatePhoneNumberDoctor(
                RegisterId.of("01"),
                DoctorId.of("015"),
                new PhoneNumber("3154512542")
        );
        Mockito.when(repository.getEventsBy(ArgumentMatchers.any())).thenReturn(eventStored());

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("01")
                .syncExecutor(updatePhoneNumberDoctorUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        UpdatedPhoneNumberDoctor event = (UpdatedPhoneNumberDoctor) events.get(0);
        Assertions.assertEquals("3154512542", event.getPhoneNumber().value());
    }


    private List<DomainEvent> eventStored() {
        return List.of(
                new AddedRegister(
                        new Day(new Date(2022,01,18))
                ),
                new AddedDoctor(
                        new DoctorId("015"),
                        new IdType("TI"),
                        new Name("Juan"),
                        new PhoneNumber("32142224"),
                        new Specialty("surgeon")
                )
        );
    }
}
