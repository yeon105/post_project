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
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    public List<PostDTO> allPosts() {
        List<PostEntity> postEntities = this.postDAO.allPosts();
        List<PostDTO> postDTOs = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            PostDTO postDTO = toDTO(postEntity);
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
        return toDTO(postEntity);
    }

    public PostDTO updatePost(PostDTO postDTO) {
        PostEntity postEntity = this.postDAO.updatePost(postDTO.getPostId(), postDTO.getTitle(), postDTO.getContent());
        if (postEntity != null) {
            return toDTO(postEntity);
        }
        return null;
    }

    public Integer deletePost(Integer postId) {
        this.postDAO.deletePost(postId);
        return postId;
    }
}
