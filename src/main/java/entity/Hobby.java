package entity;

import javax.persistence.*;

/**
 * @author Martin Dolinsky
 */
@Entity
@Table(name = "Hobby")
public class Hobby {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "hobby_name")
	private String name;

	@Column(name = "hobby_type")
	private String type;

	@JoinColumn(name = "person_id")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Person person;

	public Hobby() {
	}

	public Hobby(String name, String type) {
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Hobby{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
