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
                new Day(new Date(2021,9,8)),
                new PaymentStatus(true)
        );

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(createReserveUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        AddedReserve event = (AddedReserve) events.get(0);
        Assertions.assertEquals(2021,event.getDay().date.getYear());
        Assertions.assertEquals(9, event.getDay().date.getMonth());
        Assertions.assertEquals(8, event.getDay().date.getDate());
        Assertions.assertEquals(true, event.getPaymentStatus().status);
    }

}
