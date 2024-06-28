package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(final Member member, final int price) {
        if (member.getGrade() == Grade.VIP) { // enum은 == 으로 비교
            return discountFixAmount;
        }

        return 0;
    }
}
