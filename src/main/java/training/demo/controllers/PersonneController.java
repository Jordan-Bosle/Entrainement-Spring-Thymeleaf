package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.demo.entities.Personne;
import training.demo.repositories.PersonneRepository;

import java.util.List;

@Controller
@RequestMapping("/personne")
public class PersonneController {

    public String personne()
    {
        return "personne";
    }

    @Autowired
    private PersonneRepository repository;

    @GetMapping("/afficher-personne")
    public String displayPersonne(Model model)
    {
        List<Personne> personnes = repository.findAll();
        model.addAttribute("personne", personnes);
        return "personne";
    }
}
