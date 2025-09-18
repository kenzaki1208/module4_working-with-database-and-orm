package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.controller;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.model.Comment;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex2.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/working_with_database_and_orm/exercise/ex2")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("comments", commentService.findToDayComments());
        model.addAttribute("newComment", new Comment());
        return "/working_with_database_and_orm/exercise/ex2/index";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("newComment") Comment newComment) {
        newComment.setDate(LocalDate.now());
        commentService.save(newComment);
        return "redirect:/working_with_database_and_orm/exercise/ex2/";
    }

    @PostMapping("/like/{id}")
    public String likeComment(@PathVariable("id") long id) {
        commentService.likes(id);
        return "redirect:/working_with_database_and_orm/exercise/ex2/";
    }
}
