package Blog.usecases.user.add;

import Blog.usecases.user.add.AddUserOutputDto;

import Blog.domain.user.entities.User;
import Blog.domain.user.gateway.UserGateway;
import Blog.usecases.Usecase;

public class AddUserUsecase implements Usecase<AddUserInputDto,AddUserOutputDto> {
	private UserGateway userGateway;
	
	private AddUserUsecase(UserGateway userGateway) {
		this.userGateway = userGateway;
	}
	
	public static AddUserUsecase create(final UserGateway aGateway) {
		return new AddUserUsecase(aGateway);
	}
	
	@Override
	public AddUserOutputDto execute(final AddUserInputDto input) {
		final var aUser = User.create(input.name(), input.email(),input.password(),input.username());
		userGateway.save(aUser);

	 return new AddUserOutputDto(aUser.getId(),aUser.getName(), aUser.getEmail(), aUser.getPassword(),aUser.getUsername(),aUser.getPosts()); 
	}
}
