package Pegas.service;

import Pegas.dto.UserAgeFilterDto;
import Pegas.dto.UserCreateEditDTO;
import Pegas.dto.UserReadDTO;
import Pegas.mapper.UserCreateEditMapper;
import Pegas.mapper.UserReadMapper;
import Pegas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserCreateEditMapper userCreateEditMapper;
    private final UserReadMapper userReadMapper;

    public List<UserReadDTO> findAll(){
        return userRepository.findAll().stream()
                .map(userReadMapper::fromTo)
                .toList();
    }

    public List<UserReadDTO> findAll(Integer age, UserAgeFilterDto filter){
        return userRepository.findAllByFilter(age,filter).stream()
                .map(userReadMapper::fromTo)
                .toList();
    }

    public Page<UserReadDTO> findAllSortByAge(Pageable pageable){
        List<UserReadDTO> sortPageOfUsers = userRepository.findAllByOrderByAgeDesc().stream()
                .map(userReadMapper::fromTo)
                .toList();
        return new PageImpl<>(sortPageOfUsers );
    }

    public Optional<UserReadDTO> findById(Long id){
        return userRepository.findById(id)
                .map(userReadMapper::fromTo);
    }

    @Transactional
    public boolean delete(Long id){
        return userRepository.findById(id)
                .map(i->{userRepository.delete(i);
                    userRepository.flush();
                    return true;
                }).orElse(false);
    }

    @Transactional
    public UserReadDTO update(Long id, UserCreateEditDTO user){
        return userRepository.findById(id)
                .map(i-> userCreateEditMapper.fromTo(user, i))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::fromTo)
                .orElseThrow();
    }

    public Double avgOfUsersAge(){
        return userRepository.avgOfAge();
    }

}
