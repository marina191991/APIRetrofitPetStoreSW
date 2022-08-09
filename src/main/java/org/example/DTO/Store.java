package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;


@JsonInclude(JsonInclude.Include.NON_NULL)
@With
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor

public class Store {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("petId")
    private Long petId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("shipDate")
    private String shipDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("complete")
    private Boolean complete;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
    @JsonProperty("sold")
    private Integer sold;
    @JsonProperty("string")
    private Integer string;
    @JsonProperty("unavailable")
    private Integer unavailable;
    @JsonProperty("avaliable")
    private Integer avaliable;
    @JsonProperty("pending")
    private Integer pending;
    @JsonProperty("available")
    private Integer available;
    @JsonProperty("invalid")
    private Integer invalid;
    @JsonProperty("additionalProp1")
    private Integer additionalProp1;
    @JsonProperty("additionalProp2")
    private Integer additionalProp2;
    @JsonProperty("additionalProp3")
    private Integer additionalProp3;







     /* {
      "sold": 3,
  "string": 276,
  "unavailable": 3,
  "avaliable": 1,
  "pending": 5,
  "available": 663,
  "invalid": 1,
  "status": 28,
  "Unavailable": 2
  "additionalProp1": 0,
  "additionalProp2": 0,
  "additionalProp3": 0

        "id": 0,
            "petId": 1,
            "quantity": 0,
            "shipDate": "2022-08-06T13:04:00.696Z",
            "status": "placed",
            "complete": true
    }
    "code": 200,
  "type": "unknown",
  "message": "1"*/


}
