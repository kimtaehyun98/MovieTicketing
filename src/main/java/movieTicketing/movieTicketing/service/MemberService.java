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

    // login 체크 -> 존재하는 ID 인지 + ID에 맞는 비밀번호인지
    public Boolean loginCheck(String id, String pw){
        Member findMember = memberRepository.findOne(id);

        if(findMember == null) { // 찾아봤는데 존재하지 않는다면
            return false;
        }
        if(findMember.getUserPw().equals(pw) == false) {
            return false;
        }
        return true;
    }

    // 멤버 찾아오기 (Controller는 Service 계층에만 접근하게 하기 위해서 만듦)
    public Member findOne(String id){
        Member findMember = memberRepository.findOne(id);
        return findMember;
    }

}
