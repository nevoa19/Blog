package Blog.usecases.post.add;

import Blog.domain.post.entities.Post;
import Blog.domain.post.gateway.PostGateway;
import Blog.usecases.Usecase;

public class AddPostUsecase implements Usecase<AddPostInputDto, AddPostOutputDto> {
	private PostGateway postGateway;
	//to do Usergateway

	private AddPostUsecase(PostGateway postGateway) {
		this.postGateway = postGateway;
	}

	public static AddPostUsecase create(final PostGateway aGateway) {
		return new AddPostUsecase(aGateway);
	}

	@Override
	public AddPostOutputDto execute(final AddPostInputDto input) {
		final var aPost = Post.create(input.title(), input.content(),input.author());
		postGateway.save(aPost);

		return new AddPostOutputDto(aPost.getId(), aPost.getTitle(), aPost.getContent(),aPost.getAuthor(),aPost.getDate());
	}
}

