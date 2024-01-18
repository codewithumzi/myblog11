package com.myblog.myblog11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    //in this payload i should exactly have same names as entity
    private long id;
    private String title;
    private String description;
    private String content;
}
