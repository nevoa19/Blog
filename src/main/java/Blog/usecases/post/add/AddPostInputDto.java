package Blog.usecases.post.add;

import java.util.Date;

public record AddPostInputDto(String title,String content,String author,Date date) {
}
