package com.example.realestatego.controller;
// Import necessary packages
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realestatego.dto.AgentDTO;
import com.example.realestatego.entity.Agent;
import com.example.realestatego.exception.ResourceNotFoundException;
import com.example.realestatego.service.AgentService;

import jakarta.validation.Valid;

// RestController annotation to mark this class as a controller handling RESTful requests
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AgentController {

    // Autowired annotation to inject the AgentService bean
	@Autowired
	private AgentService agentService;

    // PostMapping annotation to handle HTTP POST requests to "/agent/add"
	@PostMapping("/agentSignUp")

    // Valid annotation to perform validation on the request body
	public Agent addNewAgent(@RequestBody @Valid Agent agent) {
        // Call the AgentService to add a new Agent
		return agentService.addNewAgent(agent);
	}

    // GetMapping annotation to handle HTTP GET requests to "/agent/viewall"
	@GetMapping("/agent/viewall")

    // ResponseEntity to return a response with HTTP status and a list of AgentDTOs
	public List<AgentDTO> getAllAgents() {
        // Call the AgentService to get all agents
		return agentService.getAllAgents();
	}

    // GetMapping annotation to handle HTTP GET requests to "/agent/{agentId}"
	@GetMapping("/agent/{agentId}")

    // ResponseEntity to return a response with HTTP status and either a list of AgentDTOs or an error message
	public ResponseEntity<Object> getAgentById(@PathVariable String agentId) {
		try {
            // Try to find the agent by ID and return it with HTTP OK status
			List<AgentDTO> agent = agentService.findAgentById(agentId);
			return new ResponseEntity<>(agent, HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
            // If the agent is not found, return an error message with HTTP NOT FOUND status
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

    // PutMapping annotation to handle HTTP PUT requests to "/agent/update/{agentId}"
	@PutMapping("/agent/update/{agentId}")

    // ResponseEntity to return a response with HTTP status and either the updated Agent or an error message
	public ResponseEntity<Object> updateAgent(@PathVariable String agentId, @Valid @RequestBody Agent updatedAgent) {
		try {
            // Try to update the agent and return the updated agent with HTTP OK status
			Agent updatedAgentResult = agentService.updateAgent(agentId, updatedAgent);
			return new ResponseEntity<>(updatedAgentResult, HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
            // If the agent is not found, return an error message with HTTP NOT FOUND status
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

//    @DeleteMapping("/{agentId}")
//    public String deleteAgent(@PathVariable int agentId) {
//        agentService.deleteAgent(agentId);
//        return "Agent with id " + agentId + " deleted successfully.";
//    }
}
