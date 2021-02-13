package com.example.Assignment.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "RoleBean.findAll", query = "SELECT s FROM RoleBean s"),})
public class RoleBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "slug")
    private String slug;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }
}

