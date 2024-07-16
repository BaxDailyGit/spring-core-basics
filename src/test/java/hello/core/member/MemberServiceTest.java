package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}

// # 회원 도메인 설계의 문제점



//- 이 코드의 설계상 문제점은 무엇일까?
//    -> MemberServiceImpl이 MemberRepository 인터페이스 뿐만 아니라 구현체인 MemoryMemberRepository에도 의존하고 있다.

//- 다른 저장소로 변경할 때 OCP 원칙을 잘 준수할까?
//    -> MemberServiceImpl은 MemberRepository 인터페이스에만 의존하므로 OCP 원칙을 잘 준수하고 있다. 하지만 MemberServiceImpl이 구현체인 MemoryMemberRepository에도 의존하고 있다. 따라서 MemberServiceImpl의 소스코드를 수정하지 않고, MemoryMemberRepository를 다른 구현체로 변경하려면 불가능하다.

//- DIP를 잘 지키고 있을까?
//    -> MemberServiceImpl은 MemberRepository 인터페이스에만 의존하면서 DIP를 잘 지키고 있다. 하지만 MemberServiceImpl이 구현체인 MemoryMemberRepository에도 의존하고 있다. DIP는 지켰지만, 그 DIP를 지키기 위해 MemberServiceImpl이 MemoryMemberRepository에도 의존하고 있으므로 DIP를 위반하고 있다.

//- 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음(주문까지 만들고나서 문제점과 해결 방안을 설명)
