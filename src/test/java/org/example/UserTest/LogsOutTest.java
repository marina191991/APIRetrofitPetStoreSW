package org.example.UserTest;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.example.restapi.UserService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class LogsOutTest {
    @Test
    @SneakyThrows
    void logsOut () {
        UserService userService = RetrofitUtils.getRetrofit().create(UserService.class);
        Response<ResponseBody> response = userService.logout().execute();
        assertThat(response.code(), CoreMatchers.is(200));
    }
}
