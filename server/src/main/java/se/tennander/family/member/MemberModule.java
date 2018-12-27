package se.tennander.family.member;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import se.tennander.family.Service;

public class MemberModule extends AbstractModule {

	@Override
	  protected void configure() {
	    Multibinder<Service> servicesBinder = Multibinder.newSetBinder(binder(), Service.class);
	    servicesBinder.addBinding().to(MemberService.class);
	  }
}
