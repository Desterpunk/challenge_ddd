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
}
