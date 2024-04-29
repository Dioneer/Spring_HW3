package Pegas.mapper;

import Pegas.dto.UserReadDTO;
import Pegas.entity.User;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
public class UserReadMapper implements Mapper<User, UserReadDTO>{
    @Override
    public UserReadDTO fromTo(User i) {
        return new UserReadDTO(i.getId(),i.getUserName(),i.getAge(),i.getEmail());
    }
}
