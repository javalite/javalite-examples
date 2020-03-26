package hibernate_test;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	public Employee() {

	}
	@Id
	@Column(name = "id")
    @GeneratedValue
	Integer id;

	@Column(name = "first_name")
	String firstName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                '}';
    }
}
