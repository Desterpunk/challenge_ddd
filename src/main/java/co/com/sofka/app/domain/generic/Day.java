package co.com.sofka.app.domain.generic;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Day implements ValueObject<Date> {
    public final Date date;
    public Day(Date value){
        this.date = Objects.requireNonNull(value, "La fecha es necesaria");
    }
    public Date value() {
        return date;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return Objects.equals(date, day.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
