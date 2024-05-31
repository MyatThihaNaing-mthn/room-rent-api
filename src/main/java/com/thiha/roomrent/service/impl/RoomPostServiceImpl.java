package com.thiha.roomrent.service.impl;
import java.util.List;

import com.thiha.roomrent.dto.AllRoomPostsResponse;
import com.thiha.roomrent.dto.RoomPostDto;
import com.thiha.roomrent.dto.RoomPostRegisterDto;
import com.thiha.roomrent.model.Agent;

public interface RoomPostServiceImpl {
   RoomPostDto createRoomPost(RoomPostRegisterDto roomPostRegisterDto, Agent agent);
   RoomPostDto findRoomPostById(Long id);
   RoomPostDto updateRoomPost(RoomPostDto originalRoomPost, RoomPostRegisterDto updateRoomPost);
   List<RoomPostDto> getRoomPostsByAgentId(Long agentId);
   AllRoomPostsResponse getAllRoomPosts(int pageNo, int PageSize, String sortedBy);
   void deleteRoomPostById(Long id);
}
