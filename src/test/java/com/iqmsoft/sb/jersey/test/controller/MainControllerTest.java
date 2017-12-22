package com.iqmsoft.sb.jersey.test.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.sb.jersey.controller.MainController;
import com.iqmsoft.sb.jersey.service.MainService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class MainControllerTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@MockBean
	MainService mainServiceMock;
	
	@SpyBean 
	private MainController mainController;
	
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
		Mockito.doReturn(configuredResources).when(mainServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = mainController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(configuredResources.size()));
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithNullListOfConfiguredResources() {
		Mockito.doReturn(null).when(mainServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = mainController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), nullValue());
	}

	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithEmptyListOfConfiguredResources() {
		Mockito.doReturn(new HashMap<>()).when(mainServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = mainController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(0));
	}	
}
