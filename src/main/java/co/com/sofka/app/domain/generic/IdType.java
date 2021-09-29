package co.com.sofka.app.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IdType implements ValueObject<String>{
    private final String value;

    public IdType(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El Tipo de identificación es necesaria");
        }
        if (this.value.length() <= 0 || this.value.length() > 2){
            throw new IllegalArgumentException("El tipo de identificación tiene entre 1 y 2 carácteres Ej: CC,TI");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdType idType = (IdType) o;
        return Objects.equals(value, idType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
