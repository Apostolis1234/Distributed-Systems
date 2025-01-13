package gr.hua.lab.syst.totallab.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="client_profile_id", referencedColumnName = "id")
    private ClientProfile clientProfile;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})

    @JoinTable(  name="case_client",
            joinColumns = @JoinColumn(name="client_id"),
            inverseJoinColumns = @JoinColumn(name="case_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"client_id", "case_id"})

    )

    private List<Case> cases;

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    ClientProfile getClientProfile() {
        return clientProfile;
    }

    public String getAddress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client(String address, String surname, String name, int id, String email) {
        this.address = address;
        this.surname = surname;
        this.name = name;
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
