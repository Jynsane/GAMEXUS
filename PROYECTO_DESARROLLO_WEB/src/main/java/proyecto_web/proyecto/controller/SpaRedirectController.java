package proyecto_web.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaRedirectController {

    @GetMapping(value = {
        "/{path:[^\\.]*}",
        "/*/{path:[^\\.]*}"
    })
    public String redirect() {
        return "forward:/index.html";
    }
}
