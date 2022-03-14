package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    /**
     * @param previous initial list
     * @param current  list with changes
     * @return returns statistics of completed changes
     */
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, User> userHashMap = previous.stream()
                .collect(Collectors.toMap(User::getId, u -> u));
        for (User currentUser : current) {
            User previousUser = userHashMap.remove(currentUser.getId());
            if (previousUser == null) {
                info.setAdded(+1);
            } else if (!previousUser.equals(currentUser)) {
                info.setChanged(+1);
            }
            info.setDeleted(userHashMap.size());
        }
        return info;
    }
}
