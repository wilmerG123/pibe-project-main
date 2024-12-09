package com.project.controller;


import com.project.Services.Player.PlayerServiceImpl;
import com.project.models.dtos.PlayerDTO;
import com.project.models.entitys.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerServiceImpl service;

    @PostMapping("/create-player")
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO player){
        Player playerEntity = new Player(player);
        Player savedPlayer = service.save(playerEntity);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/edit-player/{id}")
    public ResponseEntity<Player> editPlayer(@PathVariable Long id, @RequestBody PlayerDTO player){
        Player playerEntity = new Player(player);
        Player editedPlayer = service.editPlayer(playerEntity,id);
        return new ResponseEntity<>(editedPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-player")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> allPlayers = service.getPlayers();
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }

    @GetMapping("/get-players-category/{id}")
    public ResponseEntity<List<Player>> getPlayersByCategoryId(@PathVariable Long id) {
        List<Player> players =service.getPlayersByCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }

    @GetMapping("/get-players-events-by-id/{ids}")
    public ResponseEntity<List<Player>> getPlayerByCategoryId(@PathVariable List<Long> ids){
        List<Player> playersOnEvent =service.getPlayerOnEventByIds(ids);
        return new ResponseEntity<List<Player>>(playersOnEvent, HttpStatus.OK);    }


    @GetMapping("/get-players-name/{name}")
    public ResponseEntity<List<Player>> getPlayersByCategoryId(@PathVariable String name) {
        List<Player> players =service.getPlayerByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }
    @DeleteMapping("/delete-player/{id}")
    public void deletePlayerById(@PathVariable Long id) {
        service.deletePlayer(id);
    }
}
