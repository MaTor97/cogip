package becode.students.cogit.Invoice;

import becode.students.cogit.Contacts.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    Optional<Invoice> findById(int id);
    Optional<Invoice> findByCompanyId(int id_company);
    Optional<Invoice> findByRef(String ref);
    List<Invoice> findTop5ByOrderByCreatedAtDesc();
}
