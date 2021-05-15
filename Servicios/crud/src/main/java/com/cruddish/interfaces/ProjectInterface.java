package com.cruddish.interfaces;

import java.util.List;
import java.util.Map;

import com.cruddish.modelo.Project;

public interface ProjectInterface {
	public List<Map<String, Object>>listar();
	public List<Map<String, Object>>listarId(int id);
	public int add(Project p);
	public int edit(Project p);
	public int delete(int id);

}
