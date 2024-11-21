package demo.board_react.controller;

import demo.board_react.data.dto.PostDTO;
import demo.board_react.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/post-list")
    public ResponseEntity<List<PostDTO>> allPosts() {
        List<PostDTO> posts = this.postService.allPosts();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

//    @GetMapping(value = "/post/{id}")
//    public ResponseEntity<String> onePost(@PathVariable("id") Integer postId) {
//        Integer id = this.postService.onePost(postId);
//        if (id != -1) {
//            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(id));
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("없는 POST");
//    }

    @PostMapping(value = "/post")
    public ResponseEntity<PostDTO> savePost(@Valid @RequestBody PostDTO postDTO) {
        PostDTO post = this.postService.savePost(postDTO);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PutMapping(value = "/post")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO) {
        PostDTO post = this.postService.updatePost(postDTO);
        if (post != null) {
            return ResponseEntity.status(HttpStatus.OK).body(post);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<Integer> deletePost(@PathVariable Integer id) {
        Integer deleted = this.postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
