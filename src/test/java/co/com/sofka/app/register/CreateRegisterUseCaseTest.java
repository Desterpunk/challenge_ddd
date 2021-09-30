package co.com.sofka.app.register;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.register.commands.CreateRegister;
import co.com.sofka.app.domain.register.events.AddedRegister;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.usecase.register.CreateRegisterUseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateRegisterUseCaseTest {
    private CreateRegisterUseCase createRegisterUseCase;

    @BeforeEach
    public void setUp(){
        createRegisterUseCase = new CreateRegisterUseCase();
    }

    @Test
    void createRegisterHappyPath(){
        var command = new CreateRegister(
                RegisterId.of("01"),
                new Day(new Date(2021,10,8))
        );

        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                createRegisterUseCase, new RequestCommand<>(command)).orElseThrow();
        var event = response.getDomainEvents();

        //Assert
        AddedRegister addedRegister = (AddedRegister) event.get(0);
        Assertions.assertEquals(2021, addedRegister.getDay().value.getYear());
        Assertions.assertEquals(10, addedRegister.getDay().value.getMonth());
        Assertions.assertEquals(8, addedRegister.getDay().value.getDate());
    }
}
