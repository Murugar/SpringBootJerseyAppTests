package com.iqmsoft.sb.jersey.test.service.easymock;

import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.iqmsoft.sb.jersey.service.MainService;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(EasyMockRunner.class)
public class ResourceServiceTest {

	@TestSubject
	private MainService mainService = new MainService();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("1", "test1");
		configuredResources.put("2", "test2");
		configuredResources.put("3", "test3");
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		Map<String,String> result = mainService.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(configuredResources.size()));
	}
}
