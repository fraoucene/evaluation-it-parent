package com.fraoucene.evaluation.it.api.model;

import javax.persistence.*;

/**
 * Created by fraoucene on 05/12/2015.
 */

@Entity
@Table(name = "USERS", schema = "evaluation_it")
public class Users {

    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "evaluation_it.SEQ_USERS")
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "company_id", referencedColumnName = "company_id")})
    private Companies company;

    @Column(name = "civility")
    private String civility;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "contact_email")
    private String contactEmail;

    public Users(String civility, String lastName, String firstname, String contactEmail) {
        this.setCivility(civility);
        this.setLastName(lastName);
        this.setFirstname(firstname);
        this.setContactEmail(contactEmail);
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != null ? !userId.equals(users.userId) : users.userId != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        return !(firstname != null ? !firstname.equals(users.firstname) : users.firstname != null);

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "civility='" + civility + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstname='" + firstname + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", userId=" + userId +
                '}';
    }
}
