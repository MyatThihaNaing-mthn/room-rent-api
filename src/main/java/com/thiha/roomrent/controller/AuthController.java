package com.thiha.roomrent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thiha.roomrent.dto.AgentDto;
import com.thiha.roomrent.dto.AgentRegisterDto;
import com.thiha.roomrent.dto.LoginRequestDto;
import com.thiha.roomrent.dto.LoginResponseDto;
import com.thiha.roomrent.service.AgentService;
import com.thiha.roomrent.service.LoginService;
import com.thiha.roomrent.validator.ObjectValidator;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
   private final AgentService agentService;
   private final AuthenticationManager authenticationManager;
   private final LoginService loginService;
   private final ObjectValidator<AgentRegisterDto> agentRegisterValidator;

   @PostMapping("/agent/register")
   private ResponseEntity<?> registerAgent(@ModelAttribute AgentRegisterDto registeredAgent){
        agentRegisterValidator.doVaildation(registeredAgent);
        AgentDto savedAgent =  agentService.createAgent(registeredAgent);
        return new ResponseEntity<>(savedAgent, HttpStatus.CREATED);
    }


  
   @PostMapping("/agent/login")
   private ResponseEntity<LoginResponseDto> loginAgent(@RequestBody LoginRequestDto loginDto){
        LoginResponseDto loginResponse = loginService.performLogin(loginDto, authenticationManager);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
   }

   @PostMapping("/admin/login")
   private ResponseEntity<LoginResponseDto> loginAdmin(@RequestBody LoginRequestDto loginDto){
     LoginResponseDto loginResponse = loginService.performLogin(loginDto, authenticationManager);
     return new ResponseEntity<LoginResponseDto>(loginResponse, HttpStatus.OK);
   }
}
