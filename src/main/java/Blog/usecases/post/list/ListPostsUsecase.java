package Blog.usecases.post.list;

import java.util.ArrayList;
import java.util.List;

import Blog.domain.post.entities.Post;
import Blog.domain.post.gateway.PostGateway;
import Blog.usecases.Usecase;

public class ListPostsUsecase implements Usecase<ListPostInputDto, ListPostOutputDto> {

	private PostGateway postGateway;
	//to do UserGatewat???????????????
	private ListPostsUsecase(PostGateway postGateway) {
		this.postGateway = postGateway;
	}

	public static ListPostsUsecase create(PostGateway postGateway) {
		return new ListPostsUsecase(postGateway);
	}

	@Override
	public ListPostOutputDto execute(ListPostInputDto input) {
		List<Post> posts;
		if (input.userId() != null) {
			posts = postGateway.postsByUserId(input.userId());
		} else {
			posts = postGateway.allPosts();
		}

		return createOutput(posts);
	}

	private ListPostOutputDto createOutput(List<Post> posts) {
		List<PostDto> postDtos = new ArrayList<>();

		for (Post post : posts) {
			PostDto postDto = new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor(),
					post.getDate());
			postDtos.add(postDto);
		}

		return new ListPostOutputDto(postDtos);
	}
}
