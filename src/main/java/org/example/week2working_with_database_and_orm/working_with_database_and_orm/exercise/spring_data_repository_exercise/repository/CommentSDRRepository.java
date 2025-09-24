package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.repository;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.model.CommentSDR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommentSDRRepository extends JpaRepository<CommentSDR, Long> {
    List<CommentSDR> findByDate(LocalDate date);
    Page<CommentSDR> findByDate(LocalDate date, Pageable pageable);
}
