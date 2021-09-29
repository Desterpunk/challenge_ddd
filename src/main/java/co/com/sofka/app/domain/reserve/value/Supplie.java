package co.com.sofka.app.domain.reserve.value;

import co.com.sofka.app.domain.register.value.Observation;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Supplie implements ValueObject<String> {
    private final String value;

    public Supplie(String value){
        this.value = Objects.requireNonNull(value, "El suplemento es necesario");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El suplemento es necesario");
        }
        if (this.value.length() < 3 || this.value.length() >= 50){
            throw new IllegalArgumentException("El suplemento tiene entre 4 y 50 carácteres");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplie supplie = (Supplie) o;
        return Objects.equals(value, supplie.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
