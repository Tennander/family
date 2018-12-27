/**
 * 
 */
package se.tennander.family.member;

import java.util.Collection;

/**
 * @author bjorn
 *
 */
public interface MemberStorage {

	Member getMember(int memberId);
	Collection<Member> getMembers();
	Member addMember(String givenName, String surName);
	void store(Member member);
}
