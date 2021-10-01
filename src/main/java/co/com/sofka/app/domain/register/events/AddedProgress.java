package co.com.sofka.app.domain.register.events;

import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.register.value.BreathingFrequency;
import co.com.sofka.app.domain.register.value.Observation;
import co.com.sofka.app.domain.register.value.ProgressId;
import co.com.sofka.app.domain.register.value.Temperature;
import co.com.sofka.domain.generic.DomainEvent;


public class AddedProgress extends DomainEvent {
    private final ProgressId progressId;
    private final Status status;
    private final Temperature temperature;
    private final BreathingFrequency breathingFrequency;
    private final Observation observation;

    public AddedProgress(ProgressId progressId, Status status, Temperature temperature, BreathingFrequency breathingFrequency, Observation observation) {
        super("domain.register.addedprogress");
        this.progressId = progressId;
        this.status = status;
        this.temperature = temperature;
        this.breathingFrequency = breathingFrequency;
        this.observation = observation;
    }

    public ProgressId getProgressId() {
        return progressId;
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
