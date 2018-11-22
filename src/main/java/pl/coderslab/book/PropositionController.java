package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @ModelAttribute("publishers")
    List<Publisher> getPublishers(){
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    List<Author> getAuthors(){
        return authorService.findAll();
    }


    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return"book";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute @Validated(PropositionGroupValidator.class) Book book, BindingResult result){
        if(result.hasErrors()){
            return "book";
        }
        book.setProposition(true);
        bookService.save(book);
        return "redirect:list";
    }


    @ResponseBody
    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id) {
        Book book = bookService.find(id);
        return book.toString();
    }

    @ResponseBody
    @GetMapping("find/r/{rating}")
    public String findRating(@PathVariable int rating){
        return bookService.getRatingList(rating).toString();
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<Book> books = bookService.findPropositions();
        model.addAttribute("books", books);
        return "bookList";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id){
        Book book = bookService.findWithAuthors(id);
        model.addAttribute(book);
        return "book";
    }

    @PostMapping("/edit/{id}")
    public String editBookPost(@PathVariable Long id, @ModelAttribute @Validated(PropositionGroupValidator.class) Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "book";
        }
        bookService.update(book);
        return "redirect:../list";
    }
}
