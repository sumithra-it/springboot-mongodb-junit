package com.ns.api;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
//import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class FruitModel {

    @Id @NonNull
    private final String id;
    @NonNull private final String name;
    @NonNull private final String color;
    private final int stock;
    private final float priceperpound;

}
