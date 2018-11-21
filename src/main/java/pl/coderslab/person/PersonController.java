package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

//    @GetMapping("/add")
//    @ResponseBody
//    public String addPerson(){
//        Person person = new Person();
//        PersonDetails personDetails = new PersonDetails();
//        personDetails.setCity("Warsaw");
//        personDetails.setFirstName("Jan");
//        personDetails.setLastName("Kowalski");
//        person.setEmail("jkowalski@test.pl");
//        person.setPersonDetails(personDetails);
//        personService.save(person);
//        return "added";
//    }
    @GetMapping("/add")
    public String addGet(Model model){
        model.addAttribute("person", new Person());//jako nowy obiekt wg którego dane mają być bindowane w jsp
        return "person";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addPost(@ModelAttribute Person person){
        personService.save(person);
        return "person " + person.toString() + " added";
    }


    @GetMapping("/find")
    @ResponseBody
    public String findAll(){
        List<Person> personList = personService.findAll();

        return personList.toString();
    }

    @ResponseBody
    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id) {
        Person person= personService.find(id);
        return person.toString();
    }




//    Utwórz akcję wyświetlającą formularz w kontrolerze PersonController.
//    Dodaj widok formularza zawierający pola login oraz password, email.
//    Wykorzystaj w tym celu encję Person z poprzednich zajęć.
//    Dodaj akcję przetwarzająca formularz (akcja ma zakończyć się zapisem danych do bazy)-
// pobieraj dane za pomocą @RequestParam.
//            Zadanie 2 - rozwiązywane z wykładowcą
//    Zmodyfikuj formularz oraz akcję kontrolera w taki sposób aby dane bindowały się automatycznie.
}
