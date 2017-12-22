package com.iqmsoft.sb.jersey.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.sb.jersey.ServletInitializer;
import com.iqmsoft.sb.jersey.MainApplication;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SpringRunner.class)
public class ServletInitializerTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private ServletInitializer servletInitializer = new ServletInitializer();
	
	@Test
	public void configureWithValidArgumentsShouldReturnASpringApplicationBuilder() {
		SpringApplicationBuilder result = servletInitializer.configure(new SpringApplicationBuilder(MainApplication.class));
		assertThat(result, notNullValue());
	}

	@Test
	public void configureWithNullArgumentsShouldReturnASpringApplicationBuilder() {
		thrown.expect(NullPointerException.class);
		servletInitializer.configure(null);
	}	
}
