import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Demo demo1 = new Demo(1, "Giri");
		Demo demo2 = new Demo(2, "Chai");

		System.out.println(demo1.equals(demo2));
		
		
		Set<Demo> set = new TreeSet<>();
		
		set.add(demo1);
		set.add(demo2);
	}

}

class Demo implements Comparable<Demo>{

	private int id;
	private String name;

	public Demo() {
		super();
	}

	public Demo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		System.out.println("---------------hashcode---------------------");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("---------------equals-----------------");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demo other = (Demo) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Demo arg0) {
		return 0;
	}
	
	
	

}
