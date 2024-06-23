package com.thiha.roomrent.mapper;

import com.thiha.roomrent.dto.RoomPostDto;
import com.thiha.roomrent.dto.RoomPostRegisterDto;
import com.thiha.roomrent.model.RoomPost;

public class RoomPostMapper {

   public static RoomPostDto mapToRoomPostDto(RoomPost roomPost){
    return new RoomPostDto(roomPost.getId(),
                        roomPost.getStationName(),
                        roomPost.getPrice(),
                        roomPost.getRoomType(),
                        roomPost.getTotalPax(),
                        roomPost.getCookingAllowance(),
                        roomPost.getSharePub(),
                        roomPost.getAirConTime(),
                        roomPost.isAllowVisitor(),
                        roomPost.getLocation(),
                        roomPost.getPropertyType(),
                        roomPost.getDescription(),
                        roomPost.getAgent(),
                        roomPost.getPostedAt(),
                        roomPost.getRoomPhotos());
   }

   public static RoomPost mapToRoomPost(RoomPostDto roomPostDto){
      RoomPost roomPost = RoomPost.builder()
                              .id(roomPostDto.getId())
                              .agent(roomPostDto.getAgent())
                              .airConTime(roomPostDto.getAirConTime())
                              .allowVisitor(roomPostDto.isAllowVisitor())
                              .cookingAllowance(roomPostDto.getCookingAllowance())
                              .description(roomPostDto.getDescription())
                              .location(roomPostDto.getLocation())
                              .postedAt(roomPostDto.getPostedAt())
                              .price(roomPostDto.getPrice())
                              .propertyType(roomPostDto.getPropertyType())
                              .roomPhotos(roomPostDto.getRoomPhotos())
                              .roomType(roomPostDto.getRoomType())
                              .sharePub(roomPostDto.getSharePub())
                              .stationName(roomPostDto.getStationName())
                              .totalPax(roomPostDto.getTotalPax())
                              .build();
    return roomPost;
   }

   public static RoomPostDto mapToRoomPostDtoFromRoomPostRegisterDto(RoomPostRegisterDto registerDto){
      return new RoomPostDto(registerDto.getId(),
                        registerDto.getStationName(),
                        registerDto.getPrice(),
                        registerDto.getRoomType(),
                        registerDto.getTotalPax(),
                        registerDto.getCookingAllowance(),
                        registerDto.getSharePub(),
                        registerDto.getAirConTime(),
                        registerDto.isAllowVisitor(),
                        registerDto.getLocation(),
                        registerDto.getPropertyType(),
                        registerDto.getDescription(),
                        registerDto.getAgent(),
                        registerDto.getPostedAt(),
                        registerDto.getRoomPhotos());
   }

}
