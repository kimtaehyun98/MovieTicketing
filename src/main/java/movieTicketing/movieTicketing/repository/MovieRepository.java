package movieTicketing.movieTicketing.repository;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MovieRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Movie movie){
        em.persist(movie);
    }

    public Movie findOne(Long id){
        return em.find(Movie.class, id);
    }

    public List<Movie> findAll() {
        return em.createQuery("select i from Movie i", Movie.class)
                .getResultList();
    }
}
