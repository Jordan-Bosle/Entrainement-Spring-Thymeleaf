package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import training.demo.entities.Personne;
import training.demo.forms.FormPersonne;
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
        List<Personne> personne = repository.findAll();
        model.addAttribute("personnes", personne);
        return "personne";
    }


    @GetMapping("/afficher-personne/delete/{id}")
    public String deletePersonne(@PathVariable long id) throws Exception {
        repository.remove(id);
        return "redirect:/personne/afficher-personne";
        // Question à Yanis:  Pourquoi ici on retourne une URL et pas le fichier
    }

    @GetMapping("afficher-personne/addpersonne")
    public String addP(@ModelAttribute("formpersonne") FormPersonne formPersonne ) {
        return "addpersonne";
    }

    @PostMapping("afficher-personne/addpersonne")
    public String addPersonne(@ModelAttribute("formpersonne") FormPersonne formPersonne, BindingResult results, Model model)
    {
        Personne personne = new Personne(
                formPersonne.getId(),
                formPersonne.getNom(),
                formPersonne.getPrenom(),
                formPersonne.getAge());

        repository.saveOrUpdate(personne);
        return "redirect:/personne/afficher-personne";
    }



}
