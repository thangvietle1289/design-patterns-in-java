package edu.miko.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
  public List<Employee> getEmployeeList() {

    List<Employee> employees = new ArrayList<>();

    Employee employeeFromDB = new EmployeeDB("1234", "John", "Wick", "john@wick.com");

    // no adapter since employee-db cls imps employee ntrfc
    employees.add(employeeFromDB);

    EmployeeLdap employeeFromLdap = new EmployeeLdap("chewie", "Solo", "Han", "han@solo.com");

    // use adapter to get convert employee-ldap ntrfc to employee ntrfc
    employees.add(new EmployeeAdapterLdap(employeeFromLdap));

    EmployeeCSV employeeFromCSV = new EmployeeCSV("567,Sherlock,Holmes,sherlock@holmes.com");

    // use adapter to get convert employee-csv ntrfc to employee ntrfc
    employees.add(new EmployeeAdapterCSV(employeeFromCSV));

    return employees;
  }
}
