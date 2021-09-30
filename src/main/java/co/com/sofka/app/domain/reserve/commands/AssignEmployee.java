package co.com.sofka.app.domain.reserve.commands;

import co.com.sofka.app.domain.generic.IdType;
import co.com.sofka.app.domain.generic.Name;
import co.com.sofka.app.domain.generic.PhoneNumber;
import co.com.sofka.app.domain.register.value.RegisterId;
import co.com.sofka.app.domain.reserve.value.EmployeeId;
import co.com.sofka.app.domain.reserve.value.License;
import co.com.sofka.app.domain.reserve.value.ReserveId;
import co.com.sofka.domain.generic.Command;

public class AssignEmployee implements Command {
    private final ReserveId reserveId;
    private final EmployeeId employeeId;
    private IdType idType;
    private Name name;
    private PhoneNumber phoneNumber;
    private License license;

    public AssignEmployee(ReserveId reserveId, EmployeeId employeeId){
        this.reserveId = reserveId;
        this.employeeId = employeeId;
    }

    public ReserveId getReserveId() {
        return reserveId;
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
