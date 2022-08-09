package org.example.PetTest;

import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.example.DTO.Pet;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UploadPetImageTest extends AbstractProductTest {

    //pass it like this
    File file = new File("src/test/resources/test.jpg");
    RequestBody filePart = RequestBody.create(MediaType.parse("multipart/form-data"), file);

    Map<String, RequestBody> map = new HashMap<>();


    @SneakyThrows
    @Test
    void uploadPetImage() {
        map.put(file.getName(), filePart);
        Response<Pet> response = petService.uploadPetImage(petId, map, "application/json", "multipart/form-data").execute();

        System.out.println("kjj");
    }
}
