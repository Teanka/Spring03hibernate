package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

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

//    @ResponseBody
//    @GetMapping("/add")
//    public String add() {
//        Book book = new Book();
//        book.setTitle("Thinking in Java");
//        book.setDescription("opis");
//
//        Publisher publisher = new Publisher();
//        publisher.setName("Wydawca testowy");
//
//        book.setPublisher(publisher);
//
//        bookService.save(book);
//        return "added";
//    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return"book";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:list";
    }

    @ResponseBody
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id) {
        Book book = bookService.find(id);
        if (book == null) {
            return "Book not found";
        }
        book.getPublisher().setName("Wydawca testowy 2");
        bookService.update(book);
        return "updated";
    }

//    @ResponseBody
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        bookService.delete(id);
//        return "deleted";
//    }

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
        List<Book> books = bookService.findAll();
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
    public String editBookPost(@PathVariable Long id, @ModelAttribute Book book){
        bookService.update(book);
        return "redirect:../list";
    }

}
