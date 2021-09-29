package co.com.sofka.app.domain.register.value;

import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BreathingFrequency implements ValueObject<Integer> {
    private final Integer value;

    public BreathingFrequency(Integer value){
        this.value = Objects.requireNonNull(value, "La frecuencia respiratoria es necesaria");
        if (this.value < 1 || this.value > 99){
            throw new IllegalArgumentException("La frecuencia respiratoria tiene entre 1 y 2 carácteres");
        }
    }
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreathingFrequency breathingFrequency = (BreathingFrequency) o;
        return Objects.equals(value, breathingFrequency.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
