package demo.board_react.data.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

    private Integer postId;
    @NotEmpty(message = "제목은 비어있을 수 없습니다.")
    private String title;
    @NotEmpty(message = "내용은 비어있을 수 없습니다.")
    @Size(max = 20, message = "최대 20자까지 작성할 수 있습니다.")
    private String content;
}
