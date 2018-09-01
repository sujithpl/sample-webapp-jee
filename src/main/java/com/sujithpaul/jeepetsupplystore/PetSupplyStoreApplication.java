package com.sujithpaul.jeepetsupplystore;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.sujithpaul.jeepetsupplystore.resource.OrderProcessor;

@ApplicationPath("/petsupplystore")
public class PetSupplyStoreApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(JacksonFeature.class);
		classes.add(OrderProcessor.class);
		return classes;
	}
}
