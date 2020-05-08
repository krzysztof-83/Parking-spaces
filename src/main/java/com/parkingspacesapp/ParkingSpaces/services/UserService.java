package com.parkingspacesapp.ParkingSpaces.services;

import com.parkingspacesapp.ParkingSpaces.common.dto.UserDto;
import com.parkingspacesapp.ParkingSpaces.common.exceptions.UserNotFoundException;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.UserEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Set<UserDto> findAllUsers() {
            return StreamSupport
                    .stream(userRepository.findAll().spliterator(), false)
                    .map(this::convertToDto)
                    .collect(Collectors.toSet());
    }

    public UserDto addUser(UserDto userDto) {

        return null;
    }

    public UserDto findUserById(Long id) {
        if(id.equals(null)){
            throw new InvalidParameterException("Id can't be empty!");
        }
        UserEntity  foundUserById = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return convertToDto(foundUserById);
    }

    private UserDto convertToDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDto.class);
    }
    private UserEntity convertToEntity(UserDto userDto){
        return modelMapper.map(userDto, UserEntity.class);
    }
}
