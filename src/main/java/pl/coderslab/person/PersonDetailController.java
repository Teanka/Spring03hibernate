package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonDetailController {
    @Autowired
    private PersonService personService;

    @GetMapping("/detal")
    public String getDetails(Model model) {

        model.addAttribute("person", new PersonDTO());
        return "personDetails";
    }

    @ResponseBody
    @PostMapping("/detal")
    public String postDetails(@ModelAttribute PersonDTO person) {
        return "person " + person.toString() + " added.";
    }

    @ModelAttribute("countries")
    List<String>getCountries(){
        List<String> countries = new ArrayList<>();
        countries.add("Poland");
        countries.add("Germany");
        countries.add("Sweden");
        return countries;
    }

    @ModelAttribute("skills")
    List<String>getSkills(){
        List<String> skills = new ArrayList<>();
        skills.add("PHP");
        skills.add("Java");
        skills.add("JS");
        return skills;
    }

    @ModelAttribute("hobbies")
    List<String>getHobbies(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("dogs");
        hobbies.add("skiing");
        hobbies.add("reading");
        return hobbies;
    }
}
