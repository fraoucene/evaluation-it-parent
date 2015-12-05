package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fraoucene on 05/12/2015.
 */

@Entity
@Table(name = "COMPANIES", schema = "evaluation_it")
public class Companies {
    private static final long serialVersionUID = 62188039214295171L;

    public Companies(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_COMPANIES")
    @Column(name = "company_id")
    private Long companyId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Users> users = new HashSet<>();

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "country")
    private String country;

    @Column(name = "ville")
    private String ville;

    public Companies(String lastName, String firstName, String contactEmail, String companyName, String country, String ville) {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setContactEmail(contactEmail);
        this.setCompanyName(companyName);
        this.setCountry(country);
        this.setVille(ville);
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies = (Companies) o;

        if (companyId != null ? !companyId.equals(companies.companyId) : companies.companyId != null) return false;
        if (lastName != null ? !lastName.equals(companies.lastName) : companies.lastName != null) return false;
        return !(firstName != null ? !firstName.equals(companies.firstName) : companies.firstName != null);

    }

    @Override
    public int hashCode() {
        int result = companyId != null ? companyId.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                ", ville='" + ville + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
