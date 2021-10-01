package co.com.sofka.app.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PhoneNumber implements ValueObject<String> {
    public final String string;

    public PhoneNumber(String value){
        this.string = Objects.requireNonNull(value, "El numero de telefono es necesario");
        if (this.string.isBlank()){
            throw new IllegalArgumentException("El numero de telefono es necesario");
        }
        if (this.string.length() < 5 || this.string.length() > 15){
            throw new IllegalArgumentException("El numero de telefono tiene entre 6 y 9 caracteres Ej: +573213391742");
        }
    }
    public String value() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return Objects.equals(string, phoneNumber.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
