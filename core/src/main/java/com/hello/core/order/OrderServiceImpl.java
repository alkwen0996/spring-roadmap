package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); -> 구체 클래스에 의존 DIP 위반.
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    /*@Autowired(required = false) // @Autowired 의 기본 동작은 주입할 대상 없으면 에러발생 -> 주입하 대상이 없어도 동작하게 하려면 required = false를 지정하면 된다.
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl.setDiscountPolicy");
        this.discountPolicy = discountPolicy;
    }*/

    /*@Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("OrderServiceImpl.setMemberRepository");
        this.memberRepository = memberRepository;
    }*/

    @Autowired
    public OrderServiceImpl(final MemberRepository memberRepository, final DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(final Long memberId, final String itemName, final int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
