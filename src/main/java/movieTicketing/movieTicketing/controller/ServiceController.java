package movieTicketing.movieTicketing.controller;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final MemberService memberService;

    @GetMapping("/service/{userId}/search")
    public String search(@PathVariable("userId") String id, Model model) {
        System.out.println("userId : " + id);
        Member member = memberService.findOne(id);
        model.addAttribute("tickets", member.getTickets());
        return "user/search";
    }
}
