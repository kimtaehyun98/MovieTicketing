package movieTicketing.movieTicketing.controller;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "start/login";
    }

    @PostMapping("/login")
    public String login(Model model, @Valid LoginForm form, BindingResult result){
        // System.out.println("ID = " + form.getId() + ", PW = " + form.getPw());
        if(memberService.loginCheck(form.getId(), form.getPw()) == false) {
            // 경고창을 띄우고 싶은데 어떻게 해야 할까요
            return "start/login"; // error가 나면 다시 로그인 창으로 돌림
        }
        LoginForm user = new LoginForm();
        user.setId(form.getId());
        user.setPw(form.getPw());
        model.addAttribute("user", user);
        return "user/service";
    }

    @GetMapping("/newMember")
    public String crateForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "start/newMember";
    }

    @PostMapping("/newMember")
    public String create(@Valid MemberForm form, BindingResult result){

        if(result.hasErrors()) {
            System.out.println("회원가입 오류 발생");
            return "start/newMember"; // error가 나도 다시 회원 가입으로 돌림
        }

        Member member = new Member();
        member.setName(form.getName());
        member.setUserId(form.getId());
        member.setUserPw(form.getPw());
        member.setCumulativeUsageAmount(0L);

        memberService.join(member);

        return "redirect:/";
    }

}
