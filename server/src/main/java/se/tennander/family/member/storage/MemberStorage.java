package se.tennander.family.member.storage;

import java.util.stream.Stream;

/**
 * The central storage for {@link Member}s.
 */
public interface MemberStorage {

  /**
   * Get a specific member by there Id.
   * @param memberId The id corresponding to the member.
   * @return The member with the given Id.
   */
	Member getMember(int memberId);

  /**
   * Get a list of all members.
   * @return Returns a stream of all members from the storage.
   */
	Stream<Member> getMembers();

  /**
   * Adds and creates a member with the given given name and surname.
   * @param givenName The given name to
   * @param surName The sur name of the user.
   * @return The newly created user.
   */
	Member addMember(String givenName, String surName);

  /**
   * Persist the user to storage. No changes will be stored until a member is "stored".
   * @param member The member to save back to disk.
   */
	void store(Member member);
}
