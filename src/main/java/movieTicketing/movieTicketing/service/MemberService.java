package movieTicketing.movieTicketing.service;

import lombok.RequiredArgsConstructor;
import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional
    public String join(Member member){
        dupcheck(member);
        memberRepository.save(member);
        return member.getUserId();
    }

    // 중복 체크
    private void dupcheck(Member member){
        Member findMember = memberRepository.findOne(member.getUserId());
        if(findMember != null) { // 찾아봤는데 비어있다면
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }



}
