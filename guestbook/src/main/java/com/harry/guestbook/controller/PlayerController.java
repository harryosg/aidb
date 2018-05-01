package com.harry.guestbook.controller;

import com.harry.guestbook.domain.PlayerEntry;
import com.harry.guestbook.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/api")
@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping ("/comments")
    public List <PlayerEntry> getAllComments () {
        return playerService.findAllEntries ();
    }

    @GetMapping ("/comment/{id}")
    public PlayerEntry findPlayerById (@PathVariable("id") Integer id) {
        return this.playerService.findPlayerById( id);
    }
    @GetMapping ("/player/{player}")
    public List <PlayerEntry> findPlayerByUser (@PathVariable ("player") String player) {
        return this.playerService.findPlayerEntryByUser(player);
    }
    @DeleteMapping("/comment/{id}")
    public void deletePlayerById(@PathVariable ("id") Integer id) {
        this.playerService.deletePlayerById(id);
    }
    @PostMapping ("/add")
    public void addComment (@RequestBody PlayerEntry playerEntry) {
        this.playerService.save (playerEntry);
    }
    @PostMapping ("/update")
    public void updateComment (@RequestBody PlayerEntry playerEntry) {
        this.playerService.save (playerEntry);
    }
}

