package Blog.usecases.post.add;

import java.util.Date;

public record AddPostOutputDto(String id,String title,String content,String author,Date date) {

}