package com.erbaris.director.mapper;

import com.erbaris.director.dto.DirectorDTO;
import com.erbaris.director.dto.DirectorSaveDTO;
import com.erbaris.director.dto.DirectorsDTO;
import com.erbaris.movie.data.entity.Director;
import com.erbaris.movie.data.entity.DirectorSave;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(implementationName = "DirectorImpl", componentModel = "spring")
public interface IDirectorMapper {
    DirectorDTO toDirectorDTO(Director director);
    DirectorSave toDirectorSave(DirectorSaveDTO directorSaveDTO);
    DirectorSaveDTO toDirectorSaveDTO(DirectorSave directorSave);
    default DirectorsDTO toDirectorsDTO(List<DirectorDTO> directors)
    {
        var dto = new DirectorsDTO();
        dto.directors = directors;
        return dto;
    }
}
