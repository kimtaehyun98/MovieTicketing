package movieTicketing.movieTicketing.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.domain.Movie;
import movieTicketing.movieTicketing.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public Long saveMovie(Movie movie){
        movieRepository.save(movie);
        return movie.getId();
    }

    @Transactional
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    @Transactional
    public Movie findOne(Long id){
        return movieRepository.findOne(id);
    }
}
