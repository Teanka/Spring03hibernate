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

//import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@SessionAttribute("createdate")
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository bookRepository;

    @ModelAttribute("publishers")
    List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    List<Author> getAuthors() {
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
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

//    @PostMapping("/add")
//    public String addPost(@ModelAttribute Book book){
//        bookService.save(book);
//        return "redirect:list";
//    }

//    @PostMapping("/add")
//    public String addPost(@ModelAttribute @Valid Book book, BindingResult result){
//        if(result.hasErrors()){
//            return "book";
//        }
//        bookService.save(book);
//        return "redirect:list";
//    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute @Validated(BookGroupValidator.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book";
        }
        book.setCreatedate(new Date());//gubimy to w wyniku bindowania przy edycji bo nie ma tego w formularzu ani w parhvariable.
        //można dodać pole hidden na formularzu i się nie zgubi
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
    public String findRating(@PathVariable int rating) {
        return bookService.getRatingList(rating).toString();
    }

    @GetMapping("/list")
    public String findAll(Model model) {
//        List<Book> books = bookService.findAll();
//        List<Book> books = bookService.findByAuthorsFirstAndLastName("JRR","Tolkien");
//        List<Book> books = bookService.findByPublisherName("Penguin");
//        List<Book> books = bookService.findByRating(10);
//        List<Book> books = bookRepository.getBooksByTitle("I,Robot");
//        Book book = bookService.findBookByCategoryNameTitle("SF");
        Book book = bookRepository.getFirstBookByCategoryNameTitleSorting("SF");
        List<Book> books = new ArrayList<>();
        books.add(book);
//        List<Book> books = bookRepository.getBooksByRatingBetween3and5(5,10);
//        List<Book> books = bookRepository.getBooksByRatingBetween3and5(5,10);

//        List<Book> books = bookRepository.getBooksByPublishersName("3e");
//        List<Book> books = bookService.findByCategoryId(2L);
//        List<Book> books = bookService.findByCategoryName("SF");
//        List<Book> books = bookService.findByTitle("I,Robot");
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id) {
        Book book = bookService.findWithAuthors(id);
        model.addAttribute(book);
        return "book";
    }

    @PostMapping("/edit/{id}")
    public String editBookPost(@PathVariable Long id, @ModelAttribute @Validated(BookGroupValidator.class) Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book";
        }
        Book old = bookService.findWithAuthors(id);   //jeden sposób inny// można przekazać w sesji, seesionAttribute.
        book.setCreatedate(old.getCreatedate());
        book.setProposition(old.isProposition());
        bookService.update(book);
        return "redirect:../list";
    }
//    Uzupełnij projekt o walidację formularzy dodawania/edycji książki.
//    Dodaj wyświetlanie błędów w formularzach.
}
