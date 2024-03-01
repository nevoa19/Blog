package Blog.infra.controllers.post.dtos.add;

import java.util.Date;

public record AddPostResponseDto(String id, String title,String content,String author,Date date) {

}
