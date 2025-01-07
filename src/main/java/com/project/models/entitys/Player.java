package com.project.models.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.models.dtos.PlayerDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
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
    @ManyToMany
    @JoinTable(
            name = "players_tutores",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "tutor_id")
    )
    private List<Tutor> tutores;

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
        this.setEmail(player.getMail());
        this.setUserName(player.getUserName());
        this.setBirthday(player.getBirthday());
        this.setAge(player.getAge());
        this.setPhone(player.getPhone());
        this.setPassword(player.getPassword());
        this.setCity(player.getCity() != null && player.getCity().getId() != null ? new City(player.getCity().getId()) : null);
    }
}
