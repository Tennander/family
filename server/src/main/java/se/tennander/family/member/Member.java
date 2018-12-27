/**
 * 
 */
package se.tennander.family.member;

/**
 * @author bjorn
 *
 */
public class Member {
	public final int id;
	public String givenName;
	public String surName;
	public String nickName;
	public int shoeSize;

	public Member(int id, String givenName, String surName) {
		this.id = id;
		this.givenName = givenName;
		this.surName = surName;
	}
}
