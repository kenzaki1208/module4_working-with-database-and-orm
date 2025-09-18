package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.service;

import jakarta.persistence.EntityManager;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.model.Comment;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.repository.CommentRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findToDayComments() {
        return commentRepository.findToDayComments();
    }

    @Override
    public void likes(long id) {
        commentRepository.like(id);
    }

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id);
    }
}
