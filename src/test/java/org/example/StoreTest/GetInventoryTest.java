package org.example.StoreTest;

import lombok.SneakyThrows;
import org.example.DTO.Store;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class GetInventoryTest extends AbstractStoreTest {
    @Test
    @SneakyThrows
    void getInventory() {
        Response<Store> response = storeService.getInventory("application/json").execute();
        assertThat(response.code(), CoreMatchers.is(200));

    }
}
