package gr.hua.lab.syst.totallab.repositories;

import gr.hua.lab.syst.totallab.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
