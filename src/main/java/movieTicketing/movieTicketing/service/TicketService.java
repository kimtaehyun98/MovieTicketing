package movieTicketing.movieTicketing.service;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.domain.SeatGrade;
import movieTicketing.movieTicketing.domain.Theater;
import movieTicketing.movieTicketing.domain.Ticket;
import movieTicketing.movieTicketing.repository.MemberRepository;
import movieTicketing.movieTicketing.repository.TheaterRepository;
import movieTicketing.movieTicketing.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final MemberRepository memberRepository;
    private final TheaterRepository theaterRepository;


    // 티켓 예매
    @Transactional
    public Long ticketing(String userId, Long theaterId, SeatGrade seatGrade){
        Member member = memberRepository.findOne(userId);
        Theater theater = theaterRepository.findOne(theaterId);

        // 티켓 정보 생성
        Long price = 7000L + seatGrade.ordinal()*3000L; // 가격
        Ticket ticket = Ticket.createTicket(member, theater, seatGrade, price);

        // 티켓 저장
        ticketRepository.save(ticket);

        return ticket.getId();
    }

    // 티켓 예메 취소
    @Transactional
    public void cancelTicket(Long ticketId){
        Ticket ticket = ticketRepository.findOne(ticketId);
        ticket.cancel();
    }

}
