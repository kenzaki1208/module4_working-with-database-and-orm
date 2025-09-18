package org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex1.controller;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex1.model.Song;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex1.service.HibernateSongService;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.exercise.ex1.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/working_with_database_and_orm/exercise/ex1/songs")
public class SongController {
    private final SongService songService = new HibernateSongService();

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "/working_with_database_and_orm/exercise/ex1/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "/working_with_database_and_orm/exercise/ex1/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Song song, @RequestParam("file") MultipartFile file) throws IOException {
        String uploadDir = "C:\\Users\\duytr\\Downloads\\upload";
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdir();
        }
        String filePath = uploadDir + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        song.setFilePath(file.getOriginalFilename());
        songService.save(song);
        return "redirect:/working_with_database_and_orm/exercise/ex1/songs";
    }

    @GetMapping("/play/{id}")
    public String play(@PathVariable("id") long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/working_with_database_and_orm/exercise/ex1/play";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        songService.delete(id);
        return "redirect:/working_with_database_and_orm/exercise/ex1/songs";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/working_with_database_and_orm/exercise/ex1/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Song song, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String uploadDir = "C:\\Users\\duytr\\Downloads\\upload";
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) uploadFolder.mkdirs();

            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            song.setFilePath(file.getOriginalFilename());
        } else {
            Song oldSong = songService.findById(song.getId());
            song.setFilePath(oldSong.getFilePath());
        }
        songService.update(song);
        return "redirect:/working_with_database_and_orm/exercise/ex1/songs";
    }

}
