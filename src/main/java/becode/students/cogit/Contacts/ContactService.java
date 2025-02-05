package becode.students.cogit.Contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    final private ContactRepository contactRepository;

    @Autowired

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    public Contact getContactByCompany(int companyId) {
        Optional<Contact> companyContact = contactRepository.findById(companyId);
        return companyContact.orElse(null);
    }
}
