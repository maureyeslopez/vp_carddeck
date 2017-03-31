package vp_carddeck.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import rest.FrenchDeckREST;
import rest.SpanishDeckREST;

@ApplicationPath("/")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(FrenchDeckREST.class);
		resources.add(SpanishDeckREST.class);
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		addRestSingletonClasses(singletons);
		return singletons;
	}

	private void addRestSingletonClasses(Set<Object> singletons) {

	}

}
