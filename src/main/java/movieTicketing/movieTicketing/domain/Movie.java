package movieTicketing.movieTicketing.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    private String movieName;
    
    private String movieTime; // 상영시간
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;



}
