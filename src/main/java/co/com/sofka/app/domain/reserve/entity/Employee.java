package co.com.sofka.app.domain.reserve.entity;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.License;
import co.com.sofka.domain.generic.Entity;

public class Employee extends Entity<EmployeeId> {
    protected IdType idType;
    protected Name name;
    protected PhoneNumber phoneNumber;
    protected License license;

    public Employee(EmployeeId entityId, IdType idType, Name name, PhoneNumber phoneNumber, License license) {
        super(entityId);
        this.idType = idType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.license = license;
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
