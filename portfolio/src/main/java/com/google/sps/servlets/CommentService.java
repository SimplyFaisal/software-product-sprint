
/**
 * Service for creating and fetching {@link Comment}s.
 */
public class CommentService {
	private DataService dataService;

	public CommentService(DataService dataService) {
		this.dataService = dataService;
	}
	public Comment create(Comment comment) {
		 Entity entity = new Entity("Comment");
	    taskEntity.setProperty("text", comment.getText());
	    entity.setProperty("timestamp", comment.getTimestamp());
	    Key key = dataService.put(entity);
	    comment.setId(key.getId());
	    return comment;
	}

	public Comment get(Long id) {
		Key key = datastore.newKeyFactory()
		    .setKind("Comment")
		    .newKey(id.toString());
		Entity entity = dataService.get(key);
		return new Comment()
			.setId(id)
			.setText((String) entity.getProperty("comment"))
			.setTimeStamp((Long) entity.getProperty("timestamp"));
	}

	public Comment update(Comment comment) {
		
	}

	public List<Comment> list(Query query) {

	}
}