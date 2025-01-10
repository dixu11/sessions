package szlicht.daniel.sessions;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/resources")
public class AppController {
    @GetMapping
    String returnSecuredResource() {
        return "your secured resource";
    }
}
