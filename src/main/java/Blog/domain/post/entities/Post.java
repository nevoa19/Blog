package Blog.domain.post.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import Blog.domain.shared.aggregatte.AggregatteRoot;
import Blog.domain.shared.entities.Entity;
import Blog.domain.shared.exceptions.DomainException;
import Blog.domain.user.entities.User;

public class Post extends Entity implements AggregatteRoot {
	private static final int MAX_TITLE_LENGTH = 50;
    private static final int MAX_CONTENT_LENGTH = 250;
    static List<User> users;
    
	private String title;
	private String content;
	private String author;
	private Date date;
	

	private Post(String id, String title, String content, String author, Date date) {
		super(id);
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.validate();
	}

	public static Post create(String title, String content, String author) {
        Date date = new Date();
       
        return new Post(UUID.randomUUID().toString(), title, content, author, date);
    }

	public static Post with(String id, String title, String content, String author, Date date) {
		return new Post(id, title, content, author, date);
	}

	
	
	protected void validate() {
		if (this.getId() == null) {
			throw new DomainException("Post id is required");
		}
		if (this.title == null || this.title.isEmpty()) {
			throw new DomainException("Post description is required");
		}
		if (this.title.length() > MAX_TITLE_LENGTH) {
            throw new DomainException("Post title must be maximum " + MAX_TITLE_LENGTH + " characters");
        }
		if (this.content == null || this.content.isEmpty()) {
			throw new DomainException("Content can't be Empty");
		}
		if (this.content.length() > MAX_CONTENT_LENGTH) {
            throw new DomainException("Post content must be maximum " + MAX_CONTENT_LENGTH + " characters");
        }
		if (this.author == null) {
			throw new DomainException("author can't be Empty");
		}
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public Date getDate() {
		return date;
	}

}
