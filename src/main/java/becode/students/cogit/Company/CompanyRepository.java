package becode.students.cogit.Company;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByTva(String tva);
    List<Company> findTop5ByOrderByCreatedAtDesc();
    Page<Company> findByOrderByCreatedAtAsc(Pageable pageable);
    Optional<Company> findById(int id);
}
