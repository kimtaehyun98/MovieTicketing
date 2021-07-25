package movieTicketing.movieTicketing.controller;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.domain.Movie;
import movieTicketing.movieTicketing.domain.Ticket;
import movieTicketing.movieTicketing.service.MemberService;
import movieTicketing.movieTicketing.service.MovieService;
import movieTicketing.movieTicketing.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final MemberService memberService;
    private final MovieService movieService;
    private final TicketService ticketService;

    @GetMapping("service/{userId}/search")
    public String search(@PathVariable("userId") String id, Model model) {
        // System.out.println("userId : " + id);
        Member member = memberService.findOne(id);
        model.addAttribute("tickets", member.getTickets());
        model.addAttribute("userId", id);
        return "user/search";
    }

    @GetMapping("service/{userId}/ticketing")
    public String ticketing(@PathVariable("userId") String id, Model model){
        // 영화 예매 화면 뿌려줘야 함
        // 현재 저장되어 있는 영화들을 가져와서 뿌려주기 (이때 "영화관" Table에 영화와 영화 정보들이 들어가 있어야 한다)
        List<Movie> movies = movieService.getAllMovie();
        model.addAttribute("movies", movies);
        model.addAttribute("userId", id);
        return "user/ticketing";
    }

    @GetMapping("service/{userId}/{movieId}/chooseSeat")
    public String chooseSeat(@PathVariable("userId") String id, @PathVariable("movieId") Long movieId,  Model model){
        Movie movie = movieService.findOne(movieId);
        MovieForm movieForm = new MovieForm();
        movieForm.setUserId(id);
        movieForm.setMovieId(movieId);
        movieForm.setMovieName(movie.getMovieName());
        movieForm.setMovieTime(movie.getMovieTime());
        movieForm.setTheater(movie.getTheater());
        model.addAttribute("movieForm", movieForm);
        return "user/chooseSeat";
    }

    @PostMapping("service/{userId}/{movieId}/ticketingSuccess")
    public String success(@PathVariable("userId") String id, @PathVariable("movieId") Long movieId, @Valid MovieForm form){
        // 여기서 각 좌석수를 체크해서 가감 및 취소
        Movie movie = movieService.findOne(movieId);
        Long me = movie.getEconomySeat(), fe = form.getEconomySeat();
        Long ms = movie.getStandardSeat(), fs = form.getStandardSeat();
        Long mp = movie.getPrimeSeat(), fp = form.getPrimeSeat();
        if(me < fe || ms < fs || mp < fp){
            return "user/failTicketing";
        }
        // 남은 좌석 수 갱신
        movie.setEconomySeat(me - fe);
        movie.setStandardSeat(ms - fs);
        movie.setPrimeSeat(mp - fp);
        // Ticket 생성
        Long ticketId = ticketService.ticketing(id, movie, fe, fs, fp);
        // Member의 tickets에도 push 해줘야 함
        memberService.pushTicket(id, ticketId);
        return "user/successTicketing";
    }

    @GetMapping("service/{userId}/makeMovie")
    public String getMovie(Model model){
        model.addAttribute("movieForm", new MovieForm());
        return "user/makeMovie";
    }

    @PostMapping("service/{userId}/makeMovie")
    public String makeMovie(@PathVariable ("userId") String id, @Valid MovieForm form, Model model){
        Movie movie = new Movie();
        movie.setMovieName(form.getMovieName());
        movie.setMovieTime(form.getMovieTime());
        movie.setTheater(form.getTheater());
        movie.setEconomySeat(form.getEconomySeat());
        movie.setStandardSeat(form.getStandardSeat());
        movie.setPrimeSeat(form.getStandardSeat());
        movieService.saveMovie(movie);
        LoginForm user = new LoginForm();
        user.setId(id);
        model.addAttribute("user", user);
        return "user/service";
    }

    @PostMapping("service/{ticketId}/cancel")
    public String cancel(@PathVariable ("ticketId") Long ticketId, @Valid MovieForm form, Model model){
        ticketService.cancelTicket(ticketId);
        return "redirect:/";
    }
}
