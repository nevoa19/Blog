package Blog.usecases.post.find;

import java.util.Date;

public record FindPostOutputDto(String id,String title,String content,String author,Date date) {

	

}