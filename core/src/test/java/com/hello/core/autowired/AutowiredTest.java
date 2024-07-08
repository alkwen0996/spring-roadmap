package com.hello.core.autowired;

import com.hello.core.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) // member1이 스프링 빈이 아니기  때문에 주입할 대상이 없어서 아예 호출안됨
        public void setNoBean1(Member member1) {
            System.out.println("member1 = " + member1);
        }

        @Autowired // member2이 스프링 빈이 아니기 때문에 주입할 대상이 없어서 null
        public void setNoBean2(@Nullable Member member2) {
            System.out.println("member2 = " + member2);
        }

        @Autowired // member2이 스프링 빈이 아니기 때문에 주입할 대상이 없어서 Optional.empty 
        public void setNoBean3(Optional<Member> member3) {
            System.out.println("member3 = " + member3);
        }
    }
}
