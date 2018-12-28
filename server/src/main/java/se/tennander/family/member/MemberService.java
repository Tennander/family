/**
 * 
 */
package se.tennander.family.member;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import io.javalin.Context;
import io.javalin.apibuilder.ApiBuilder;
import se.tennander.family.Service;
import se.tennander.family.member.storage.Member;
import se.tennander.family.member.storage.MemberStorage;

/**
 * @author bjorn
 *
 */
public class MemberService implements Service {
	
	private MemberStorage memberStorage;
	
	@Inject
	public MemberService(MemberStorage memberStorage) {
		this.memberStorage = memberStorage;
	}

	@Override
	public String serviceName() {
		return "members";
	}

	@Override
	public void wire(Wiring wiring) {
		wiring.addRoute("/", () -> ApiBuilder.get(this::getMembers));
		wiring.addRoute("/", () -> ApiBuilder.post(this::addMember));
		wiring.addRoute("/:id", () -> ApiBuilder.get(this::getMember));
	}

	private void getMembers(Context context) {
		Collection<MemberHeaderView> headers = memberStorage.getMembers()
				.map(MemberHeaderView::create)
				.collect(Collectors.toList());
		context.json(headers);
	}

	private void addMember(Context context) {
    JsonNode jsonMember = context.bodyAsClass(JsonNode.class);
    Member storedMember = memberStorage.addMember(
        jsonMember.get("givenName").asText(),
        jsonMember.get("surName").asText());
    context.json(storedMember);
  }

	private void getMember(Context context) {
		int id = Integer.parseInt(context.pathParam("id"));
		context.json(memberStorage.getMember(id));
	}
}
