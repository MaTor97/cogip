package becode.students.cogit.Contacts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Optional<Contact> findByCompanyId(int companyId);
    Optional<Contact> findTop5ByOrderByCreatedAtDesc();
    Page<Contact> findAllByOrderByCreatedAtAsc(Pageable pageable);
    Optional<Contact> findById(int id);
}
