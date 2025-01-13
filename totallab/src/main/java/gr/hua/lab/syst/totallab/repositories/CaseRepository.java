package gr.hua.lab.syst.totallab.repositories;


import gr.hua.lab.syst.totallab.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, Integer> {
}
