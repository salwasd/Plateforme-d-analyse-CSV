package ma.backend.model;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String name;
    private String jobTitle;
    private double salary;

    public Employee(long id, String name, String jobTitle, double salary) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
}
