package movieTicketing.movieTicketing.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@Entity
public class Movie {

    @Id @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    private String movieName;
    
    private String movieTime; // 상영시간
    
    private String theater;

    private Long economySeat; // 좌석수
    private Long standardSeat;
    private Long primeSeat;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Ticket> ticket;


}
