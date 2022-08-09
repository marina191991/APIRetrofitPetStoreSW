package org.example.UserTest;

import lombok.SneakyThrows;
import org.example.DTO.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class getUserByNameTest extends AbstractUserTest {
    @SneakyThrows
    @Test
    void getUserByName() {
        Response<User> response = userService.getUsrByName(prop.getProperty("userName"), "application/json").execute();
        assertThat(response.body().getUsername(), CoreMatchers.is(prop.getProperty("userName")));
        assertThat(response.body().getId(), is(notNullValue()));
        assertThat(response.body().getUsername(), is(notNullValue()));
        assertThat(response.body().getPassword(), is(notNullValue()));
    }
}
