package Blog.domain.post.gateway;

import java.util.List;

import Blog.domain.post.entities.Post;

public interface PostGateway {
	void save(Post post);

	Post find(String anId);
	
	List<Post> allPosts(); 

    List<Post> postsByUserId(String userId);
}
