package ma.backend.service;
import ma.backend.model.AverageSalaryModel;
import ma.backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeProcessingService {
    public List<AverageSalaryModel> calculateAverageSalaryByJobTitle(List<Employee> employees) {
//        return employees.stream()
//                .collect(Collectors.groupingBy(Employee::getJobTitle,
//                        Collectors.averagingDouble(Employee::getSalary)));
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getJobTitle,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream()
                .map(entry -> new AverageSalaryModel(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}
