package com.cracking.coding.interview.ood.callcenter;

import com.cracking.coding.interview.ood.callcenter.model.Director;
import com.cracking.coding.interview.ood.callcenter.model.Employee;
import com.cracking.coding.interview.ood.callcenter.model.Manager;
import com.cracking.coding.interview.ood.callcenter.model.Respondent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CallCenter {
    private final List<Employee> employees;

    public CallCenter() {
        this.employees = IntStream.range(0, 3)
                .mapToObj(i -> new Respondent())
                .collect(Collectors.toList());

        IntStream.range(0, 2)
                .mapToObj(i -> new Manager())
                .forEach(employees::add);

        IntStream.range(0, 1)
                .mapToObj(i -> new Director())
                .forEach(employees::add);
    }

    public void dispatchCall() {
        String callId = UUID.randomUUID().toString();
        System.out.println("Dispatching call with id: " + callId);

        Optional<Employee> optionalRespondent = findFirst(Respondent.class);

        if (optionalRespondent.isPresent()) {
            attendCall(optionalRespondent.get(), callId);
        } else {
            assignCallToManager(callId);
        }
    }

    private void assignCallToManager(String callId) {
        Optional<Employee> manager = findFirst(Manager.class);

        if (manager.isPresent()) {
            attendCall(manager.get(), callId);
        } else {
            assignCallToDirector(callId);
        }
    }

    private void assignCallToDirector(String callId) {
        Optional<Employee> director = findFirst(Director.class);

        if (director.isPresent()) {
            attendCall(director.get(), callId);
        } else {
            System.out.println("Please call later, all of our employees are busy at the moment");
        }
    }

    private <T> Optional<Employee> findFirst(Class<T> employeeType) {
        return employees.stream()
                .filter(employee -> employee.getClass().equals(employeeType))
                .filter(Employee::isFree)
                .findFirst();
    }

    private void attendCall(Employee employee, String callId) {
        Thread thread = new Thread(() -> employee.attendCall(callId));
        thread.start();
    }
}
