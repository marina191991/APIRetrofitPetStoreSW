package org.example.PetTest;

import lombok.SneakyThrows;
import org.example.DTO.Pet;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateFullPetTest extends AbstractProductTest {



@Test
   @SneakyThrows
void createPet ()  {
prop.load(getConfigFile());
         Pet.Category category=new Pet.Category(0,"string");
        List<String> photoUrls=new ArrayList<>();
    photoUrls.add("string");
    Pet.Tag tags = new Pet.Tag(0,"string");
    List<Pet.Tag> tag=new ArrayList<>();
    tag.add(tags);
    pet=new Pet()
            .withId(petId)
            .withCategory(category)
            .withName(prop.getProperty("name"))
            .withPhotoUrls(photoUrls)
            .withTags(tag)
            .withStatus("sold");
    Response<Pet> response = petService.updatePet(pet,"application/json").execute();
    assertThat(response.body().getName(),CoreMatchers.is(prop.getProperty("name")));
    assertThat(response.body().getStatus(),CoreMatchers.is("sold"));
    assertThat(response.isSuccessful(), CoreMatchers.is(true));
    petId=response.body().getId();

}
}
