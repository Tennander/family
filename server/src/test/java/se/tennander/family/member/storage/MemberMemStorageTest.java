package se.tennander.family.member.storage;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class MemberMemStorageTest {

  private MemberMemStorage target;

  @Before
  public void setUp() throws Exception {
    target = new MemberMemStorage();
  }

  @Test
  public void addAndGetMember() {
    // Given
    Member storedMember = target.addMember("john", "dow");
    // When
    Member member = target.getMember(storedMember.id);
    // Then
    assertEquals(storedMember, member);

  }

  @Test
  public void getMembers() {
    // When
    Member storedMember1 = target.addMember("a", "b");
    Member storedMember2 = target.addMember("c", "d");
    // Then
    assertEquals(2, target.getMembers().count());
    assertTrue(target.getMembers().anyMatch(storedMember1::equals));
    assertTrue(target.getMembers().anyMatch(storedMember2::equals));
  }

  @Test
  public void store() {
    // Given
    Member storedMember = target.addMember("john", "dow");
    // When
    storedMember.shoeSize = "43";
    target.store(storedMember);
    // Then
    assertEquals(storedMember, target.getMember(storedMember.id));
  }

  @Test
  public void updateShouldNotAffectStorage() {
    // Given
    Member storedMember = target.addMember("john", "dow");
    // When
    storedMember.shoeSize = "43";
    // Then
    assertNotEquals(storedMember, target.getMember(storedMember.id));
  }

  @Test
  public void updateShouldNotAffectMemberFromGet() {
    // Given
    int id = target.addMember("john", "dow").id;
    Member storedMember = target.getMember(id);
    // When
    storedMember.shoeSize = "43";
    // Then
    assertNotEquals(storedMember, target.getMember(storedMember.id));
  }
}