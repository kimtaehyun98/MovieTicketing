package movieTicketing.movieTicketing.repository;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TicketRepository {

    private final EntityManager em;

    public void save(Ticket ticket){
        em.persist(ticket);
    }

    public Ticket findOne(Long id){
        return em.find(Ticket.class, id);
    }
    /*public List<TicketInfo> getAllTicketInfo(Tickets tickets){

    }*/
}
