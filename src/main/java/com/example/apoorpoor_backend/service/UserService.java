package com.example.apoorpoor_backend.service;

import com.example.apoorpoor_backend.dto.UserResponseDto;
import com.example.apoorpoor_backend.model.User;
import com.example.apoorpoor_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<Long> setAge(Long age, String username) {
        User finduser = userCheck(username);
        finduser.updateAge(age);
        return new ResponseEntity<>(age, HttpStatus.OK);
    }

    public ResponseEntity<String> setGender(String gender, String username){
        User findUser = userCheck(username);
        findUser.updateGender(gender);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    public ResponseEntity<UserResponseDto> userInfo(String username) {
        User findUser = userCheck(username);
        return new ResponseEntity<>(new UserResponseDto(findUser), HttpStatus.OK);
    }

    public User userCheck(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저 입니다.")
        );
    }
}
