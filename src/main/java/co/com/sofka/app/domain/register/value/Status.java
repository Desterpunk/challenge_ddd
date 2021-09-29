package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Status implements ValueObject<String> {
    private final String value;

    public Status(String value){
        this.value = Objects.requireNonNull(value, "El estado es necesario");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El estado es necesario");
        }
        if (this.value.length() < 3 || this.value.length() >= 20){
            throw new IllegalArgumentException("La estado tiene entre 4 y 20 carácteres");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(value, status.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
