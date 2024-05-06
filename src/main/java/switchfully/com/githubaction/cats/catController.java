package switchfully.com.githubaction.cats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cats")
public class catController {

    @GetMapping()
    public String getAllCats(){
        return "Oh no... cats are removed";
    }
}
