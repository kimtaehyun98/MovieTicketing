package movieTicketing.movieTicketing.repository;

import movieTicketing.movieTicketing.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 회원 등록
    public void save(Member member){
        em.persist(member);
    }

    // 회원 찾기
    public Member findOne(String userId){
        return em.find(Member.class, userId);
    }

}
