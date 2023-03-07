package ua.com.alevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DotTest {

    public void test() {
        List<String> stringList = Arrays.asList("1", "2", "te", "4", "9", "ihi");
        int sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, (a, b) -> this.sum(a, b));
//        System.out.println("sum = " + sum);

        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, this::sum); // 1
//        System.out.println("sum = " + sum);

        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, MathUtil::sum); // 2
//        System.out.println("sum = " + sum);

        InnerClass innerClass = new InnerClass();
        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, innerClass::sum); // 3
//        System.out.println("sum = " + sum);


        List<User> users = getUsers();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setEmail(user.getEmail());
//            userDTO.setFirstName(user.getFirstName());
//            userDTO.setLastName(user.getLastName());
//            userDTOList.add(userDTO);
            userDTOList.add(new UserDTO(user));
        }
        System.out.println();

        userDTOList = users
                .stream()
//                .map(user -> new UserDTO(user))
                .map(UserDTO::new)
                .toList();

        for (UserDTO userDTO : userDTOList) {
            System.out.println("userDTO = " + userDTO);
        }
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setEmail("user" + i + "@mail.com");
            user.setFirstName("first" + i);
            user.setLastName("last" + i);
            user.setPassword(UUID.randomUUID().toString());
            users.add(user);
        }
        return users;
    }

    private class InnerClass {
        private int sum(int a, int b) {
            return a + b;
        }
    }
}
