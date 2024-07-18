package hello.core.Order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given (이런 상황이 주어졌을 때)
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when (이렇게 실행했을 때)
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then (이렇게 된다)
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
