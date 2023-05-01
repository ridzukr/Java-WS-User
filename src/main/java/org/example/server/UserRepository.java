package org.example.server;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static final Map<String, User> users = new HashMap<>();

    static {
        initData();
    }

    private static void initData() {
        User user = new User();
        user.setName("Tom");
        user.setPhone("068 325-4455");
        user.setGender(Gender.MALE);
        user.setAge(26);

        users.put(user.getName(), user);

        User user1 = new User();
        user1.setName("Bob");
        user1.setPhone("098 254-3377");
        user1.setGender(Gender.MALE);
        user1.setAge(33);

        users.put(user1.getName(), user1);


        User user2 = new User();
        user2.setName("Kat");
        user2.setPhone("063 458-7788");
        user2.setGender(Gender.FEMALE);
        user2.setAge(22);

        users.put(user2.getName(), user2);
    }

    public User findUser(String name) {
        return users.get(name);
    }
}
