package se.tennander.family.member;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import se.tennander.family.Service;
import se.tennander.family.member.storage.MemberMemStorage;
import se.tennander.family.member.storage.MemberStorage;

public class MemberModule extends AbstractModule {

	@Override
	  protected void configure() {
	    bind(MemberStorage.class).to(MemberMemStorage.class);

	    Multibinder<Service> servicesBinder = Multibinder.newSetBinder(binder(), Service.class);
	    servicesBinder.addBinding().to(MemberService.class);
	  }
}
