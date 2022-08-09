package org.example.restapi;

import okhttp3.ResponseBody;
import org.example.DTO.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UserService {

    @POST("user/createWithArray")
    Call<List<User>> createUsrWithArray(@Body User body);

    @POST("user/createWithList")
    Call<List<User>> createUsrWithList(@Body User body);

    @GET("user/{userName}")
    Call<User> getUsrByName(@Path("userName") String userName, @Header("accept") String accept);

    @PUT("user/{userName}")
    Call<User> upDateUsr(@Path("userName") String userName, @Body User body, @Header("Content-Type") String contentType,
                         @Header("accept") String accept);

    @DELETE("user/{userName}")
    Call<User> deleteUsr(@Path("userName") String userName);

    @GET("user/login")
    Call<User> loginUser(@Query("username") String userName, @Query("password") String password, @Header("accept") String accept);

    @GET("user/logout")
    Call<ResponseBody> logout();

    @POST("user")
    Call<User> createUser(@Body User body, @Header("Content-Type") String contentType, @Header("accept") String accept);


}
