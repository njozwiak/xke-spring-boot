package com.xebia.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Client {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @NotNull
    @XmlElement
    private Long id;

    @NotNull
    @Size(max = 100)
    @XmlElement
    private String name;

    public Client() {

    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
