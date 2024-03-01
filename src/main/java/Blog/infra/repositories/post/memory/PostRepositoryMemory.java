package Blog.infra.repositories.post.memory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Blog.domain.post.entities.Post;
import Blog.domain.post.gateway.PostGateway;

public class PostRepositoryMemory implements PostGateway {

	private HashMap<String, Post> posts;

	private PostRepositoryMemory() {
		this.posts = new HashMap<>();
	}

	public static PostRepositoryMemory create() {
		return new PostRepositoryMemory();
	}

	@Override
	public void save(final Post post) {
		this.posts.put(post.getId(), post);
	}

	@Override
    public List<Post> allPosts() {
        return this.posts.values().stream().collect(Collectors.toList());
    }

	@Override
	public Post find(String anId) {
		return this.posts.get(anId);
	}
	
	@Override
    public List<Post> postsByUserId(String userId) {
        return this.posts.values().stream()
                   .filter(post -> userId.equals(post.getId()))
                   .collect(Collectors.toList());
    }
}
