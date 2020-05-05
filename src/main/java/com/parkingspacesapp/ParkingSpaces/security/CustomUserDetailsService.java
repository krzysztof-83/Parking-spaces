package com.parkingspacesapp.ParkingSpaces.security;

import com.parkingspacesapp.ParkingSpaces.security.CustomUserDetails;
import com.parkingspacesapp.ParkingSpaces.common.exceptions.UserNotFoundException;
import com.parkingspacesapp.ParkingSpaces.persistance.domain.UserEntity;
import com.parkingspacesapp.ParkingSpaces.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> userFoundByName = userRepository.findUserByName(userName);
        userFoundByName.orElseThrow(() -> new UserNotFoundException(userName));
        return userFoundByName.map(CustomUserDetails::new).get();
    }
}
