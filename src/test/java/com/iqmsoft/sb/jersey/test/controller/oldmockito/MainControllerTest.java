package com.iqmsoft.sb.jersey.test.controller.oldmockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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

public class MainControllerTest {

	@Mock
	MainService exampleServiceMock;
	
	@InjectMocks 
	private MainController exampleController = new MainController();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("one", "test1");
		configuredResources.put("two", "test2");
		configuredResources.put("three", "test3");
		configuredResources.put("four", "test4");
		configuredResources.put("five", "test5");
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		Mockito.doReturn(configuredResources).when(exampleServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(configuredResources.size()));
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithNullListOfConfiguredResources() {
		Mockito.doReturn(null).when(exampleServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), nullValue());
	}

	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithEmptyListOfConfiguredResources() {
		Mockito.doReturn(new HashMap<>()).when(exampleServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(0));
	}	
}
