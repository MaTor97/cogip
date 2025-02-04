package becode.students.cogit.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository CompanyRepository) {
        this.companyRepository = CompanyRepository;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(Company company) {
        Optional<Company> companyTva = companyRepository.findByTva(company.getTva());
        if(companyTva.isPresent()){
            throw new IllegalStateException("Company TVA already exists");
        }
        companyRepository.save(company);
    }
}
