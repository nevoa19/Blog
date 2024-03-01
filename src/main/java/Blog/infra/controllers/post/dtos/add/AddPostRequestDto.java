package Blog.infra.controllers.post.dtos.add;

import java.util.Date;

public record AddPostRequestDto(String title,String content,String author,Date date) {

}
