package gr.hua.lab.syst.totallab.controllers;


import gr.hua.lab.syst.totallab.entities.Client;
import gr.hua.lab.syst.totallab.service.ClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    List<Client> clients = new ArrayList<Client>();

   /* @PostConstruct
    public void populate() {
        Client cl1 = new Client("Dioritou 76", "Wick", "John", 1, "johnwick@gmail.com");
        Client cl2 = new Client("Sarantea 45", "Iordanou", "Marios", 2, "mariosiord@hotmail.gr");
        Client cl3 = new Client("Lampraki 31", "Aggelou", "Fanis", 3, "fanisaggelou@yahoo.gr");


        clients.add(cl1);
        clients.add(cl2);
        clients.add(cl3);
    }


    public Client getClient(List<Client> clslist, int id){
        for (Client client : clslist) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    } */

    @GetMapping("")
    public String showClients(Model model) {
        model.addAttribute("clients", clientService.getClients());
        return "client/clients";
    }


    @GetMapping("/{id}")
    public String showClient(@PathVariable Integer id, Model model) {
        try {
            model.addAttribute("client", clientService.getClient(id));
            return "client/client";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found", e);
        }
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable Integer id, Model model){
        model.addAttribute("client", clientService.getClient(id));
        return "client/client-profile";
    }

    @GetMapping("/new")
    public String addClient(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "client/client";
    }

    @PostMapping("/new")
    public String saveClient(@ModelAttribute("client") Client client, Model model) {
        clientService.saveClient(client);
        model.addAttribute("clients", clientService.getClients());
        return "client/clients";
    }







 





   /* public String showclient(Model model) {
        return "clients";
    }

    @GetMapping("/{id}")
    public String showClient(@PathVariable Integer id, Model model){
        Client client = getClient(clients,id);
        model.addAttribute("clients", client);
        return "clients";
    } */

}
