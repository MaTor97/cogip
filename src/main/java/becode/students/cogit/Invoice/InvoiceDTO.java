package becode.students.cogit.Invoice;

import java.time.LocalDateTime;

public class InvoiceDTO {
    private Integer id;
    private String ref;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private Integer companyId;
    private String companyName;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Integer id, String ref, LocalDateTime dueDate, LocalDateTime createdAt, Integer companyId, String companyName) {
        this.id = id;
        this.ref = ref;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
