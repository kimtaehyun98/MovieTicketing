package movieTicketing.movieTicketing.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theater {

    @Id @GeneratedValue
    @Column(name = "theater_id")
    private Long id;

    private String place;  // 영화관이 어디 위치해 있는지 = 영화관 이름

    private Long economySeat; // 좌석수
    private Long standardSeat;
    private Long primeSeat;

    @OneToOne(mappedBy = "theater", cascade = CascadeType.ALL)
    private Ticket ticket;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();

}
