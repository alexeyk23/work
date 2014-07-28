/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ya.work;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name="department")
public class Department 
{
    @Id
    @SequenceGenerator(name ="myseq",sequenceName = "dep_id_seq")
    @GeneratedValue(generator = "myseq")
    @Column(name = "dep_id")
    private int dep_id;
    @Column(name ="dep_name")
    private String dep_name;
    
    @OneToMany(mappedBy = "department")
    private Set<User> users = new HashSet<User>();

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Department() {
    }

    public Department(String dep_name) {
        this.dep_name = dep_name;
    }
    
    
}
