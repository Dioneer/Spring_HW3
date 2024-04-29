package Pegas.mapper;

import Pegas.dto.UserCreateEditDTO;
import Pegas.entity.User;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
public class UserCreateEditMapper implements Mapper<UserCreateEditDTO, User>{
    @Override
    public User fromTo(UserCreateEditDTO i) {
        return User.builder()
                .userName(i.getUserName())
                .age(i.getAge())
                .email(i.getEmail())
                .build();
    }
    public User fromTo(UserCreateEditDTO i, User user) {
        user.setUserName(i.getUserName());
        user.setAge(i.getAge());
        user.setEmail(i.getEmail());
        return user;
    }
}
