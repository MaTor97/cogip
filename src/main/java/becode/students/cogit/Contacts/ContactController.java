package becode.students.cogit.Contacts;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path ="all")
    public List<ContactDTO> getAll() {
        return contactService.getContacts();
    }

    @GetMapping(path = "id")
    public ContactDTO getContact(@RequestParam(name = "id", required = true) int id) {
        return  contactService.getContact(id);
    }

    @GetMapping(path = "from")
    public List<ContactDTO> getFrom(@RequestParam(name = "id", required = true) int id) {
        return contactService.getContactByCompany(id);
    }

    @PostMapping(path = "new")
    public void addContact(@RequestBody Contact contact) {

        contactService.addContact(contact);
    }
    @GetMapping(path = "last5")
    public List<ContactDTO> getLast5() {
        return contactService.getLast5Contacts();
    }
    @GetMapping(path = "paginated")
    public List<ContactDTO> getPaginatedContacts(
            @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return contactService.getContactsByPage(page,size);
    }
}
