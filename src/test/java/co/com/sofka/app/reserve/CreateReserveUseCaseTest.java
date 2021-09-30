package co.com.sofka.app.reserve;

import co.com.sofka.app.domain.generic.Day;
import co.com.sofka.app.domain.reserve.commands.CreateReserve;
import co.com.sofka.app.domain.reserve.events.AddedReserve;
import co.com.sofka.app.domain.reserve.value.PaymentStatus;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.usecase.reserve.CreateReserveUseCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateReserveUseCaseTest {
    private CreateReserveUseCase createReserveUseCase;

    @BeforeEach
    public void setup(){
        createReserveUseCase = new CreateReserveUseCase();
    }

    @Test
    void createReserveHappyPath(){
        var command = new CreateReserve(
                ReserveId.of("01"),
                new Day(new Date(1999,01,9)),
                new PaymentStatus(true)
        );

        //Act
        var response = UseCaseHandler.getInstance().syncExecutor(
                createReserveUseCase, new RequestCommand<>(command)).orElseThrow();

        var event = response.getDomainEvents();

        //Assert
        AddedReserve addedReserve = (AddedReserve) event.get(0);
        Assertions.assertEquals(1999,addedReserve.getDay().value.getYear());
        Assertions.assertEquals(01, addedReserve.getDay().value.getMonth());
        Assertions.assertEquals(9, addedReserve.getDay().value.getDate());
        Assertions.assertEquals(true, addedReserve.getPaymentStatus().value);
    }

}
