package gr.hua.lab.syst.totallab.service;


import gr.hua.lab.syst.totallab.entities.Case;
import gr.hua.lab.syst.totallab.entities.Lawyer;
import gr.hua.lab.syst.totallab.repositories.CaseRepository;
import gr.hua.lab.syst.totallab.repositories.LawyerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    private CaseRepository caseRepository;

    private LawyerRepository lawyerRepository;

    public CaseService(CaseRepository caseRepository, LawyerRepository lawyerRepository) {
        this.caseRepository = caseRepository;
        this.lawyerRepository = lawyerRepository;
    }

    @Transactional
    public List<Case> getCases(){
        return caseRepository.findAll();
    }

    @Transactional
    public void saveCase(Case case) {
        caseRepository.save(case);
    }

    @Transactional
    public Case getCase(Integer courseId) {
        return caseRepository.findById(caseId).get();
    }

    @Transactional
    public void assignLawyerToCase(int caseId, Lawyer lawyer) {
        Case case = caseRepository.findById(caseId).get();
        System.out.println(case);
        System.out.println(case.getLawyer());
        case.setLawyer(lawyer);
        System.out.println(case.getLawyer());
        caseRepository.save(case);
    }

    @Transactional
    public void unassignLawyerFromCase(int caseId) {
        Case case = caseRepository.findById(caseId).get();
        case.setLawyer(null);
        caseRepository.save(case);
    }

    @Transactional
    public void assignClientToCase(int caseId, Client client) {
        Case case = caseRepository.findById(caseId).get();
        case.addClient(client);
        System.out.println("Case clients: ");
        System.out.println(case.getClients());
        caseRepository.save(case);
    }
}
