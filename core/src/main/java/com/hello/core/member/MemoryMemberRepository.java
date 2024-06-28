package com.hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 이슈를 고려하여 ConcurrentHashMap 사용.

    @Override
    public void save(final Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(final Long memberId) {
        return store.get(memberId);
    }
}