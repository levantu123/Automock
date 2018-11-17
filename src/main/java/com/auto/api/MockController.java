package com.auto.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

@RestController
@RequestMapping(value="/v1")
public class MockController {
	
	@Autowired
	MockService mockService;
	
	@GetMapping(value = "/{str1}/**")
	public Object get(
	  @PathVariable String str1, HttpServletRequest request) { 
		
		String restOfTheUrl = (String) request.getAttribute(
			    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
	    return mockService.handleGet(restOfTheUrl);
	}
	
	
	@PostMapping(value = "/{str1}/**")
	public Object create(
	  @PathVariable String str1, HttpServletRequest request, @RequestBody Map<String, Object>body) { 
		
		String restOfTheUrl = (String) request.getAttribute(
			    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
	    return mockService.handlePost(restOfTheUrl, body);
	}
	
	@PutMapping(value = "/{str1}/**")
	public Object edit(
	  @PathVariable String str1, HttpServletRequest request, @RequestBody Map<String, Object>body) { 
		
		String restOfTheUrl = (String) request.getAttribute(
			    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
	    return mockService.handlePut(restOfTheUrl, body);
	}
	

}


