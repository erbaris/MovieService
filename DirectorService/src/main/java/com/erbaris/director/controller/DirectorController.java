package com.erbaris.director.controller;

import com.erbaris.director.dto.DirectorSaveDTO;
import com.erbaris.director.dto.DirectorsDTO;
import com.erbaris.director.service.DirectorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/directors")
public class DirectorController {
    private final DirectorService m_directorService;

    public DirectorController(DirectorService directorService) {
        m_directorService = directorService;
    }
    @GetMapping("director/find/movie")
    public DirectorsDTO findDirectorsByMovieId(@RequestParam("id") long id)
    {
        return m_directorService.findDirectorsByMovieId(id);
    }
    @PostMapping("directors/save")
    public DirectorSaveDTO saveDirector(@RequestBody DirectorSaveDTO directorSaveDTO)
    {
        return m_directorService.saveDirector(directorSaveDTO);
    }
}
