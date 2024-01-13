package ma.backend.controller;

import ma.backend.Utilities;
import ma.backend.model.Employee;
import ma.backend.service.EmployeeProcessingService;
import ma.backend.service.EmployeeCSVParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeCSVParserService csvParserService;

    @Autowired
    private EmployeeProcessingService processingService;


    @PostMapping("/process-csv")
    public ResponseEntity<Map<String, Object>> processCsv(@RequestParam("file") MultipartFile multipartFile) {
        try {
            File file = Utilities.MultipartFileToFile(multipartFile);
            List<Employee> employees = csvParserService.parseCSV(new FileReader(file));
//            Map<String, Double> averageSalaries = processingService.calculateAverageSalaryByJobTitle(employees);
            var averageSalaries = processingService.calculateAverageSalaryByJobTitle(employees);

            Map<String, Object> response = Map.of(
                    "employees", employees,
                    "averageSalaries", averageSalaries
            );

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
