package tech.lmru.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ROLES")
class Role {
    
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
    
    @ManyToMany (mappedBy = "roles")
    private Set<User> users;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ROLES_PERMISSIONS",
        joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    private Set<Permission> permissions;
    

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
	 * @return the users
	 */
	public Set<User> getUsers (){
	    return users;
	}
	
	/**
	 * @param set of users
	 */
	public void setUsers(Set<User> users) {
	    this.users = users;
	}
	

	/**
	 * @return the permissions
	 */
	public Set<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}


    
    
}