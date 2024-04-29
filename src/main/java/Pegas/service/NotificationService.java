package Pegas.service;

import Pegas.dto.UserCreateEditDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(UserCreateEditDTO user) {
        System.out.println("A new user has been added: "+user.getUserName());
    }
    public void sendNotifyU(String s) {
        System.out.println("s");
    }
}
