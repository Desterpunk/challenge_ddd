package co.com.sofka.app.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<String> {
    private final String value;

    public Type(String value){
        this.value = Objects.requireNonNull(value, "El tipo es necesario");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El tipo es necesario");
        }
        if (this.value.length() < 2 || this.value.length() >= 50){
            throw new IllegalArgumentException("El tipo tiene entre 3 y 50 caracteres");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(value, type.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
