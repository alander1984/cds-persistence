package tech.lmru.entity.transport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "driver_seq")
    @SequenceGenerator(
            name="driver_seq",
            sequenceName="driver_sequence",
            allocationSize = 1)
    private long id;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "patronymic")
    private String patronymic;
    
    @Column(name = "birthday")
    private LocalDate birthday;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "password")
    private String password;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "DRIVER_TRANSPORT",
        joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "transport_id", referencedColumnName = "id"))
    private Set<Transport> transports = new HashSet<>();

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
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
	 * @return the patronymic
	 */
	public String getPatronymic() {
		return patronymic;
	}

	/**
	 * @param patronymic the patronymic to set
	 */
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the transports
	 */
	public Set<Transport> getTransports() {
		return transports;
	}

	/**
	 * @param transports the transports to set
	 */
	public void setTransports(Set<Transport> transports) {
		this.transports = transports;
	}
    
    
	
}