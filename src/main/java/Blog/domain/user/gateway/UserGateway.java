package Blog.domain.user.gateway;

import java.util.List;

import Blog.domain.user.entities.User;

public interface UserGateway {
	void save(final User user);

	User find(final String anID);

	List<User> list();
}
