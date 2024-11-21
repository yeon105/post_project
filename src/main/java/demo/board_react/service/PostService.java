package demo.board_react.service;

import demo.board_react.data.dao.PostDAO;
import demo.board_react.data.dto.PostDTO;
import demo.board_react.data.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostDAO postDAO;

    public List<PostDTO> allPosts() {
        List<PostEntity> postEntities = this.postDAO.allPosts();
        List<PostDTO> postDTOs = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            PostDTO postDTO = PostDTO.builder()
                    .postId(postEntity.getPostId())
                    .title(postEntity.getTitle())
                    .content(postEntity.getContent())
                    .build();
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

//    public Integer onePost(Integer postId) {
//        PostEntity postEntity = this.postDAO.onePost(postId);
//        if (postEntity != null) {
//            return postEntity.getPostId();
//        }
//        return -1;
//    }

    public PostDTO savePost(PostDTO postDTO) {
        PostEntity postEntity = this.postDAO.savePost(postDTO.getTitle(), postDTO.getContent());

        PostDTO post = PostDTO.builder()
                .postId(postEntity.getPostId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .build();
        return post;
    }

    public PostDTO updatePost(PostDTO postDTO) {
        PostEntity postEntity = this.postDAO.updatePost(postDTO.getPostId(), postDTO.getTitle(), postDTO.getContent());
        if (postEntity != null) {
            PostDTO post = PostDTO.builder()
                    .postId(postEntity.getPostId())
                    .title(postEntity.getTitle())
                    .content(postEntity.getContent())
                    .build();
            return post;
        }
        return null;
    }

    public Integer deletePost(Integer postId) {
        this.postDAO.deletePost(postId);
        return postId;
    }
}
