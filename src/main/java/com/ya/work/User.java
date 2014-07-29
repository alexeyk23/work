/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ya.work;

import java.applet.Applet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "myseq", sequenceName = "user_id_seq")
    @GeneratedValue(generator = "myseq")
    private  int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "data_reg")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    @Column(name = "dep_id")
    private int dep_id;
    
    @ManyToMany(mappedBy = "users")
    private Set<Application> apps = new HashSet<Application>();

    public Set<Application> getApps() {
        return apps;
    }

    public void setApps(Set<Application> apps) {
        this.apps = apps;
    }
    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }
    @ManyToOne
    @JoinColumn(name = "dep_id",insertable = false,updatable = false)
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User(String name, Date date,int dep_id) {
        this.name = name;
        this.date = date;
        this.dep_id=dep_id;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
