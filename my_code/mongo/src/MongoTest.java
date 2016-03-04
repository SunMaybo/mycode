import java.lang.reflect.InvocationTargetException;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoTest {

	/**
	 * @param args
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchFieldException {
		MongoClient client = new MongoClient("localhost", 6699);
		MongoDatabase db = client.getDatabase("task");
		MongoCollection<Document> collection = db.getCollection("midStu");
		Document document = new Document();
		Document document1 = new Document();
		document1.append("_id", "qwwrrw2424").append("habit", "mongo");
		document.append("_id", "ew12rty456yuuyu").append("name", "mongo")
				.append("age", 23).append("midStu", document1)
				.append("key", "ffg").append("col", collection);
		Document document2 = collection.find(Filters.eq("name", "mongo"))
				.first();
		System.out.println(BsonUtil
				.toBson(BsonUtil.toBean(document, Stu.class)).toJson());
		// System.out.println(document.toJson());
		// System.out.println(BsonUtil.toBean(document, Stu.class));
		// collection.insertOne(document1);
	}

}
