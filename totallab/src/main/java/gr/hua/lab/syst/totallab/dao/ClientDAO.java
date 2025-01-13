package gr.hua.lab.syst.totallab.dao;

import gr.hua.lab.syst.totallab.entities.Client;

import java.util.List;

public interface ClientDAO {

    public List<Client> getClients();
    public Client getClient(Integer client_id);
    public void saveClient(Client client);
    public void deleteClient(Integer client_id);
}
}
