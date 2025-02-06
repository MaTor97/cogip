package becode.students.cogit.Contacts;

import becode.students.cogit.Company.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    final private ContactRepository contactRepository;

    @Autowired

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactDTO> getContactByCompany(int companyId) {
        Optional<Contact> companyContact = contactRepository.findById(companyId);
        if(companyContact.isEmpty()){
            throw new IllegalStateException("No contact for company id ");
        }
        return companyContact.stream()
                .map(contact -> new ContactDTO(
                        contact.getId(),
                        contact.getName(),
                        contact.getPhone(),
                        contact.getEmail(),
                        contact.getCreatedAt(),
                        contact.getCompany().getId(),
                        contact.getCompany().getName()
                ))
        .toList();
    }

    public List<ContactDTO> getContacts(){
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> new ContactDTO(
                        contact.getId(),
                        contact.getName(),
                        contact.getPhone(),
                        contact.getEmail(),
                        contact.getCreatedAt(),
                        contact.getCompany().getId(),
                        contact.getCompany().getName()
                )).toList();
    }

    public ContactDTO getContact(int id){
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if(contactOptional.isEmpty()){
            throw new IllegalStateException("No contact for id ");
        }
        Contact contact = contactOptional.get();
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getCreatedAt(),
                contact.getCompany().getId(),
                contact.getCompany().getName()
        );
    }

    public void addContact(Contact contact){
        contactRepository.save(contact);
    }

    public List<ContactDTO> getLast5Contacts(){
        return contactRepository.findTop5ByOrderByCreatedAtDesc().stream()
                .map(contact -> new ContactDTO(
                        contact.getId(),
                        contact.getName(),
                        contact.getPhone(),
                        contact.getEmail(),
                        contact.getCreatedAt(),
                        contact.getCompany().getId(),
                        contact.getCompany().getName()
                )).toList();
    }

    public List<ContactDTO> getContactsByPage(int page, int size){
        Page<Contact> contactPage = contactRepository.findAll(PageRequest.of(page, size));
        return contactPage.getContent().stream()
                .map(contact -> new ContactDTO(
                        contact.getId(),
                        contact.getName(),
                        contact.getPhone(),
                        contact.getEmail(),
                        contact.getCreatedAt(),
                        contact.getCompany().getId(),
                        contact.getCompany().getName()
                ))
                .toList();
    }
}
