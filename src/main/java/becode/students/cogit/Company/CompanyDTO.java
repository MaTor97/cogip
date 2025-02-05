package becode.students.cogit.Company;

public class CompanyDTO {
    private Integer id;
    private String name;
    private Integer typeId;
    private String typeName;
    private String country;
    private String tva;

    public CompanyDTO(Integer id, String name,Integer typeId, String typeName, String country, String tva) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
        this.country = country;
        this.tva = tva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }
}