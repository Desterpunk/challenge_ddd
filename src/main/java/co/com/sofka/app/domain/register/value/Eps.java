package co.com.sofka.app.domain.register.value;

import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Eps implements ValueObject<String> {
    private final String value;

    public Eps(String value){
        this.value = Objects.requireNonNull(value, "La Eps es necesaria");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La Eps es necesaria");
        }
        if (this.value.length() < 3 || this.value.length() >= 20){
            throw new IllegalArgumentException("La Eps tiene entre 4 y 20 carácteres");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eps eps = (Eps) o;
        return Objects.equals(value, eps.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
