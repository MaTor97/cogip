package becode.students.cogit.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository CompanyRepository) {
        this.companyRepository = CompanyRepository;
    }

    public List<CompanyDTO> getCompanies() {
        return companyRepository.findAll().stream()
                .map(company -> new CompanyDTO(
                        company.getId(),
                        company.getName(),
                        company.getType() != null ? company.getType().getId() : null,
                        company.getType() != null ? company.getType().getName() : null,
                        company.getCountry(),
                        company.getTva()
                ))
                .collect(Collectors.toList());
    }

    public void addCompany(Company company) {
        Optional<Company> companyTva = companyRepository.findByTva(company.getTva());
        if(companyTva.isPresent()){
            throw new IllegalStateException("Company TVA already exists");
        }
        companyRepository.save(company);
    }
}
