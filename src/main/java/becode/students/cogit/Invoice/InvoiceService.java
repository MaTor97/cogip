package becode.students.cogit.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    public Invoice getInvoice(int id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if(invoice.isEmpty()) {
            throw new IllegalStateException("Invoice not found");
        }
        return invoice.get();
    }
    public Invoice getInvoiceByCompany(int companyId) {
        Optional<Invoice> invoices = invoiceRepository.findByCompanyId(companyId);
        if (invoices.isEmpty()) {
            throw new IllegalStateException("Not invoice found for this company");
        }
        return invoices.get();
    }
    public void insertInvoice(Invoice invoice) {
        Optional<Invoice> invoiceRef = invoiceRepository.findByRef(invoice.getRef());
        if (invoiceRef.isEmpty()) {
            throw new IllegalStateException("This reference already exists");
        }
        invoiceRepository.save(invoice);
    }
}
