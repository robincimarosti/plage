package fr.humanbooster.fx.plage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.plage.business.File;
import fr.humanbooster.fx.plage.dao.FileDao;
import fr.humanbooster.fx.plage.service.FileService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {

	private FileDao fileDao;
	
	@Override
	public List<File> recupererFiles() {
		return fileDao.findAll();
	}

}
