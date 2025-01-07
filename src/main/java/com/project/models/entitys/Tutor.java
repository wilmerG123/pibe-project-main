package com.project.models.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tutor")
@Data
@NoArgsConstructor
public class Tutor extends User{

    private Long id;

    @ManyToMany(mappedBy = "tutores")
    private List<Player> players;

}
