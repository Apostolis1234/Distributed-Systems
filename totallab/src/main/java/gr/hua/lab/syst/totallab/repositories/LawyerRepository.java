package gr.hua.lab.syst.totallab.repositories;

import gr.hua.lab.syst.totallab.entities.Lawyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface LawyerRepository extends JpaRepository<Lawyer, Integer> {
}
