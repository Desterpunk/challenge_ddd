package co.com.sofka.app.domain.register.commands;

import co.com.sofka.app.domain.generic.Status;
import co.com.sofka.app.domain.register.value.*;
import co.com.sofka.domain.generic.Command;

public class AddProgress implements Command {
    private final RegisterId registerId;
    private final ProgressId progressId;
    private final Status status;
    private final Temperature temperature;
    private final BreathingFrequency breathingFrequency;
    private final Observation observation;

    public AddProgress(RegisterId registerId, ProgressId progressId, Status status, Temperature temperature, BreathingFrequency breathingFrequency, Observation observation) {
        this.registerId = registerId;
        this.progressId = progressId;
        this.status = status;
        this.temperature = temperature;
        this.breathingFrequency = breathingFrequency;
        this.observation = observation;
    }

    public RegisterId getRegisterId() {
        return registerId;
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
