package Blog.infra.controllers.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Blog.domain.post.gateway.PostGateway;
import Blog.domain.user.gateway.UserGateway;
import Blog.infra.controllers.user.dtos.add.AddUserRequestDto;
import Blog.infra.controllers.user.dtos.add.AddUserResponseDto;
import Blog.infra.controllers.user.dtos.list.ListUserResponseDto;
import Blog.infra.controllers.user.dtos.list.PostDto;
import Blog.infra.controllers.user.dtos.list.UserDto;
import Blog.infra.repositories.Blog.memory.UserRepositoryMemory;
import Blog.usecases.user.add.AddUserInputDto;
import Blog.usecases.user.add.AddUserUsecase;
import Blog.usecases.user.list.ListUserInputDto;
import Blog.usecases.user.list.ListUserUsecase;
import Blog.utils.PostRepositoryUtils;


@RestController
@RequestMapping("/users")
public class UserController {

	private UserGateway userGateway;
	private PostGateway postGateway;

	public UserController() {
		super();
		this.userGateway = UserRepositoryMemory.create();
		this.postGateway = PostRepositoryUtils.getPostGateway();
	}

	@PostMapping("/add")
	public AddUserResponseDto addUser(@RequestBody AddUserRequestDto request) {
		final var anInput = new AddUserInputDto(request.name(), request.email(), request.password(), request.username(),request.posts());

		final var aResult = AddUserUsecase.create(userGateway).execute(anInput);

		final var aResponse = new AddUserResponseDto(aResult.id(), aResult.name(), aResult.email(),aResult.password() ,aResult.username());

		return aResponse;
	}

	@GetMapping("/list")
	public ListUserResponseDto listUsers() {

		final var anInput = new ListUserInputDto();

		final var aResult = ListUserUsecase.create(userGateway).execute(anInput);

		final List<UserDto> aUsers = new ArrayList<>();

		aResult.users().forEach(user -> {
			final var aPosts = new ArrayList<PostDto>();
			user.posts().forEach(post -> {
				final var aPostDto = new PostDto(post.id(), post.title());

				aPosts.add(aPostDto);
			});

			final var aUserDto = new UserDto(user.id(), user.name(),aPosts);

			aUsers.add(aUserDto);
		});

		final var aResponse = new ListUserResponseDto(aUsers);

		return aResponse;
	}


}
