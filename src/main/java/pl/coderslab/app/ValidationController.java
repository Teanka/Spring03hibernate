package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.book.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {
    @Autowired
    private Validator validator;

    @ResponseBody
    @GetMapping("/validate")
    public String validate(){
        Book book = new Book();
        Set<ConstraintViolation<Book>> errors = validator.validate(book);
        StringBuilder sb = new StringBuilder();
        for(ConstraintViolation<Book> error:errors){
            sb.append(error.getPropertyPath().toString() + ": " + error.getMessage());
            sb.append("<br>");
        }
        return sb.toString();
    }

//    @GetMapping("/val")
//    public String validateView(Model model){
//        Book book = new Book();
//        Set<ConstraintViolation<Book>> errors = validator.validate(book);
//        List<FieldError> fieldErrors = new ArrayList<>();
//        for(ConstraintViolation<Book> error:errors){
//            FieldError fieldError = new FieldError();
//            fieldError.setPath(error.getPropertyPath().toString());
//            fieldError.setMessage(error.getMessage());
//            fieldErrors.add(fieldError);
//        }
//        model.addAttribute("bookErrors", fieldErrors);
//        return "validation";
//    }

    @GetMapping("/val")
    public String validateView(Model model){
        Author author = new Author();
        Set<ConstraintViolation<Author>> errors = validator.validate(author);
        List<FieldError> fieldErrors = new ArrayList<>();
        for(ConstraintViolation<Author> error:errors){
            FieldError fieldError = new FieldError();
            fieldError.setPath(error.getPropertyPath().toString());
            fieldError.setMessage(error.getMessage());
            fieldErrors.add(fieldError);
        }
        model.addAttribute("fieldErrors", fieldErrors);
        return "validation";
    }



//
//    Zmodyfikuj akcję przekazując zbiór zawierający błędy do widoku.
//    Dodaj dla akcji widok, a następnie wyświetl w nim wszystkie błędy w postaci: Nazwa pola : nazwa błędu
}
