package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;


    @ResponseBody
    @GetMapping("/list")
    public String listPublishers(){
//        return publisherService.findAll().toString();
//        return publisherService.findByNip("123").toString();
        return publisherService.findByRegon("34q").toString();
    }
//    Utwórz kontroler PublisherController, utwórz w nim akcje, które pozwolą:
//    wyświetlić listę wszystkich wydawcę
//    dodać wydawcę
//    usunąć wydawcę
//    edytować wydawcę
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.
}
