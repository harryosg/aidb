package com.harry.guestbook.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerEntryRepository extends CrudRepository<PlayerEntry, Integer> {
    @Override
    List<PlayerEntry>
    findAll();
    PlayerEntry findPlayerEntryById (Integer id);
    List<PlayerEntry> findplayerEntryByUser (String user);
}
