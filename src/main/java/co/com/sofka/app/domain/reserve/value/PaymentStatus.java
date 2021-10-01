package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaymentStatus implements ValueObject<Boolean> {
    public final Boolean status;
    public PaymentStatus(Boolean value){
        this.status = Objects.requireNonNull(value, "El estado de pago es necesario");
    }
    public Boolean value() {
        return status;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentStatus paymentStatus = (PaymentStatus) o;
        return Objects.equals(status, paymentStatus.status);
    }
    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

}
