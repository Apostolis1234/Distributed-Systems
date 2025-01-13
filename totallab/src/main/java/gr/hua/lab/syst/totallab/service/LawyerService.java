package gr.hua.lab.syst.totallab.service;


import gr.hua.lab.syst.totallab.entities.Lawyer;
import gr.hua.lab.syst.totallab.repositories.CaseRepository;
import gr.hua.lab.syst.totallab.repositories.LawyerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawyerService {

    private LawyerRepository lawyerRepository;

    private CaseRepository caseRepository;

    public LawyerService(LawyerRepository lawyerRepository, CaseRepository caseRepository) {
        this.lawyerRepository = lawyerRepository;
        this.caseRepository = caseRepository;
    }
    @Transactional
    public List<Lawyer> getLawyers(){
        return lawyerRepository.findAll();
    }
    @Transactional
    public Lawyer getLawyer(Integer lawyerId) {
        return lawyerRepository.findById(lawyerId).get();
    }
    @Transactional
    public void saveLawyer(Lawyer lawyer) {
        lawyerRepository.save(lawyer);
    }
}
