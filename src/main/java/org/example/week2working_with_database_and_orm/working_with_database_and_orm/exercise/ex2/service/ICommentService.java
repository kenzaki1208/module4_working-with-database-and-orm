package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.model.Comment;

import java.util.List;

public interface ICommentService {
    void save(Comment comment);
    List<Comment> findToDayComments();
    void likes(long id);
    Comment findById(long id);
}
