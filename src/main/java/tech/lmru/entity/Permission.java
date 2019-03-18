package tech.lmru.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSIONS")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "permissions_seq")
    @SequenceGenerator(
            name="permissions_seq",
            sequenceName="permissions_sequence",
            allocationSize = 1)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Permission() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Permission that = (Permission) o;

		return getCode().equals(that.getCode());
	}

	@Override
	public int hashCode() {
		return getCode().hashCode();
	}
}
