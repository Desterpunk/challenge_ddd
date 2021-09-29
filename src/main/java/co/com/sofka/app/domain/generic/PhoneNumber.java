package co.com.sofka.app.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PhoneNumber implements ValueObject<String> {
    public final String value;

    public PhoneNumber(String value){
        this.value = Objects.requireNonNull(value, "El numero de telefono es necesario");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El numero de telefono es necesario");
        }
        if (this.value.length() < 5 || this.value.length() > 15){
            throw new IllegalArgumentException("El numero de telefono tiene entre 6 y 9 caracteres Ej: +573213391742");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return Objects.equals(value, phoneNumber.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
