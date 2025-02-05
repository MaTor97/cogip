package becode.students.cogit.Company;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/company")
public class CompanyController {
    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping(path ="all")
    public List<Company> getAll() {
        return companyService.getCompanies();
    }
    @PostMapping(path = "new")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }
}
