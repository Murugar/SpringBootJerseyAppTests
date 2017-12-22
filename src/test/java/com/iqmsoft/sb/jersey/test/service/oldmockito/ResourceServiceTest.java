package com.iqmsoft.sb.jersey.test.service.oldmockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.iqmsoft.sb.jersey.service.MainService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

public class ResourceServiceTest {

	private MainService mainService = new MainService();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("1", "test1");
		configuredResources.put("2", "test2");
		configuredResources.put("3", "test3");
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		Map<String,String> result = mainService.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(configuredResources.size()));
	}
}
