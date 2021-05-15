package com.cruddish.service;

import java.util.List;
import java.util.Map;

import com.cruddish.interfaces.ProjectInterface;
import com.cruddish.modelo.Project;
import com.cruddish.modeloDAO.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements ProjectInterface {

	@Autowired
	ProjectDAO dao;
	
	@Override
	public List<Map<String, Object>> listar() {		
		return dao.listar();
	}

	@Override
	public List<Map<String, Object>> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Project p) {
		return dao.add(p);
	}

	@Override
	public int edit(Project p) {
		// TODO Auto-generated method stub
		return dao.edit(p);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}



}
