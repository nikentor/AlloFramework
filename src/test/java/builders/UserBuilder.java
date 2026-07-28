package builders;

import dto.request.UserDTO;

public class UserBuilder {

    public static UserDTO createUser() {

        UserDTO user  = new UserDTO();

        user.setId(1L);
        user.setUsername("nikentor");
        user.setFirstName("Andriy");
        user.setLastName("Ninichuk");
        user.setEmail("andriy@test.com");
        user.setPassword("b3UJ3JLb");
        user.setPhone("+380671003263");
        user.setUserStatus(1);

        return user;
    }
}
