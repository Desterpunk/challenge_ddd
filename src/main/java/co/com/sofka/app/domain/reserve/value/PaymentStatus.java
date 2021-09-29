package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PaymentStatus implements ValueObject<Boolean> {
    public final Boolean value;
    public PaymentStatus(Boolean value){
        this.value = Objects.requireNonNull(value, "El estado de pago es necesario");
    }
    public Boolean value() {
        return value;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentStatus paymentStatus = (PaymentStatus) o;
        return Objects.equals(value, paymentStatus.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
