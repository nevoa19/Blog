package Blog.infra.controllers.post.dtos.list;

import java.util.Date;

public record PostDto(String id, 
		String title,
		String content,
		String author,
		Date date) {

}