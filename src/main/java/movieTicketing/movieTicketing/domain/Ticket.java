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
public class Ticket {

    @Id @GeneratedValue
    @Column(name = "ticket_id")
    private Long id;

    // private Long num; // 관람 인원수
    // private Long time; // 영화 상영 시간 (날짜) -> 이 변수를 통해 예매 취소 결정

    private Long price; // 총 결제 금액

    private TicketStatus ticketStatus; // 예매 상태
    
    private TimeStatus timeStatus; // 해당 영화의 상영 상태

    private Long economySeat; // 예매한 좌석수
    private Long standardSeat;
    private Long primeSeat;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public static Ticket createTicket(Member member, Movie movie, Long e, Long s, Long p, Long price){
        Ticket ticket = new Ticket();
        ticket.setMember(member);
        ticket.setMovie(movie);
        ticket.setEconomySeat(e);
        ticket.setStandardSeat(s);
        ticket.setPrimeSeat(p);
        ticket.setPrice(price);
        ticket.setTimeStatus(TimeStatus.YET);
        ticket.setTicketStatus(TicketStatus.WATCH);
        // 나중에 여기 부분에서 Theater의 좌석 수 감소하기
        return ticket;
    }

    public void cancel(){
        // 먼저 영화가 이미 상영되었는지를 확인해야 함
        // Theater가 movieA를 상속받음, 이 상속받은 Table에 어떻게 접근하는지 모르겠음..
        // 일단은 ticketStatus에만 영향을 받는다고 가정
        if(timeStatus == TimeStatus.OVER) throw new IllegalStateException("이미 영화 상영이 끝나 환불이 불가능합니다.");
        this.ticketStatus = TicketStatus.CANCEL;
   }
}
