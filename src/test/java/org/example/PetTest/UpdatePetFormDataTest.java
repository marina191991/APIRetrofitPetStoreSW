package org.example.PetTest;


import lombok.SneakyThrows;
import org.example.DTO.Pet;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class UpdatePetFormDataTest extends AbstractProductTest {
    Map<String, String> name = new HashMap<>();
    Map<String, String> status = new HashMap<>();


    @SneakyThrows
    @Test
    void updatePetFormData() {
        prop.load(getConfigFile());
        name.put("name", prop.getProperty("name"));
        status.put("status", prop.getProperty("status"));

        Response<Pet> response = petService.updatePetFormData(petId, name, status,
                "application/json", "application/x-www-form-urlencoded").execute();
        assertThat(response.code(),CoreMatchers.is(200));
        assertThat(response.body().getMessage(),CoreMatchers.is(Long.toString(petId)));

    }
}
