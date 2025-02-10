package becode.students.cogit.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(invoice -> new InvoiceDTO(
                        invoice.getId(),
                        invoice.getRef(),
                        invoice.getDueDate(),
                        invoice.getCreatedAt(),
                        invoice.getCompany().getId(),
                        invoice.getCompany().getName()
                )).toList();
    }

    public InvoiceDTO getInvoice(int id) {
        Optional<Invoice> invoiceData = invoiceRepository.findById(id);
        if(invoiceData.isEmpty()) {
            throw new IllegalStateException("Invoice not found");
        }
        Invoice invoice = invoiceData.get();
        return new InvoiceDTO(
                invoice.getId(),
                invoice.getRef(),
                invoice.getDueDate(),
                invoice.getCreatedAt(),
                invoice.getCompany().getId(),
                invoice.getCompany().getName()
        );
    }



    public List<InvoiceDTO> getInvoiceByCompany(int companyId) {
        Optional<Invoice> invoices = invoiceRepository.findByCompanyId(companyId);
        if (invoices.isEmpty()) {
            throw new IllegalStateException("Not invoice found for this company");
        }
        return invoices.stream()
                .map(invoice -> new InvoiceDTO(
                        invoice.getId(),
                        invoice.getRef(),
                        invoice.getDueDate(),
                        invoice.getCreatedAt(),
                        invoice.getCompany().getId(),
                        invoice.getCompany().getName()
                )).toList();
    }
    public void addInvoice(Invoice invoice) {
        Optional<Invoice> invoiceRef = invoiceRepository.findByRef(invoice.getRef());
        if (invoiceRef.isPresent()) {
            throw new IllegalStateException("This reference already exists");
        }
        invoiceRepository.save(invoice);
    }
    public List<InvoiceDTO> getLast5Invoices() {
        List<Invoice> invoices = invoiceRepository.findTop5ByOrderByCreatedAtDesc();
        if (invoices.isEmpty()) {
            throw new IllegalStateException("Not invoice found");
        }
        return invoices.stream()
                .map(invoice -> new InvoiceDTO(
                        invoice.getId(),
                        invoice.getRef(),
                        invoice.getDueDate(),
                        invoice.getCreatedAt(),
                        invoice.getCompany().getId(),
                        invoice.getCompany().getName()
                )).toList();
    }

    public List<InvoiceDTO> getInvoicesByPage(int page, int size) {
        Page<Invoice> invoices = invoiceRepository.findAll(PageRequest.of(page, size));
        if (invoices.isEmpty()){
            throw new IllegalStateException("Not invoice found");
        }
        return invoices.getContent().stream()
                .map(invoice -> new InvoiceDTO(
                        invoice.getId(),
                        invoice.getRef(),
                        invoice.getDueDate(),
                        invoice.getCreatedAt(),
                        invoice.getCompany().getId(),
                        invoice.getCompany().getName()
                )).toList();
    }
}
