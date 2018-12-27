/**
 * 
 */
package se.tennander.family.member;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.javalin.Context;
import io.javalin.apibuilder.ApiBuilder;
import se.tennander.family.Service;

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
		wiring.addRoute("/:memberId", () -> ApiBuilder.get(this::getMember));
	}

	private void getMembers(Context context) {
		Collection<MemberHeader> headers = memberStorage.getMembers().stream()
				.map(MemberHeader::from)
				.collect(Collectors.toList());
		context.json(headers);
	}

	private void addMember(Context context) {
		context.json("adding member...");
	}

	private void getMember(Context context) {
		int id = Integer.valueOf(context.pathParam("memberId"));
		context.json(memberStorage.getMember(id));
	}
}
