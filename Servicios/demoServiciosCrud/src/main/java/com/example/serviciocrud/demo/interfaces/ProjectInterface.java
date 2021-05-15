package com.example.serviciocrud.demo.interfaces;


import com.example.serviciocrud.demo.modelo.Project;

import java.util.List;
import java.util.Map;

public interface ProjectInterface {
    public List<Map<String, Object>>listar();
    public List<Map<String, Object>>listarId(int id);
    public int add(Project p);
    public int edit(Project p);
    public int delete(int id);

}
