package Studio7;

import java.util.Date;

public class Post {
	private String body, title;
	private User author;
	private Date created, modified;
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		modified = new Date();
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		modified = new Date();
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public Post(String body, String title, User author) {
		this.body = body;
		this.title = title;
		this.author = author;
		final Date created = new Date();
	}
}
