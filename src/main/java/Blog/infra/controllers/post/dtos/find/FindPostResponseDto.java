package Blog.infra.controllers.post.dtos.find;

import java.util.Date;

public record FindPostResponseDto(String id, 
		String title,
		String content,
		String author,
		Date date) {

}
