package com.iqmsoft.sb.jersey.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class MainService {
	
	private static final String[] resources = {"test1", "test2", "test3"};
	
	
	public Map<String, String> getConfiguredResources() {
		Map<String, String> configuredResources = new HashMap<>();		
		
		int resourcesCount = 1;
		
		for (String resource : resources) {
			configuredResources.put(String.valueOf(resourcesCount++), resource);
		}
		
		return configuredResources;
	}
}
