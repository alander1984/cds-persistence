package tech.lmru.entity.route;

import javax.persistence.*;

@Entity
@Table(name="ROUTES")
public class Route {
    
    @Id
    private int id;
    
    @Column(name = "code")
    private String code;

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

    
    
}
