package co.com.sofka.app.domain.reserve.value;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class License implements ValueObject<String> {
    private final String value;

    public License(String value){
        this.value = Objects.requireNonNull(value, "El numero de la licencia es necesario");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El numero de la licencia es necesario");
        }
        if (this.value.length() < 3 || this.value.length() >= 50){
            throw new IllegalArgumentException("El numero de la licencia tiene entre 4 y 50 carácteres");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return Objects.equals(value, license.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
