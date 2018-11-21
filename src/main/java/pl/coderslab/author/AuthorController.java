package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.book.Book;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/add")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return"author";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Author author){
        authorService.save(author);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "authorList";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String editAuthor(Model model, @PathVariable Long id){
        Author author = authorService.find(id);
        model.addAttribute(author);
        return "author";
    }

    @PostMapping("/edit/{id}")
    public String editAuthorPost(@PathVariable Long id, @ModelAttribute Author author){
        authorService.update(author);
        return "redirect:../list";
    }
//Utwórz kontroler AuthorController, utwórz w nim akcje, które pozwolą:
//    wyświetlić listę wszystkich autorów
//    dodać autora
//    usunąć autora
//    edytować autora
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.
}
