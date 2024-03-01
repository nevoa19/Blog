package Blog.infra.repositories.Blog.memory;

import java.util.HashMap;
import java.util.List;

import Blog.domain.user.entities.User;
import Blog.domain.user.gateway.UserGateway;

public class UserRepositoryMemory implements UserGateway {

	private HashMap<String, User> users;

	private UserRepositoryMemory() {
		this.users = new HashMap<>();
	}

	public static UserRepositoryMemory create() {
		return new UserRepositoryMemory();
	}

	@Override
	public void save(final User aCatalog) {
		this.users.put(aCatalog.getId(), aCatalog);
	}

	@Override
	public User find(String anId) {
		return this.users.get(anId);
	}

	@Override
	public List<User> list() {
		return List.copyOf(this.users.values());
	}

}
