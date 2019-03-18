package tech.lmru.entity;

import java.util.List;

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
    

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "ROLES_PERMISSIONS",
        joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    private List<Permission> permissions;
    

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
}