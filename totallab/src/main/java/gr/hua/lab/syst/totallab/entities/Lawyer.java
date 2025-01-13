package gr.hua.lab.syst.totallab.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    private List<Case> cases;

    public void setCases(List<Case> courses) {
        this.cases = cases;
    }

    @OneToMany(mappedBy = "lawyer", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
     private List<Case> getCases() {return cases;}


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Lawyer(List<Case> cases, String phone, String last_name, String first_name, int id, String email) {
        this.cases = cases;
        this.phone = phone;
        this.last_name = last_name;
        this.first_name = first_name;
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "cases=" + cases +
                ", id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
