package movieTicketing.movieTicketing.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "user_id")
    private String userId;
    private String userPw;
    private String name;

    private Long cumulativeUsageAmount; // 누적 사용 금액

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public void pushTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
