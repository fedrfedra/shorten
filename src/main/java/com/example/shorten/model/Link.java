package com.example.shorten.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "links")
public class Link {

    @Id
    private String shortLink;
    private String longLink;
    private String creatorName;
    private int redirectCount;
}
