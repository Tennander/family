package se.tennander.family.member;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import se.tennander.family.member.storage.Member;

public class MemberHeaderViewTest {

  @Test
  public void from() {
    // Given
    Member member = new Member(1, "john", "dow");
    // When
    MemberHeaderView header = MemberHeaderView.create(member);
    // Then
    assertEquals(1, header.id);
    assertEquals("john", header.givenName);
    assertEquals("dow", header.surName);
  }

  @Test
  public void jsonSerializable() throws JsonProcessingException {
    // Given
    MemberHeaderView header = new MemberHeaderView(1, "john", "dow");
    // When
    String result = new ObjectMapper().writeValueAsString(header);
    // Then
    assertEquals("{\"id\":1,\"givenName\":\"john\",\"surName\":\"dow\"}", result);
  }
}