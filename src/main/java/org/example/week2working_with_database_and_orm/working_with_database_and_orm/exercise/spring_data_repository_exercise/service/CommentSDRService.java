package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.model.CommentSDR;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.repository.CommentSDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentSDRService implements ICommentSDRService {
    @Autowired
    private CommentSDRRepository commentRepository;

    @Override
    public void save(CommentSDR comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<CommentSDR> findToDayComments() {
        return commentRepository.findByDate(LocalDate.now());
    }

    @Override
    public void likes(long id) {
        CommentSDR commentJPA = commentRepository.findById(id).orElse(null);
        if (commentJPA != null) {
            commentJPA.setLikes(commentJPA.getLikes() + 1);
            commentRepository.save(commentJPA);
        }
    }

    @Override
    public CommentSDR findById(long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<CommentSDR> findToDayComments(Pageable pageable) {
        return commentRepository.findByDate(LocalDate.now(), pageable);
    }
}
