package Blog.domain.shared.polices;

public interface Policy<T> {
	void validate(T entity);
}
