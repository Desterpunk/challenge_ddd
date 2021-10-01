package co.com.sofka.app.usecase.reserve;

public interface SentEmailService {
    Boolean sendEmail(String destinationEmail, String issue, String message);
}
