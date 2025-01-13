package gr.hua.lab.syst.totallab.controllers;


import gr.hua.lab.syst.totallab.entities.Case;
import gr.hua.lab.syst.totallab.entities.Client;
import gr.hua.lab.syst.totallab.entities.Lawyer;
import gr.hua.lab.syst.totallab.service.CaseService;
import gr.hua.lab.syst.totallab.service.ClientService;
import gr.hua.lab.syst.totallab.service.LawyerService;
import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("case")
public class CaseController {

    private final ClientService clientService;
    private CaseService caseService;


    private LawyerService lawyerService;

    public CaseController(ClientService clientService, LawyerService lawyerService, CaseService caseService) {
        this.clientService = clientService;
        this.lawyerService = lawyerService;
        this.caseService = caseService;
    }

  /*  Case c1 = new Case("Divorce between a man and a woman", "Jameson", "Divorce", 1);
    Case c2 = new Case("A father murdered his children", "Bryant", "Murder", 2);
    Case c3 = new Case("Two masked men walked into a bank", "Johnson", "Robbery", 3);
      caseService.saveCarse(c1);
      caseService.saveCase(c2);
     caseService.saveCase(c3); */

    @RequestMapping()
    public String showCases(Model model) {
        model.addAttribute("cases", caseService.getCases());
        return "case/cases";
    }

    @GetMapping("/{id}")
    public String showCase(@PathVariable Integer id, Model model){
        Case case = caseService.getCase(id);
        model.addAttribute("cases", case);
        return "case/cases";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/new")
    public String addCase(Model model){
        Case case = new Case();
        model.addAttribute("case", case);
        return "case/case";

    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/new")
    public String saveClient(@Valid @ModelAttribute("case")Case case, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            System.out.println("error");
            return "case/case";
        } else {
            caseService.saveCase(case);
            model.addAttribute("cases", caseService.getCases());
            model.addAttribute("successMessage", "Case added successfully!");
            return "case/cases";
        }

    }

    @GetMapping("/assign/{id}")
    public String showAssignLawyerToCourse(@PathVariable int id, Model model) {
        Case case = caseService.getCase(id);
        List<Lawyer> lawyers = lawyerService.getLawyers();
        model.addAttribute("case", case);
        model.addAttribute("lawyers", lawyers);
        return "case/assignlawyer";
    }

    @GetMapping("/unassign/{id}")
    public String unassignLawyerToCase(@PathVariable int id, Model model) {
        caseService.unassignLawyerFromCase(id);
        model.addAttribute("cases", caseService.getCases());
        return "case/cases";
    }

    @GetMapping("/clientassign/{id}")
    public String showAssignClientToCase(@PathVariable int id, Model model) {
        Case case = caseService.getCase(id);
        List<Client> clients = clientService.getClients();
        List<Client> existing_clients = case.getClients();
        clients.removeAll(existing_clients);
        model.addAttribute("case", case);
        model.addAttribute("clients", clients);
        return "case/assignclient";
    }

    @PostMapping("/assign/{id}")
    public String assignLawyerToCase(@PathVariable int id, @RequestParam(value = "lawyer", required = true) int lawyerId, Model model) {
        System.out.println(lawyerId);
        Lawyer lawyer = lawyerService.getLawyer(lawyerId);
        Case case = caseService.getCase(id);
        System.out.println(case);
        caseService.assignLawyerToCase(id, lawyer);
        model.addAttribute("cases", caseService.getCases());
        model.addAttribute("successMessage", "Form submitted successfully!");
        return "case/cases";
    }

    @PostMapping("/clientassign/{id}")
    public String assignClientToCase(@PathVariable int id, @RequestParam(value = "client", required = true) int clientId, Model model) {
        System.out.println(clientId);
        Client client = clientService.getClient(clientId);
        Case case = caseService.getCase(id);
        System.out.println(case);
        caseService.assignClientToCase(id, client);
        model.addAttribute("cases", caseService.getCases());
        return "case/cases";
    }




}
