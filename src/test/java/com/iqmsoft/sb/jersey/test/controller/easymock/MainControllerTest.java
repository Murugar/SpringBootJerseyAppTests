package com.iqmsoft.sb.jersey.test.controller.easymock;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.iqmsoft.sb.jersey.controller.MainController;
import com.iqmsoft.sb.jersey.service.MainService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(EasyMockRunner.class)
public class MainControllerTest {

	@Mock
	MainService mainServiceMock;

	@TestSubject
	private MainController mainController = new MainController();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("one", "test1");
		configuredResources.put("two", "test2");
		configuredResources.put("three", "test3");
		configuredResources.put("four", "test4");
		configuredResources.put("five", "test5");
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		EasyMock.expect(mainServiceMock.getConfiguredResources()).andReturn(configuredResources);
		EasyMock.replay(mainServiceMock);
		
		ResponseEntity<Map<String,String>> result = mainController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(configuredResources.size()));
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithNullListOfConfiguredResources() {
		EasyMock.expect(mainServiceMock.getConfiguredResources()).andReturn(null);
		EasyMock.replay(mainServiceMock);
		
		ResponseEntity<Map<String,String>> result = mainController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), nullValue());
	}

	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithEmptyListOfConfiguredResources() {
		EasyMock.expect(mainServiceMock.getConfiguredResources()).andReturn(new HashMap<>());
		EasyMock.replay(mainServiceMock);
		
		ResponseEntity<Map<String,String>> result = mainController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(0));
	}	
}
