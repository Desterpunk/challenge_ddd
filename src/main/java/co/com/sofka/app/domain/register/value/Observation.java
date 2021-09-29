package co.com.sofka.app.domain.register.value;

import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observation implements ValueObject<String> {
    private final String value;

    public Observation(String value){
        this.value = Objects.requireNonNull(value, "La observacion es necesaria");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La observacion es necesaria");
        }
        if (this.value.length() < 3 || this.value.length() >= 50){
            throw new IllegalArgumentException("La observacion tiene entre 4 y 50 carácteres");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observation observation = (Observation) o;
        return Objects.equals(value, observation.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
