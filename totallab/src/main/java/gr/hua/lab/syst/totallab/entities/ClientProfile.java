package gr.hua.lab.syst.totallab.entities;

import jakarta.persistence.*;

@Entity
@Table
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "homeTown")
    private String homeTown;

    @Column(name = "roadName")
    private String roadName;

    @Column(name = "roadId")
    private int roadId;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "motherName")
    private String motherName;

    @OneToOne(mappedBy = "clientProfile", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    private Client client;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getRoadId() {
        return roadId;
    }

    public void setRoadId(int roadId) {
        this.roadId = roadId;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientProfile(Client client, String roadName, int roadId, String motherName, int id, String homeTown, String fatherName) {
        this.client = client;
        this.roadName = roadName;
        this.roadId = roadId;
        this.motherName = motherName;
        this.id = id;
        this.homeTown = homeTown;
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "ClientProfile{" +
                "client=" + client +
                ", id=" + id +
                ", homeTown='" + homeTown + '\'' +
                ", roadName='" + roadName + '\'' +
                ", roadId=" + roadId +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                '}';
    }
}
