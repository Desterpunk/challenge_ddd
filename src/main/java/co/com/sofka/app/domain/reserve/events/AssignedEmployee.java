package co.com.sofka.app.domain.reserve.events;


import co.com.sofka.app.domain.reserve.value.EmployeeId;

import co.com.sofka.domain.generic.DomainEvent;

public class AssignedEmployee extends DomainEvent {
    private final EmployeeId employeeId;

    public AssignedEmployee(EmployeeId employeeId){
        super("domain.reserve.assignedemployee");
        this.employeeId = employeeId;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }
}
