package tech.lmru.entity;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="ROLES")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roles_seq")
    @SequenceGenerator(
            name="roles_seq",
            sequenceName="roles_sequence",
            allocationSize = 1)
    private int id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "ROLES_PERMISSIONS",
        joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    private List<Permission> permissions = new ArrayList<>();
    

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
	
	/**
	 * @return the permissions
	 */
	public List<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


	public Role() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Role role = (Role) o;
		return id == role.id &&
				Objects.equals(code, role.code) &&
				name.equals(role.name) &&
				Objects.equals(permissions, role.permissions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, permissions);
	}
}