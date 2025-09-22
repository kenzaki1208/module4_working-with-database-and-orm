package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.controller;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.model.CommentJPA;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.jpa_exercise.service.ICommentJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/working_with_database_and_orm/exercise/jpa_exercise")
public class CommentJPAController {
    @Autowired
    private ICommentJPAService commentService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("comments", commentService.findToDayComments());
        model.addAttribute("newComment", new CommentJPA());
        return "/working_with_database_and_orm/exercise/jpa_exercise/index";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("newComment") CommentJPA newComment) {
        newComment.setDate(LocalDate.now());
        commentService.save(newComment);
        return "redirect:/working_with_database_and_orm/exercise/jpa_exercise";
    }

    @PostMapping("/like/{id}")
    public String likeComment(@PathVariable("id") long id) {
        commentService.likes(id);
        return "redirect:/working_with_database_and_orm/exercise/jpa_exercise";
    }
}
