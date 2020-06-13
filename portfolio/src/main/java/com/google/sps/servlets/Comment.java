/**
 * Represents a user submitted comment.
 */
public class Comment {

	/**
	 *  The unique id of this comment.
	 */
	private Long id
	/**
	 * The text of this comment.
	 */
	private String text;

	/**
	 *  The instance when this commented was created.
	 */
	private Long timestamp;

	public Comment(Long id, String text, Long timestamp) {
		this.id = id;
		this.text = text;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public Comment setId(Long id) {
		this.id = id;
		return this;
	}

	public Comment setText(String text) {
		this.text = text;
		return this;
	}

	public Comment setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
		return this;
	}
}