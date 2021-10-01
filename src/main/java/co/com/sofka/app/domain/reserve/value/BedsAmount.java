package co.com.sofka.app.domain.reserve.value;


import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BedsAmount implements ValueObject<Integer> {
    private final Integer value;

    public BedsAmount(Integer value){
        this.value = Objects.requireNonNull(value, "La cantidad de camas es necesaria");
        if (this.value < 1 || this.value > 99){
            throw new IllegalArgumentException("La cantidad de camas tiene entre 1 o 2 carácteres");
        }
    }
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BedsAmount bedsAmount = (BedsAmount) o;
        return Objects.equals(value, bedsAmount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
