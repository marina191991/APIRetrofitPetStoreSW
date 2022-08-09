package org.example.StoreTest;

import lombok.SneakyThrows;
import org.example.DTO.Store;
import org.example.restapi.StoreService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import retrofit2.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

public class AbstractStoreTest {
    static StoreService storeService;
    Store store;
    Long id;
    Long petId;
    String shipDate;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");


    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        storeService = RetrofitUtils.getRetrofit().create(StoreService.class);
    }

    @SneakyThrows
    @BeforeEach
    void createOrder() {
        store = new Store()
                .withId(0L)
                .withPetId(22L)
                .withQuantity(5)
                .withShipDate(String.valueOf(simpleDateFormat.format(new Date())))
                .withStatus("placed")
                .withComplete(true);


        Response<Store> response = storeService.createOrder(store, "application/json", "application/json").execute();

        System.out.println(response.body());
        id = response.body().getId();
        petId = response.body().getPetId();
        shipDate = String.valueOf(response.body().getShipDate());
        assertThat(response.code(), CoreMatchers.is(200));

    }

    @SneakyThrows
    @AfterEach
    void deleteOrder() {
        Response<Store> response = storeService.deleteByOrderId(id, "application/json").execute();
        assertThat(response.code(), CoreMatchers.is(200));
        assertThat(response.body().getMessage(), CoreMatchers.is(String.valueOf(id)));
    }
}
