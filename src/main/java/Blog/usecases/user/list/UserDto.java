package Blog.usecases.user.list;

import java.util.List;

public record UserDto(
		String id,
		String name,
		String email,
		String password,
		String username,
		List<PostDto> posts)  {
	

}
