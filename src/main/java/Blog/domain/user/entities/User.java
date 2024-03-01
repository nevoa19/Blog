package Blog.domain.user.entities;

import Blog.domain.post.entities.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Blog.domain.shared.entities.Entity;
import Blog.domain.shared.exceptions.DomainException;
import jakarta.validation.constraints.Email;

public class User extends Entity {
	
	private String name;
	@Email
	private String email;
	private String password;
	private String username;
	private List<Post> posts;

	public User(String id, String name, @Email String email, String password, String username, final List<Post> posts) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
		this.username = username;
		this.posts = posts;
		this.validate();
	}

	public static User create(String name, @Email String email, String password, String username) {
		return new User(UUID.randomUUID().toString(), name, email, password, username, new ArrayList<Post>());
	}

	public static User with(String id, String name, @Email String email, String password, String username,
			final List<Post> posts) {
		return new User(id, name, email, password, username, posts);
	}

	
	protected void validate() {
		if (this.getId() == null) {
			throw new DomainException("User id is required");
		}
		if (this.name == null || this.name.isEmpty()) {
			throw new DomainException("Name is required");
		}
		if (this.email == null || this.email.isEmpty()) {
			throw new DomainException("Email is required");
		}
		if (this.password == null || this.password.isEmpty()) {
			throw new DomainException("Password is required");
		}
		if (this.username == null || this.username.isEmpty()) {
			throw new DomainException("Username is required");
		}
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(final Post post) {
		this.posts.add(post);
	}

	

}
