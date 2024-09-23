package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_success() {
        //given
        Member member = new Member(1L, "홍길동", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertEquals(1000, discount);
     }

    @Test
    @DisplayName("VIP 아니면 할인 안됨")
     void vip_x() {
         //given
         Member member = new Member(1L, "홍길동", Grade.BASIC);

         //when
         int discount = discountPolicy.discount(member, 10000);


         //then
         assertEquals(0, discount);
     }

}