package com.springboot.demo.demo.controller;


import com.springboot.demo.demo.model.Institute;
import com.springboot.demo.demo.service.CBRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class BlogController {
  
    @Autowired
    CBRepositoryImpl cBRepositoryImpl;
    static final Logger logger =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";

    }

    @PostMapping("/institute")
    public Object addBlogPost(@RequestBody Institute institute) throws Exception {

        return cBRepositoryImpl.save(institute, institute.getInstituteId());
    }

    @GetMapping("/institute/{id}")
    public Optional<Object> getBlog(@PathVariable Long id) throws IOException {

            return cBRepositoryImpl.getById(id);

    }
    @DeleteMapping("/institute/{id}")
    public String deleteById(@PathVariable String id) {
        return cBRepositoryImpl.deleteBy(id);
    }

  /*  @GetMapping("/blogs/author/{author}")
    public Blogs getBlogByAuthorName(@PathVariable String author) {
        return blogRepository.findByAuthor(author);
    }*/

   /* @DeleteMapping("/blogs/topic/{topic}/author/{author}")
    public List<Blogs> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteBytopicAndAuthor(topic, author);
    }

    @DeleteMapping("/blogs/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }

    @PutMapping("/blogs/{idToBeUpdated}")
    public String updateBlog(@PathVariable String idToBeUpdated, @RequestBody BlogsUpdateRequest blogsUpdateRequest) {

        Optional<Blogs> mayBeBlog = blogRepository.findById(idToBeUpdated)
                .map(blogs -> blogRepository
                        .save(Blogs
                                .builder()
                                .id(idToBeUpdated)
                                .topic(blogsUpdateRequest.getTopic())
                                .tags(blogsUpdateRequest.getTags())
                                .author(blogs.getAuthor())
                                .date(blogs.getDate())
                                .build())
                );
        if (mayBeBlog.isPresent()) {
            return "Blog Updated";
        } else {
            return "Blog does not exist";
        }
    }*/
}