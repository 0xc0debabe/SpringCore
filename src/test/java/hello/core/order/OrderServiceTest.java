package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(1L, "itemA", 10000);

        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
     }

}