package gr.hua.lab.syst.totallab.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Case {


    private int id;

    private String lawyer;

    private String title;

    private String description;


    private List<Client> clients;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLawyer() {
        return lawyer;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Case(String description, String lawyer, String title, int id) {
        this.description = description;
        this.lawyer = lawyer;
        this.title = title;
        this.id = id;
    }



    @Override
    public String toString() {
        return "Case{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", lawyer='" + lawyer + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
