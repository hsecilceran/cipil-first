package com.cipil.first.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dinco-WORK on 22.06.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String teaser;
    private String body;
    private String published_at;
    private String average_note;
    private Integer views;

    public Post(Long id, String title){
        this.id = id;
        this.title = title;
    }
}
