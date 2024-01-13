package ma.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AverageSalaryModel {
    String jobTitle;
    Double averageSalary;
}
