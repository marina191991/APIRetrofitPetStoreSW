package org.example.PetTest;

import lombok.SneakyThrows;
import org.example.DTO.Pet;
import org.example.restapi.PetService;
import org.example.utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import retrofit2.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;

public class AbstractProductTest {
    static PetService petService;
    static Properties prop = new Properties();
    private static InputStream image;
    Pet pet;
    Long petId;
    private static InputStream configFile;


    public static InputStream getConfigFile() {
        return configFile;
    }


    static {
        try {
            configFile = new FileInputStream("src/test/resources/my.properties");
            image=new FileInputStream("src/test/resources/test.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @BeforeAll
    static void beforeAll() {
        petService = RetrofitUtils.getRetrofit().create(PetService.class);
    }

    @SneakyThrows
    @BeforeEach
    void createPet() {
        Pet.Category category = new Pet.Category(0, "string");
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        Pet.Tag tags = new Pet.Tag(0, "string");
        List<Pet.Tag> tag = new ArrayList<>();
        tag.add(tags);
        pet = new Pet()
                .withId(253L)
                .withCategory(category)
                .withName("Bobik")
                .withPhotoUrls(photoUrls)
                .withTags(tag)
                .withStatus("available");
        Response<Pet> response = petService.createPet(pet).execute();
        petId = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<Pet> response = petService.deletePet(petId, "application/json").execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }


}
