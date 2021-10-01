package co.com.sofka.app.domain.reserve.commands;

import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.value.KitId;
import co.com.sofka.app.domain.reserve.value.Medicine;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.app.domain.reserve.value.Supplie;
import co.com.sofka.domain.generic.Command;

public class AddKit implements Command {
    private final ReserveId reserveId;
    private final KitId kitId;
    private final Type type;
    private final Medicine medicine;
    private final Supplie supplie;

    public AddKit(ReserveId reserveId, KitId kitId, Type type, Medicine medicine, Supplie supplie) {
        this.reserveId = reserveId;
        this.kitId = kitId;
        this.type = type;
        this.medicine = medicine;
        this.supplie = supplie;
    }

    public ReserveId getReserveId() {
        return reserveId;
    }

    public KitId getKitId() {
        return kitId;
    }

    public Type getType() {
        return type;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public Supplie getSupplie() {
        return supplie;
    }
}
