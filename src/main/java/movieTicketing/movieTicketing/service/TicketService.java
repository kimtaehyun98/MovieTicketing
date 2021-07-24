package movieTicketing.movieTicketing.service;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.*;
import movieTicketing.movieTicketing.repository.MemberRepository;
import movieTicketing.movieTicketing.repository.MovieRepository;
import movieTicketing.movieTicketing.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final MemberRepository memberRepository;
    private final MovieRepository movieRepository;


    // 티켓 예매
    @Transactional
    public Long ticketing(String userId, Movie movie, Long e, Long s, Long p){
        Member member = memberRepository.findOne(userId);

        // 티켓 정보 생성
        Long price = e*7000L + s*10000L + p*15000L; // 가격
        Ticket ticket = Ticket.createTicket(member, movie, e, s, p, price);

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
