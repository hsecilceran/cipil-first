package com.cipil.first.controller;

import com.cipil.first.model.Post;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dinco-WORK on 22.06.2017.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {

    @RequestMapping(method= RequestMethod.GET, value = "/{id}")
    Post getPost(@PathVariable Long id){
        Post post = new Post();
        post.setId(id);
        post.setTitle("Fight Club");
        post.setBody("Fight Club Post Body is awesome");
        return post;
    }

    @RequestMapping
    List<Post> getPosts(
            @RequestParam String sort,
            @RequestParam String range,
            @RequestParam String filter,
            HttpServletResponse response
    ){
        response.setHeader("Access-Control-Expose-Headers", "Content-Range");
        response.setHeader("Content-Range", "1");
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1234386L, "Fight Club"));
        return posts;
    }
}
