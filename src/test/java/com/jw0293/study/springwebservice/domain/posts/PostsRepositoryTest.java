package com.jw0293.study.springwebservice.domain.posts;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired PostsRepository postsRepository;

    @After("")
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        // given
        String title = "Test Title";
        String content = "Test Content";

        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("k38836919@gmail.com")
                        .build());

        // when
        List<Posts> all = postsRepository.findAll();

        // then
        Posts posts = all.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
}
