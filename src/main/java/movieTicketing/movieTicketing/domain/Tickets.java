package movieTicketing.movieTicketing.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tickets {

    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @OneToOne(mappedBy = "tickets", fetch = LAZY) // cascade는 persist 하지 않고도 바로 DB로 쿼리 날림
    private Member member;

    @OneToMany(mappedBy = "tickets", cascade = CascadeType.ALL)
    private List<TicketInfo> ticketInfo;
}
