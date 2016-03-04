import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class MongoSessionTest {
	public static AbstractMongoSession mongoSession;
	static {
		Mongo mongo = new MongoClient();
		mongoSession = new MongoSession(MidStu.class, new MongoClient(
				"localhost", 6699).getDatabase("demo"));

	}

	@Test
	public void save() {
		MidStu midStu = new MidStu();
		midStu.setHabit("篮球");
		midStu.setId("wert3254ewyre463757");
		mongoSession.save(midStu);

	}

	@Test
	public void test() {
		MidStu midStu = new MidStu();
		midStu.setHabit("篮球");
		midStu.setId("qwee");
		mongoSession.save(midStu);
		MidStu midStu1 = new MidStu();
		midStu1.setId("qwee");
		midStu1 = (MidStu) mongoSession.find(midStu);
		System.out.println(midStu1.toString());
	}

	@Test
	public void saveMany() {
		MidStu midStu1 = new MidStu();
		midStu1.setHabit("篮球");
		midStu1.setId("1");
		MidStu midStu2 = new MidStu();
		midStu2.setHabit("篮球");
		midStu2.setId("2");
		MidStu midStu3 = new MidStu();
		midStu3.setHabit("篮球");
		midStu3.setId("3");
		List<Object> midStus = new ArrayList<Object>();
		midStus.add(midStu1);
		midStus.add(midStu2);
		midStus.add(midStu3);
		mongoSession.saveMany(midStus);
	}

	@Test
	public void update() {
		MidStu midStu1 = new MidStu();
		midStu1.setHabit("乒乓球");
		// midStu1.setId("dd123dddddcccc");
		// mongoSession.update(midStu1);
		mongoSession.upate(Filters.eq("habit", "排球"), midStu1);
	}

	@Test
	public void updateMany() {
		List<Object> objs = mongoSession.finds();
		for (int i = 0; i < objs.size(); i++) {
			MidStu midStu = (MidStu) objs.get(i);
			midStu.setHabit((i + 1) + "");
		}
		mongoSession.upateMany(objs);
	}

	@Test
	public void updateManyBson() {
		MidStu midStu1 = new MidStu();
		midStu1.setHabit("乒乓球");
		mongoSession.upateMany(Filters.exists("_id"), midStu1);
	}

	@Test
	public void find() {
		System.out.println(mongoSession.query(Filters.exists("habit"),
				Sorts.descending("habit")).toString());
	}
}
