package com.project.models.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.models.dtos.PlayerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "players")
public class Player extends User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "category_id") // Columna que actúa como clave foráne
    private Category category;
    @ManyToOne()
    @JoinColumn(name = "city_id") // Esta es la columna en la base de datos que almacena la clave foránea
    private City city;
    private String age;
    private String birthday;
    @ManyToMany(mappedBy = "players")
    @JsonBackReference
    private List<Event> events;


    public Player() {

    }

    public Player(Long id, Category category, String age, City city, String birthday, List<Event> events) {
        super();
        this.id = id;
        this.category = category;
        this.age = age;
        this.city = city;
        this.birthday = birthday;
    }

    public Player(PlayerDTO player) {

        if (player.getCategory() != null && player.getCategory().getId() != null) {
            Category categoria = new Category(player.getCategory().getId());
            this.setCategory(categoria);
        }
        this.setId(player.getId());
        this.setName(player.getName());
        this.setLastName(player.getLastName());
        this.setMail(player.getMail());
        this.setUserName(player.getUserName());
        this.setBirthday(player.getBirthday());
        this.setAge(player.getAge());
        this.setPhone(player.getPhone());
        this.setPassword(player.getPassword());
        this.setCity(player.getCity() != null && player.getCity().getId() != null ? new City(player.getCity().getId()) : null);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
