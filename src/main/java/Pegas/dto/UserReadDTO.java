package Pegas.dto;

import lombok.Value;
import org.springframework.stereotype.Component;

@Value
public class UserReadDTO {
    Long id;
    String userName;
    Integer age;
    String email;
}
