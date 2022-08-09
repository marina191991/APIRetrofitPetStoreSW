package org.example.StoreTest;

import lombok.SneakyThrows;
import org.example.DTO.Store;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class FindByIdTest extends AbstractStoreTest {
    @SneakyThrows
    @Test
    void findOrderById() {
        Response<Store> response = storeService.getOrderById(id, "application/json").execute();
        assertThat(response.code(),CoreMatchers.is(200) );
        response.body().getId().equals(id);
        response.body().getPetId().equals(petId);
        String.valueOf(response.body().getShipDate()).equals(shipDate);

    }
}
