package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) //игнорирует незаданные значения при сериализации
@With //создает методы типа сеттеры, но возвращает не void , а тип класса (в нашем случае Pet). Для данной аннотации нужен пустой конструктор
@Getter
@NoArgsConstructor//пустой конструктор
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //игнорирует несуществующие значения при десериализации
public class Pet {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<Tag> tags;
    @JsonProperty("status")
    private String status;


    @JsonInclude(JsonInclude.Include.NON_NULL) //игнорирует незаданные значения при сериализации
    @With
//создает методы типа сеттеры, но возвращает не void , а тип класса (в нашем случае Pet). Для данной аннотации нужен пустой конструктор
    @Getter
    @NoArgsConstructor//пустой конструктор
    public static class Category {
        private Integer id;
        private String name;

        public Category(Integer id, String name) {
            this.id = id;
            this.name = name;
        }


    }

    @JsonInclude(JsonInclude.Include.NON_NULL) //игнорирует незаданные значения при сериализации
    @With
//создает методы типа сеттеры, но возвращает не void , а тип класса (в нашем случае Pet). Для данной аннотации нужен пустой конструктор
    @Getter
    @NoArgsConstructor//пустой конструктор
    public static class Tag {
        private Integer id;
        private String name;

        public Tag(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }


}
