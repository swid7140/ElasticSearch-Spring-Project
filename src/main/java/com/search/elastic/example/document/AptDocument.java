package com.search.elastic.example.document;

import com.search.elastic.example.controller.Apt;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Getter @Setter
@Builder
@Setting(replicas = 0)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "apt")
public class AptDocument {
    @Id
    private Long id;
    @Field(type = FieldType.Text, analyzer = "nori")
    private String address;
    @Field(type = FieldType.Text)
    private String dp;

    public static AptDocument from(Apt apt){
        return AptDocument.builder()
                .id(apt.getId())
                .address(apt.getAddress())
                .dp(apt.getDp())
                .build();
    }
}
