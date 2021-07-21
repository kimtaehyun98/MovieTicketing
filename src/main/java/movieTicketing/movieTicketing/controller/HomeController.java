package movieTicketing.movieTicketing.controller;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
