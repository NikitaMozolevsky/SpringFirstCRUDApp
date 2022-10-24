package com.nikita.lessons.controllers;


import com.nikita.lessons.dao.impl.PersonDaoImpl;
import com.nikita.lessons.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDaoImpl personDao;

    @Autowired
    public PeopleController(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    String getAllPeople(Model model) {
        model.addAttribute("people", personDao.getPeople());
        return "people/all_people";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.getPerson(id));
        return "people/person";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute(new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person) {
        personDao.savePerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPersonPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDao.getPerson(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute Person person, @PathVariable int id) {
        personDao.changePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable int id) {
        personDao.deletePerson(id);
        return "redirect:/people";
    }
}
