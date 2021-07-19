package movieTicketing.movieTicketing.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "user_id")
    private String userId;
    private String userPw;

    @Enumerated(EnumType.STRING)
    private Grade grade; // 유저의 등급
    private Long cumulativeUsageAmount; // 누적 사용 금액

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private Tickets tickets;
}
