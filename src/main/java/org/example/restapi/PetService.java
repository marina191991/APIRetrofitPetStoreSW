package org.example.restapi;

import okhttp3.RequestBody;
import org.example.DTO.Pet;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface PetService {

    @GET("pet/{petId}")
    Call<Pet> getPetById(@Path("petId") Long petId, @Header("accept") String accept);

    @GET("pet/findByStatus")
    Call<List<Pet>> getListPetsByStatus(@Query("status") String status, @Header("accept") String accept);

    @POST("pet")
    Call<Pet> createPet(@Body Pet createPet);

    @FormUrlEncoded //formData
    @POST("pet/{petId}")
    Call<Pet> updatePetFormData(@Path("petId") Long petId, @FieldMap Map<String, String> name,
                                @FieldMap Map<String, String> status,
                                @Header("accept") String accept,
                                @Header("Content-Type") String contentType);

    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<Pet> uploadPetImage(@Path("petId") Long petId,
                             @PartMap Map<String, RequestBody> map,
                             @Header("accept") String accept,
                             @Header("Content-Type") String contentType);


    @PUT("pet")
    Call<Pet> updatePet(@Body Pet pet, @Header("Content-Type") String contentType);

    @DELETE("pet/{petId}")
    Call<Pet> deletePet(@Path("petId") Long petId, @Header("accept") String accept);
}
