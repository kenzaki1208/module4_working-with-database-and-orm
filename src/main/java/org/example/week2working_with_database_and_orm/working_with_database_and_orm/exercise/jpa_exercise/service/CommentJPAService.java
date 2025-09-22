package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.model.CommentJPA;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.repository.CommentJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentJPAService implements ICommentJPAService {
    @Autowired
    private CommentJPARepository commentRepository;

    @Override
    public void save(CommentJPA comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<CommentJPA> findToDayComments() {
        return commentRepository.findByDate(LocalDate.now());
    }

    @Override
    public void likes(long id) {
        CommentJPA commentJPA = commentRepository.findById(id).orElse(null);
        if (commentJPA != null) {
            commentJPA.setLikes(commentJPA.getLikes() + 1);
            commentRepository.save(commentJPA);
        }
    }

    @Override
    public CommentJPA findById(long id) {
        return commentRepository.findById(id).orElse(null);
    }
}
