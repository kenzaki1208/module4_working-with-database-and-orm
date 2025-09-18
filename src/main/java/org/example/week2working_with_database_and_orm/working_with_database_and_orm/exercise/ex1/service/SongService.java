package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex1.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex1.model.Song;

import java.util.List;

public interface SongService {
    void save(Song song);
    List<Song> findAll();
    void update(Song song);
    void delete(Long id);
    Song findById(long id);
}
