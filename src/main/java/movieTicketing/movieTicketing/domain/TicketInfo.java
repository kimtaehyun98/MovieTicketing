package movieTicketing.movieTicketing.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketInfo {

    @Id @GeneratedValue
    @Column(name = "ticket_info_id")
    private Long id;

    private String userId; // 티켓을 산 사람
    
    private String movieName;

    private Long num; // 관람 인원수

    private Long time; // 영화 상영 시간 (날짜) -> 이 변수를 통해 예매 취소 결정
    
    @Enumerated(EnumType.STRING)
    private SeatGrade seatGrade; // 좌석 등급

    private Long price; // 총 결제 금액

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ticket_id")
    private Tickets tickets;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    // 연관관계 메서드 (해당 Entity가 주인이기 때문에 가능)
    public void setTickets(Tickets tickets){
        this.tickets = tickets;
        tickets.getTicketInfo().add(this);
    }

    public void setTheater(Theater theater){
        this.theater = theater;
        theater.getTicketInfo().add(this);
    }

}
