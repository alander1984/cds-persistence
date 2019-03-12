package tech.lmru.entity.route;

import javax.persistence.*;

@Entity
@Table(name="ROUTES")
public class Route {
    
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

    
    
}
