package gr.hua.lab.syst.totallab.service;


import gr.hua.lab.syst.totallab.entities.Client;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    public Client getClient(Integer clientId) {
        return clientRepository.findById(clientId).get();
    }


}
