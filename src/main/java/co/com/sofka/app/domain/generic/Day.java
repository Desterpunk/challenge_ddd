package co.com.sofka.app.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Day implements ValueObject<Date> {
    public final Date value;
    public Day(Date value){
        this.value = Objects.requireNonNull(value, "La fecha no puede estar vacia");
    }
    public Date value() {
        return value;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(value, day.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
