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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "apps")
public class Application 
{
    @Id
    @SequenceGenerator(name ="myseq",sequenceName = "app_id_seq")
    @GeneratedValue(generator = "myseq")
    @Column(name="app_id")
    private int app_id;
    @Column(name = "app_name")
    private String appName;
    @ManyToMany
    @JoinTable(name = "apps_user",joinColumns = {@JoinColumn(name = "app_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users = new HashSet<User>();

    public Application(String appName) {
        this.appName = appName;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Application() {
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    
}
