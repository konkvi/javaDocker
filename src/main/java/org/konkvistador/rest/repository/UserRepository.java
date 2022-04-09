package org.konkvistador.rest.repository;

import org.konkvistador.rest.service.Authorities;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class UserRepository {
    Map<String, String> users = new HashMap<>();

    @PostConstruct
    public void addToMap() {
        users.put("user1", "1111");
        users.put("user2", "2222");
        users.put("user3", "3333");
    }

    public <K, V> List<Authorities> getUserAuthorities(String user, String password) {
        for (Map.Entry<String, String> entry : users.entrySet()) {
            K key = (K) entry.getKey();
            V value = (V) entry.getValue();
            if ((user.equals(key)) && (password.equals(value))) {
                return Authorities.asList();
            }
        }
        return new ArrayList<>();
    }
}
