package Blog.usecases.post.list;

import java.util.List;

public record ListPostOutputDto(List<PostDto> posts) {

	public List<Blog.infra.controllers.post.dtos.list.PostDto> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}


}
