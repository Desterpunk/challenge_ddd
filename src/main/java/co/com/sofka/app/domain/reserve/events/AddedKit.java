package co.com.sofka.app.domain.reserve.events;

import co.com.sofka.app.domain.generic.Type;
import co.com.sofka.app.domain.reserve.value.KitId;
import co.com.sofka.app.domain.reserve.value.Medicine;
import co.com.sofka.app.domain.reserve.value.Supplie;
import co.com.sofka.domain.generic.DomainEvent;

public class AddedKit extends DomainEvent {
    private final KitId kitId;
    private final Type kind;
    private final Medicine medicine;
    private final Supplie supplie;

    public AddedKit(KitId kitId, Type type, Medicine medicine, Supplie supplie) {
        super("domain.reserve.addedkit");
        this.kitId = kitId;
        this.kind = type;
        this.medicine = medicine;
        this.supplie = supplie;
    }

    public KitId getKitId() {
        return kitId;
    }

    public Type getKind() {
        return kind;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public Supplie getSupplie() {
        return supplie;
    }
}
