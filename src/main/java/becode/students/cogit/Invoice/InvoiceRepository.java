package becode.students.cogit.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    Optional<Invoice> findById(int id);
    Optional<Invoice> findByCompanyID(int id_company);
    Optional<Invoice> findByRef(String ref);
}
