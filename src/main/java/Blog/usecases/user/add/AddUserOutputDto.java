package Blog.usecases.user.add;

import Blog.domain.post.entities.Post;
import java.util.List;

public record AddUserOutputDto(String id,String name,String email,String password,String username, List<Post> posts) {

}
