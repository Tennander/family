/**
 * 
 */
package se.tennander.family.member;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bjorn
 *
 */
public class MemberMemStorage implements MemberStorage {

	Map<Integer, Member> members;
	AtomicInteger nextMemberId = new AtomicInteger(100);
	
	@Override
	public Member getMember(int memberId) {
		return members.get(memberId);
	}

	@Override
	public Collection<Member> getMembers() {
		return members.values();
	}

	@Override
	public Member addMember(String givenName, String surName) {
		int memberId = nextMemberId.addAndGet(1);
		Member newMember = new Member(memberId, givenName, surName);
		return newMember;
	}

	@Override
	public void store(Member member) {
		members.put(member.id, member);
	}
	

}
