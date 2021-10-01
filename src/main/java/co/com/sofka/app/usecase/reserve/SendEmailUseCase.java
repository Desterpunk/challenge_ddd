package co.com.sofka.app.usecase.reserve;

import co.com.sofka.app.domain.reserve.events.SentNotification;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class SendEmailUseCase extends UseCase<TriggeredEvent<SentNotification>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<SentNotification> sentNotificationTriggeredEvent) {
        var event = sentNotificationTriggeredEvent.getDomainEvent();
        var service = this.getService(SentEmailService.class).orElseThrow();
        var isOk = service.sendEmail("admin@hospital.com.co", "Notification assign register", event.getMessage());
        if (!isOk){
            emit().onError(new BusinessException(
                    event.aggregateRootId(),
                    "The email could not be sent"
            ));
        }
    }
}
