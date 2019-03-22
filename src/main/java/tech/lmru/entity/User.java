package tech.lmru.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "USERS")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_seq")
    @SequenceGenerator(
            name="users_seq",
            sequenceName="users_sequence",
            allocationSize = 1)
    private int id;

    @Column(name = "CODE")
    private String code;

    @NonNull
    @Column(name = "NAME")
    private String name;

    @NonNull
    @Column(name = "PASSWORD")
    private String password;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_ROLES",
        joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
    private Set<Role> roles;

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
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return id == user.id &&
				Objects.equals(code, user.code) &&
				name.equals(user.name) &&
				password.equals(user.password) &&
				Objects.equals(roles, user.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, password, roles);
	}
}