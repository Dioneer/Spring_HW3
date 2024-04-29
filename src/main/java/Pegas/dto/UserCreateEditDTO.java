package Pegas.dto;

import lombok.Value;

@Value
public class UserCreateEditDTO {
    String userName;
    Integer age;
    String email;
}
