import java.util.List;

@Table(name = "stu")
public class Stu {
	@Column(name = "_id")
	private String id;
	@Column(name = "name")
	private String name;
	private int age;
	@NotColumn
	private double asd;

	public void setAsd(double asd) {
		this.asd = asd;
	}

	public double getAsd() {
		return asd;
	}

	private MidStu midStu;
	private List<MidStu> col;

	public void setCol(List<MidStu> col) {
		this.col = col;
	}

	public List<MidStu> getCol() {
		return col;
	}

	public void setMidStu(MidStu midStu) {
		this.midStu = midStu;
	}

	public MidStu getMidStu() {
		return midStu;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", age=" + age
				+ ", midStu=" + midStu + ", col=" + col + "]";
	}

}
