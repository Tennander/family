package se.tennander.family.member.storage;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A Member is a representation of one family member.
 * It is the base representation of our end-users.
 */
public class Member {
  @JsonProperty public final int id;
  @JsonProperty public String givenName;
  @JsonProperty public String surName;
  @JsonProperty public String nickName;
  @JsonProperty public String shoeSize;

	@JsonCreator
	public Member(int id, String givenName, String surName) {
		this.id = id;
		this.givenName = givenName;
		this.surName = surName;
	}

  Member(Member member) {
    this.id = member.id;
    this.givenName = member.givenName;
    this.surName = member.surName;
    this.nickName = member.nickName;
    this.shoeSize = member.shoeSize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Member member = (Member) o;
    return id == member.id &&
        givenName.equals(member.givenName) &&
        surName.equals(member.surName) &&
        Objects.equals(nickName, member.nickName) &&
        Objects.equals(shoeSize, member.shoeSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, givenName, surName, nickName, shoeSize);
  }
}
