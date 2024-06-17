package com.example.realestatego.service;

import java.util.List;

import com.example.realestatego.dto.AgentDTO;
import com.example.realestatego.entity.Agent;
import com.example.realestatego.exception.ResourceNotFoundException;

//This is the service interface for handling business logic related to Agent entities
public interface AgentService {
 // This is  used to add a new Agent
 public Agent addNewAgent(Agent agent);

 // This method is  used to update existing Agent
 public Agent updateAgent(String agentId, Agent agent) throws ResourceNotFoundException;

 // This method is used to get a list of all Agents as DTOs
 public List<AgentDTO> getAllAgents();

 // This method is used to finding an Agent by ID and returning it as a DTO
 public List<AgentDTO> findAgentById(String id) throws ResourceNotFoundException;
}