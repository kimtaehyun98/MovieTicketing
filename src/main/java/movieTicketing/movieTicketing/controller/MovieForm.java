package movieTicketing.movieTicketing.controller;

import lombok.Getter;
import lombok.Setter;
import movieTicketing.movieTicketing.domain.Movie;
import movieTicketing.movieTicketing.domain.Ticket;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
public class MovieForm {

    private String userId;

    private Long movieId;

    private String movieName;

    private String movieTime; // 상영시간

    private String theater; // 극장 이름

    private Long economySeat; // 극장의 좌석수 (즉 예매가 완료되면 줄어야 함)
    private Long standardSeat;
    private Long primeSeat;

}
