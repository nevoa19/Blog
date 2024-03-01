package Blog.infra.controllers.user.dtos.add;

import Blog.domain.post.entities.Post;
import java.util.List;

public record AddUserRequestDto(String name,String email,String password,String username, List<Post> posts) {

}
