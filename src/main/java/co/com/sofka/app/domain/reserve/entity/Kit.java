package co.com.sofka.app.domain.reserve.entity;

import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.value.KitId;
import co.com.sofka.app.domain.reserve.value.Medicine;
import co.com.sofka.app.domain.reserve.value.Supplie;
import co.com.sofka.domain.generic.Entity;

public class Kit extends Entity<KitId> {
    protected Type type;
    protected Medicine medicine;
    protected Supplie supplie;

    public Kit(KitId kitId, Type type, Medicine medicine, Supplie supplie) {
        super(kitId);
        this.type = type;
        this.medicine = medicine;
        this.supplie = supplie;
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
