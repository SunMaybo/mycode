import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoTemplate {
	private MongoClient mongo;
	private String database;

	public MongoTemplate(MongoClient mongo, String database) {
		this.mongo = mongo;
		this.database = database;
	}

	public MongoSession session(Class<?> clazz) {
		return new MongoSession(clazz,
				(MongoDatabase) mongo.getDatabase(database));
	}
}
