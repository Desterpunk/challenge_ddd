package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Temperature implements ValueObject<Double> {
    private final Double value;

    public Temperature(Double value){
        this.value = Objects.requireNonNull(value, "La Temperature es necesaria");
        if (this.value < 1 || this.value > 99){
            throw new IllegalArgumentException("La Temperatura tiene entre 1 y 2 carácteres");
        }
    }
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature temperature = (Temperature) o;
        return Objects.equals(value, temperature.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
