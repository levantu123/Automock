package com.auto.api;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class MockService {
	@Autowired
	RequestRepository requestRepository;
	
	
	public Object handleGet(String path) {
		String id = "";
		String[] terms = path.split("/");
		for(String term : terms) {
			id += term+"-_";
		}
		
		if(1 == 1) {
			return new RestTemplate().getForEntity("http://cscvieae528143/uic_group_ihub/api/MultiDropdownService", Object.class).getBody();
		}
		Optional<Request> request = requestRepository.findById(id);
		if (request.isPresent()) {
			return request.get().body;
		}
		return null;
	}
	
	
	public Object handlePost(String path, Map<String, Object> body) {
		String newId = "";
		String[] terms = path.split("/");
		String link = path.replace("/v1", "");
		for(String term : terms) {
			newId += term+"-_";
		}
		if (requestRepository.findById(newId).isPresent()) {
			return requestRepository.findById(newId).get();
		}
		
		Request request = new Request();
		request.setRequestId(newId);
		request.setBody(body);
		request.setLink(link);
		return requestRepository.save(request);
	}
	
	public Object handlePut(String path, Map<String, Object> body) {
		String newId = "";
		String[] terms = path.split("/");
		String link = path.replace("/v1", "");
		for(String term : terms) {
			newId += term+"-_";
		}
		Request request = new Request();
		request.setRequestId(newId);
		request.setBody(body);
		request.setLink(link);
		return requestRepository.save(request);
	}
}
