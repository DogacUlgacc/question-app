package com.dogac.questionapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

    Long id ;
    String text;
    String title;
    Long userId;

}
