package com.iqmsoft.sb.jersey.controller;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.iqmsoft.sb.jersey.service.MainService;

@Component
@Path("/resources")
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService mainService;
	
	/**
	 * Gets a list of configured resources (queues and/or topics) for the application.
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Path("/get/test")
	public ResponseEntity<Map<String,String>> getConfiguredResources() {
		LOGGER.info("getConfiguredResources - start");
		
		Map<String,String> configuredResources = mainService.getConfiguredResources();
		
		LOGGER.info("getConfiguredResources - end");
		return new ResponseEntity<Map<String,String>>(configuredResources, HttpStatus.OK);
	}
}
