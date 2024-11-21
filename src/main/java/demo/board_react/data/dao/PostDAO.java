package demo.board_react.data.dao;

import demo.board_react.data.entity.PostEntity;
import demo.board_react.data.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostDAO {

    private final PostRepository postRepository;

    public List<PostEntity> allPosts() {
        return this.postRepository.findAll();
    }

//    public PostEntity onePost(Integer postId) {
//        if (this.postRepository.existsById(postId)) {
//            PostEntity post = this.postRepository.findById(postId).get();
//            return post;
//        }
//        return null;
//    }

    public PostEntity savePost(String title, String content) {
        PostEntity post = PostEntity.builder()
                .title(title)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
        this.postRepository.save(post);
        return post;
    }

    public PostEntity updatePost(Integer postId, String title, String content) {
        if (this.postRepository.existsById(postId)) {
            PostEntity post = this.postRepository.findById(postId).get();
            post.setTitle(title);
            post.setContent(content);
            post.setUpdatedAt(LocalDateTime.now());
            this.postRepository.save(post);
            return post;
        }
        return null;
    }

    public void deletePost(Integer postId) {
        this.postRepository.deleteById(postId);
    }
}
