package co.com.sofka.app.domain.register.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Specialty implements ValueObject<String> {
    private final String value;

    public Specialty(String value){
        this.value = Objects.requireNonNull(value, "La especialidad es necesaria");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La especialidad es necesaria");
        }
        if (this.value.length() < 3 || this.value.length() >= 20){
            throw new IllegalArgumentException("La especialidad tiene entre 4 y 20 carácteres");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(value, specialty.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
