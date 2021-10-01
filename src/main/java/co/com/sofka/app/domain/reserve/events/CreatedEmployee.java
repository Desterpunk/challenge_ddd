package co.com.sofka.app.domain.reserve.events;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.Eps;
import co.com.sofka.app.domain.register.value.PatientId;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.License;
import co.com.sofka.domain.generic.DomainEvent;

public class CreatedEmployee extends DomainEvent {
    private final EmployeeId employeeId;
    private final IdType idType;
    private final Name name;
    private final PhoneNumber phoneNumber;
    private final License license;

    public CreatedEmployee(EmployeeId employeeId, IdType idType, Name name, PhoneNumber phoneNumber, License license){
        super("domain.register.createdemployee");
        this.employeeId = employeeId;
        this.idType = idType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.license = license;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public IdType getIdType() {
        return idType;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public License getLicense() {
        return license;
    }
}
