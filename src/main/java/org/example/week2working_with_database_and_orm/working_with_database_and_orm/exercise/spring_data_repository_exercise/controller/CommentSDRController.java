package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.controller;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.model.CommentSDR;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.spring_data_repository_exercise.service.ICommentSDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/working_with_database_and_orm/exercise/spring_data_repository_exercise")
public class CommentSDRController {
    @Autowired
    private ICommentSDRService commentService;

    @GetMapping("/page")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("id").descending());
        Page<CommentSDR> comments = commentService.findToDayComments(pageable);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new CommentSDR());
        model.addAttribute("currentPage", page);
        return "/working_with_database_and_orm/exercise/spring_data_repository_exercise/index";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("newComment") CommentSDR newComment) {
        newComment.setDate(LocalDate.now());
        commentService.save(newComment);
        return "redirect:/working_with_database_and_orm/exercise/spring_data_repository_exercise/page";
    }

    @PostMapping("/like/{id}")
    public String likeComment(@PathVariable("id") long id) {
        commentService.likes(id);
        return "redirect:/working_with_database_and_orm/exercise/spring_data_repository_exercise/page";
    }
}
