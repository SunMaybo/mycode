@Table(name = "midStu")
public class MidStu {
	@Column(name = "_id")
	private String id;
	@Column(name = "habit")
	private String habit;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public String getHabit() {
		return habit;
	}

	@Override
	public String toString() {
		return "MidStu [id=" + id + ", habit=" + habit + "]";
	}

}
