package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin Dolinsky
 */
@Entity
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "person_name")
	private String name;

	@Column(name = "person_birth_number")
	private String birthNumber;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Hobby> hobbyList;

	public Person() {

	}

	public Person(String name, String birthNumber) {
		this.name = name;
		this.birthNumber = birthNumber;
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

	public String getBirthNumber() {
		return birthNumber;
	}

	public void setBirthNumber(String birthNumber) {
		this.birthNumber = birthNumber;
	}

	public List<Hobby> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<Hobby> hobbyList) {
		this.hobbyList = hobbyList;
	}

	public void add(Hobby hobby) {
		if (hobbyList == null) {
			hobbyList = new ArrayList<>();
		}

		hobbyList.add(hobby);
		hobby.setPerson(this);
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthNumber='" + birthNumber + '\'' +
				'}';
	}
}
