package com.erbaris.director.service;

import com.erbaris.director.dto.DirectorSaveDTO;
import com.erbaris.director.dto.DirectorsDTO;
import com.erbaris.director.mapper.IDirectorMapper;
import com.erbaris.movie.data.dal.MovieServiceHelper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private final MovieServiceHelper m_movieServiceHelper;
    private final IDirectorMapper m_iDirectorMapper;

    public DirectorService(MovieServiceHelper movieServiceHelper, IDirectorMapper iDirectorMapper) {
        m_movieServiceHelper = movieServiceHelper;
        m_iDirectorMapper = iDirectorMapper;
    }
    public DirectorsDTO findDirectorsByMovieId(long id)
    {
        return m_iDirectorMapper.toDirectorsDTO(CollectionUtil.toList(m_movieServiceHelper.findDirectorByMovieId(id), m_iDirectorMapper::toDirectorDTO));
    }
    public DirectorSaveDTO saveDirector(DirectorSaveDTO directorSaveDTO)
    {
        m_movieServiceHelper.saveDirector(m_iDirectorMapper.toDirectorSave(directorSaveDTO));
        return directorSaveDTO;
    }
}
