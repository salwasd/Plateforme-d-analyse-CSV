package ma.backend.service;

import ma.backend.model.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeeCSVParserService {
    public List<Employee> parseCSV(FileReader file) throws IOException {
        List<Employee> employees = new ArrayList<>();

        try (CSVParser parser = new CSVParser(file, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                Employee employee = new Employee(
                        Long.parseLong(record.get("id")),
                        record.get("employee_name"),
                        record.get("job_title"),
                        Double.parseDouble(record.get("salary"))
                );
                employees.add(employee);
            }
        }

        return employees;
    }
}
