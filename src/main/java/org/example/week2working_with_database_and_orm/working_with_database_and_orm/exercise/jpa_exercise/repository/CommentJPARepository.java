package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.repository;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.model.CommentJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentJPARepository extends JpaRepository<CommentJPA, Long> {
    List<CommentJPA> findByDate(LocalDate date);
}
