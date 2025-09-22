package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.model.CommentJPA;

import java.util.List;

public interface ICommentJPAService {
    void save(CommentJPA comment);
    List<CommentJPA> findToDayComments();
    void likes(long id);
    CommentJPA findById(long id);
}
