package co.com.sofka.app.domain.register.entity;

import co.com.sofka.app.domain.register.value.*;
import co.com.sofka.domain.generic.Entity;

public class Progress extends Entity<ProgressId> {
    protected Status status;
    protected Temperature temperature;
    protected BreathingFrequency breathingFrequency;
    protected Observation observation;

    public Progress(ProgressId entityId, Status status, Temperature temperature, BreathingFrequency breathingFrequency, Observation observation) {
        super(entityId);
        this.status = status;
        this.temperature = temperature;
        this.breathingFrequency = breathingFrequency;
        this.observation = observation;
    }

    public Status getStatus() {
        return status;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public BreathingFrequency getBreathingFrequency() {
        return breathingFrequency;
    }

    public Observation getObservation() {
        return observation;
    }
}
