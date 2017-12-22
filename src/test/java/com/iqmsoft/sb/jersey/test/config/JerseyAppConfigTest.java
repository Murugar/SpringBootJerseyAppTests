package com.iqmsoft.sb.jersey.test.config;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.sb.jersey.config.JerseyAppConfig;
import com.iqmsoft.sb.jersey.controller.MainController;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class JerseyAppConfigTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private JerseyAppConfig jerseyAppConfig = new JerseyAppConfig();
	
	@Before
	public void setUp() {
	}

	@Test
	public void createJerseyAppConfigWithValidArgumentsShouldReturnASetOfRegisteredClasses() {
		Set<Class<?>> result = jerseyAppConfig.getClasses();
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(1));
		assertThat(result.contains(MainController.class), equalTo(true));
	}

}
