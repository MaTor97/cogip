package becode.students.cogit.Invoice;

import becode.students.cogit.Company.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(path = "new")
    public void addInvoice(@RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }

    @GetMapping(path = "all")
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping(path = "id")
    public InvoiceDTO getInvoiceById(@RequestParam(name = "id") int id) {
        return invoiceService.getInvoice(id);
    }

    @GetMapping(path = "from")
    public List<InvoiceDTO> getInvoiceByCompany(
            @RequestParam(name = "id") int id) {
        return invoiceService.getInvoiceByCompany(id);
    }

    @GetMapping(path = "last5")
    public List<InvoiceDTO> getLast5Invoices() {
        return invoiceService.getLast5Invoices();
    }

    @GetMapping(path = "paginated")
    public List<InvoiceDTO> getPaginatedInvoices(
            @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return invoiceService.getInvoicesByPage(page, size);
    }

}
