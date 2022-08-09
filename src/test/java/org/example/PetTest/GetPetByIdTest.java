package org.example.PetTest;

import lombok.SneakyThrows;
import org.example.DTO.Pet;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class GetPetByIdTest extends AbstractProductTest {
    @Test
    @SneakyThrows
    void getPetById() {
        Response<Pet> response = petService.getPetById(petId, "application/json").execute();
        response.body().getId().equals(petId);
        assertThat(response.code(), CoreMatchers.is(200));

    }
}
