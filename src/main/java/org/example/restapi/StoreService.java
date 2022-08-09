package org.example.restapi;

import org.example.DTO.Store;
import retrofit2.Call;
import retrofit2.http.*;

public interface StoreService {
    @POST("store/order")
    Call<Store> createOrder(@Body Store createStore, @Header("accept") String accept, @Header("Content-Type") String contentType);

    @GET("store/order/{orderId}")
    Call<Store> getOrderById(@Path("orderId") Long orderId, @Header("accept") String accept);

    @GET("store/inventory")
    Call<Store> getInventory(@Header("accept") String accept);

    @DELETE("store/order/{orderId}")
    Call<Store> deleteByOrderId(@Path("orderId") Long orderId, @Header("accept") String accept);


}
