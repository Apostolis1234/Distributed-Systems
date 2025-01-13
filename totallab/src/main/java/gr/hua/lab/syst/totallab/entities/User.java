package gr.hua.lab.syst.totallab.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.HashSet;
import java.util.Set;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 60)
    private String username;

    @NotBlank
    @Size(max = 150)
    private String password;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public @NotBlank @Size(max = 60) @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Size(max = 60) @Email String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public @NotBlank @Size(max = 60) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank @Size(max = 60) String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 150) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(max = 150) String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
}
