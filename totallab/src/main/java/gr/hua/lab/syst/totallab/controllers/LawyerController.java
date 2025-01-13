package gr.hua.lab.syst.totallab.controllers;


import gr.hua.lab.syst.totallab.entities.Lawyer;
import gr.hua.lab.syst.totallab.service.LawyerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("lawyer")
public class LawyerController {

    private LawyerService lawyerService;

    public LawyerController(LawyerService lawyerService) {
        this.lawyerService = lawyerService;
    }

 /*   public void setup() {
        Lawyer l1 = new Lawyer("Divorce", "6987869349","Apostolou", "Kostas", 1, "kostasapost@gmail.com");
        Lawyer l2 = new Lawyer("Kidnapping", "6940663450","Zachariou", "Valadis", 2, "valzach@yahoo.gr");
        Lawyer l3 = new Lawyer("Hijacking", "6985640020","Karachalios", "Zafeiris", 3, "zafkar@hotmail.gr");

        lawyerService.saveLawyer(l1);
        lawyerService.saveLawyer(l2);
        lawyerService.saveLawyer(l3);

   */

}

@RequestMapping()
public String showLawyers(Model model) {
    model.addAttribute("lawyers", lawyerService.getLawyers());
    return "lawyer/lawyers";
}

@GetMapping("/{id}")
public String showLawyer(@PathVariable Integer id, Model model){
    Lawyer lawyer = lawyerService.getLawyer(id);
    model.addAttribute("lawyers", lawyer);
    return "lawyer/lawyers";
}

@GetMapping("/new")
public String addLawyer(Model model){
    Lawyer lawyer = new Lawyer();
    model.addAttribute("lawyer", lawyer);
    return "lawyer/lawyer";

}

@PostMapping("/new")
public String saveLawyer(@ModelAttribute("case") Lawyer lawyer, Model model) {
    lawyerService.saveLawyer(lawyer);
    model.addAttribute("lawyers", lawyerService.getLawyers());
    return "lawyer/lawyers";
}

@GetMapping("/{id}/cases")
public String showCases(@PathVariable("id") Integer id, Model model){
    Lawyer teacher = lawyerService.getLawyer(id);
    model.addAttribute("cases", lawyer.getCases());
    return "case/cases";
}



}
