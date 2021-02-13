package com.example.Assignment.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserBean.findAll", query = "SELECT s FROM UserBean s"),
        @NamedQuery(name = "UserBean.findById", query = "SELECT s FROM UserBean s WHERE s.id = :id"),
        @NamedQuery(name = "UserBean.findByFirstName", query = "SELECT s FROM UserBean s WHERE s.first_name = :first_name"),
        @NamedQuery(name = "UserBean.findByEmail", query = "SELECT s FROM UserBean s WHERE s.email = :email"),})
public class UserBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "first_name")
    private String first_name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_name")
    private String last_name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = true)
    @NotNull
    @Column(name = "updated_at")
    private Timestamp updated_at;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    private Timestamp created_at;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    RoleBean roleBean;

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Id
    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
}

