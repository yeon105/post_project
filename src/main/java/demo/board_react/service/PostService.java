package demo.board_react.service;

import demo.board_react.data.dto.PostDTO;
import demo.board_react.data.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<PostDTO> allPosts();

//    Integer onePost(Integer postId);

    PostDTO savePost(PostDTO postDTO);

    PostDTO updatePost(PostDTO postDTO);

    Integer deletePost(Integer postId);

    /**
     * postEntity -> postDTO 변환
     *
     * @param postEntity
     * @return postDTO
     */
    default PostDTO toDTO(PostEntity postEntity) {
        return PostDTO.builder()
                .postId(postEntity.getPostId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .build();
    }
}
