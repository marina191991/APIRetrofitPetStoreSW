package org.example.UserTest;

import lombok.SneakyThrows;
import org.example.DTO.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateUserTest extends AbstractUserTest{
    @Test
    @SneakyThrows
    void updateUser() {
        user=new User()
                .withId(0L)
                .withUsername(prop.getProperty("userName"))
                .withFirstName("Danya")
                .withLastName("Popov")
                .withEmail("xxx@mail.ru")
                .withPassword("1234")
                .withPhone("79075545687")
                .withUserStatus(0);
        Response<User> response =userService.upDateUsr(prop.getProperty("userName"),user,"application/json","application/json").execute();
assertThat(response.code(), CoreMatchers.is(200));


    }
}
