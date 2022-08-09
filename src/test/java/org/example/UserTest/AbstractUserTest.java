package org.example.UserTest;

import lombok.SneakyThrows;
import org.example.DTO.User;
import org.example.restapi.UserService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import retrofit2.Response;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;

public class AbstractUserTest {
    static UserService userService;
    User user;
      Long idUser;
   static Properties prop=new Properties();
    static private InputStream config;

    public static InputStream getConfig() {
        return config;
    }

    static {
        try {
            config=new FileInputStream("src/test/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    static void beforeAll() {
        userService = RetrofitUtils.getRetrofit().create(UserService.class);

    }

    @SneakyThrows
    @BeforeEach

    void createUser() {
       prop.load(getConfig());
        user = new User()
                .withId(0L)
                .withUsername(prop.getProperty("userName"))
                .withFirstName("Igor")
                .withLastName("Popov")
                .withEmail("xxx@mail.ru")
                .withPassword("1234")
                .withPhone("7112323456")
                .withUserStatus(0);
        Response<User> response = userService.createUser(user, "application/json", "application/json").execute();
    assertThat(response.code(), CoreMatchers.is(200));
        }
    @SneakyThrows
    @AfterEach
    void deleteUser() {
        Response<User> response=userService.deleteUsr(prop.getProperty("userName")).execute();
        assertThat(response.code(),CoreMatchers.is(200));
    }
}
