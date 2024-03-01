package Blog.infra.controllers.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Blog.domain.post.gateway.PostGateway;
import Blog.infra.controllers.post.dtos.add.AddPostRequestDto;
import Blog.infra.controllers.post.dtos.add.AddPostResponseDto;
import Blog.infra.controllers.post.dtos.find.FindPostResponseDto;
import Blog.infra.controllers.post.dtos.list.ListPostResponseDto;
import Blog.infra.controllers.post.dtos.list.PostDto;
import Blog.usecases.post.add.AddPostInputDto;
import Blog.usecases.post.add.AddPostUsecase;
import Blog.usecases.post.find.FindPostInputDto;
import Blog.usecases.post.find.FindPostUsecase;
import Blog.usecases.post.list.ListPostInputDto;
import Blog.usecases.post.list.ListPostOutputDto;
import Blog.usecases.post.list.ListPostsUsecase;
import Blog.utils.PostRepositoryUtils;

@RestController
@RequestMapping("/posts")
public class PostController {

	private PostGateway postGateway;


	public PostController() {
		super();
		this.postGateway = PostRepositoryUtils.getPostGateway() ;
	}

	@PostMapping("/add")
	public AddPostResponseDto add(@RequestBody AddPostRequestDto aRequest) {
		final var input = new AddPostInputDto(aRequest.title(), aRequest.content() , aRequest.author(),
				aRequest.date());


		final var aResult = AddPostUsecase.create(postGateway).execute(input);

		final var aResponse = new AddPostResponseDto(aResult.id(), aResult.title(), aResult.content(),
				aResult.author(), aResult.date());

		return aResponse;
	}

	@GetMapping("/id/{id}")
	public FindPostResponseDto find(@PathVariable String id) {
		final var anInput = new FindPostInputDto(id);

		final var aResult = FindPostUsecase.create(postGateway).execute(anInput);

		final var aResponse = new FindPostResponseDto(aResult.id(),
				aResult.title(),
				aResult.content(),
				aResult.author(),
				aResult.date());

		return aResponse;
	}

	@GetMapping("/list")
	public ListPostResponseDto list() {

		final var anInput = new ListPostInputDto(null);

		final var aResult = ListPostsUsecase.create(postGateway).execute(anInput);

		final List<PostDto> aPosts = new ArrayList<>();

		aResult.posts().forEach(post -> {

			final var aPostDto = new PostDto(post.id(), post.title(), post.content(), post.author(), post.date());

			aPosts.add(aPostDto);
		});

		final var aResponse = new ListPostResponseDto(aPosts);

		return aResponse;
	}

	@GetMapping("/listByUser/{userId}")
	public ResponseEntity<List<PostDto>> listPostsByUser(@PathVariable String userId) {
	    ListPostInputDto inputDto = new ListPostInputDto(userId);
	    ListPostOutputDto outputDto = ListPostsUsecase.create(postGateway).execute(inputDto);
	    List<PostDto> postDtos = outputDto.getPosts();

	    return ResponseEntity.ok(postDtos);
	}
	
}
