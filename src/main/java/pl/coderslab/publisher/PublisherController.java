package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;


//    Utwórz kontroler PublisherController, utwórz w nim akcje, które pozwolą:
//    wyświetlić listę wszystkich wydawcę
//    dodać wydawcę
//    usunąć wydawcę
//    edytować wydawcę
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.
}
