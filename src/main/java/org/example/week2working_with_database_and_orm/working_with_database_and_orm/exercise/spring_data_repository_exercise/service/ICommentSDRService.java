package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.model.CommentSDR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentSDRService {
    void save(CommentSDR comment);
    List<CommentSDR> findToDayComments();
    void likes(long id);
    CommentSDR findById(long id);
    Page<CommentSDR> findToDayComments(Pageable pageable);
}
