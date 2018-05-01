package com.harry.guestbook.service;

import com.harry.guestbook.domain.PlayerEntry;
import com.harry.guestbook.domain.PlayerEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerEntryRepository playerEntryRepository;

    public List<PlayerEntry> findAllEntries () {
        return this.playerEntryRepository.findAll ();
    }
    public PlayerEntry findPlayerById(Integer id) {
        return this.playerEntryRepository.findPlayerEntryById(id);
    }
    public List <PlayerEntry> findPlayerEntryByUser (String player) {
        return this.playerEntryRepository.findplayerEntryByUser(player);
    }
    public void deletePlayerById(Integer id) {
        this.playerEntryRepository.delete (id);
    }
    public void save (PlayerEntry newEntry) {
        this.playerEntryRepository.save (newEntry);
    }
    public PlayerEntry findOne (Integer id) {
        return this.playerEntryRepository.findOne (id);
    }
}