package com.iqmsoft.sb.jersey.test.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.sb.jersey.service.MainService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class ResourceServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private MainService mainService = new MainService();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("one", "test1");
		configuredResources.put("two", "test2");
		configuredResources.put("three", "test3");
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		Map<String,String> result = mainService.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(configuredResources.size()));
	}
}
