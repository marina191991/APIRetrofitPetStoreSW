package org.example.PetTest;

import lombok.SneakyThrows;
import org.example.DTO.Pet;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FindByStatusTest extends AbstractProductTest {
    @Test
    @SneakyThrows
    void findByStatus() {

        Response<List<Pet>> response = petService.getListPetsByStatus("available", "application/json").execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assert response.body() != null;
       response.body().forEach(pet->assertThat(pet.getStatus(),equalTo("available")));

}}
