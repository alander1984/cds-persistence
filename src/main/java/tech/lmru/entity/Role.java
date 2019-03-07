package tech.lmru.entity;

import javax.persistence.*;

@Entity
@Table(name="PERMISSIONS")
class Role {
    
    @Column(name = "code444")
    private String code;
    
    @Column(name = "name")
    private String name;
    
}