package Pegas.service;

import Pegas.dto.UserCreateEditDTO;
import Pegas.dto.UserReadDTO;
import Pegas.entity.User;
import Pegas.mapper.UserCreateEditMapper;
import Pegas.mapper.UserReadMapper;
import Pegas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final UserCreateEditMapper userCreateEditMapper;
    private final UserReadMapper userReadMapper;

    @Transactional
    public UserReadDTO create(UserCreateEditDTO user){
        return Optional.of(user)
                .map(i-> userCreateEditMapper.fromTo(i, new User()))
                .map(userRepository::save)
                .map(userReadMapper::fromTo)
                .orElseThrow();
    }
}
