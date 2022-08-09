package org.example.UserTest;

import lombok.SneakyThrows;
import org.example.DTO.User;
import org.example.restapi.UserService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;

public class LogsUserTest {
    static Properties prop = new Properties();
    static private InputStream config;

    @Test
    @SneakyThrows
    void logsUser() {
        config = new FileInputStream("src/test/resources/my.properties");
        prop.load(config);
        UserService userService = RetrofitUtils.getRetrofit().create(UserService.class);

        Response<User> response = userService.loginUser(prop.getProperty("userName"), "password",
                "application/json").execute();
        assertThat(response.code(), CoreMatchers.is(200));
    }
}
