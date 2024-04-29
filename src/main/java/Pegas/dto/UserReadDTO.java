package Pegas.dto;

import jakarta.persistence.Column;
import lombok.Value;

@Value
public class UserReadDTO {
    Long id;
    String userName;
    Integer age;
    String email;
}
