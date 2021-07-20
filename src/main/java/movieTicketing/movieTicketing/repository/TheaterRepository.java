package movieTicketing.movieTicketing.repository;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Theater;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TheaterRepository {

    private final EntityManager em;

    public void save(Theater theater){
        em.persist(theater);
    }

    public Theater findOne(Long id){
        return em.find(Theater.class, id);
    }
}
