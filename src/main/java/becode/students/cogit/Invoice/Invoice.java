package becode.students.cogit.Invoice;

import becode.students.cogit.Company.Company;
import jakarta.persistence.*;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class Invoice {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ref;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @CreatedDate
    private LocalDateTime created_at;
    @LastModifiedDate
    private LocalDateTime updated_at;

    public Invoice() {
    }

    public Invoice(String ref, Company company) {
        this.ref = ref;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", company=" + company +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
