package com.thiha.roomrent.service;
import java.util.List;
import java.util.Map;

import com.thiha.roomrent.dto.AgentDto;
import com.thiha.roomrent.dto.AllRoomPostsResponse;
import com.thiha.roomrent.dto.RoomPostDto;
import com.thiha.roomrent.dto.RoomPostRegisterDto;

public interface RoomPostService {
   RoomPostDto createRoomPost(RoomPostRegisterDto roomPostRegisterDto, AgentDto agent);
   RoomPostDto findRoomPostById(Long id);
   RoomPostDto findRoomPostById(Long id, AgentDto agentDto);
   RoomPostDto updateRoomPost(Long postId,AgentDto agent, RoomPostRegisterDto updateRoomPost);
   RoomPostDto reactivateRoomPost(Long id, AgentDto currentAgent);
   List<RoomPostDto> getRoomPostsByAgentId(Long agentId);
   List<RoomPostDto> getActiveRoomPostsByAgentId(Long agentId);
   List<RoomPostDto> getArchivedRoomPostsByAgentId(Long agentId);
   AllRoomPostsResponse getAllActiveRoomPosts(int pageNo, int pageSize, Map<String, String> searchFilter);
   void deleteRoomPostById(Long id, AgentDto currentAgent);
   Map<String, Object> getRoomPostRegisterMetadata();
}
