package movieTicketing.movieTicketing.service;

import movieTicketing.movieTicketing.domain.Member;
import movieTicketing.movieTicketing.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {

        Member member = new Member();
        member.setUserId("test");

        String userId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(userId)); // 중복 체크도 해봄
    }

}