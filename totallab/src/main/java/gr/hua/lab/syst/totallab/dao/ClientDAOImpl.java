package gr.hua.lab.syst.totallab.dao;

import gr.hua.lab.syst.totallab.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Client> getClients() {
        TypedQuery<Client> query = entityManager.createQuery("from Client", Client.class);
        return query.getResultList();

    }

    @Override
    public Client getClient(Integer client_id) {
        return entityManager.find(Client.class, client_id);
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        System.out.println("client " + client.getId());
        if (client.getId() == null) {
            entityManager.persist(client);
        } else {
            entityManager.merge(client);
        }
    }

    @Override
    @Transactional
    public void deleteClient(Integer client_id) {
        System.out.println("Deleting client with id: " + client_id);
        entityManager.remove(entityManager.find(Client.class, client_id));
    }

}


