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
    public List<CompanyDTO> getAll() {
        return companyService.getCompanies();
    }

    @GetMapping(path = "id")
    public CompanyDTO get(@RequestParam(name = "id", required = true) int id) {
        return  companyService.getCompany(id);
    }

    @PostMapping(path = "new")
    public void addCompany(@RequestBody Company company) {

        companyService.addCompany(company);
    }
    @GetMapping(path = "last5")
    public List<CompanyDTO> getLast5() {
        return companyService.getLast5Companies();
    }
    @GetMapping(path = "paginated")
    public List<CompanyDTO> getPaginatedCompanies(
            @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return companyService.getCompaniesByPage(page,size);
    }
}
