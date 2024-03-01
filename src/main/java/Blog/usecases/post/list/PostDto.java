package Blog.usecases.post.list;

import java.util.Date;

public record PostDto(
		 String id,
		 String title,
		 String content,
		 String author,
		 Date date
){

}
