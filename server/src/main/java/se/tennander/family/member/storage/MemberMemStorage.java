package se.tennander.family.member.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MemberMemStorage implements MemberStorage {

	private Map<Integer, Member> members = new HashMap<>();
	private AtomicInteger nextMemberId = new AtomicInteger(100);
	
	@Override
	public Member getMember(int memberId) {
    return new Member(members.get(memberId));
	}

	@Override
	public Stream<Member> getMembers() {
		return members.values().stream();
	}

	@Override
	public Member addMember(String givenName, String surName) {
		int memberId = nextMemberId.addAndGet(1);
		Member newMember = new Member(memberId, givenName, surName);
    store(newMember);
    return new Member(newMember);
	}

	@Override
	public void store(Member member) {
		members.put(member.id, member);
	}
	

}
