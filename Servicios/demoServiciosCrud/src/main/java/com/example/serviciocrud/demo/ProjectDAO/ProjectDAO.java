package com.example.serviciocrud.demo.ProjectDAO;


import java.util.List;
import java.util.Map;

import com.example.serviciocrud.demo.interfaces.ProjectInterface;
import com.example.serviciocrud.demo.modelo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProjectDAO implements ProjectInterface {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Map<String, Object>> listar() {
        List<Map<String, Object>> list = template.queryForList("select * from projectstb");
        return list;
    }

    @Override
    public List<Map<String, Object>> listarId(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int add(Project p) {
        String sql = "insert into projectstb(nameproject,projectmanager, description, developers)values(?,?,?,?)";
        return template.update(sql, p.getNameproject(), p.getProjectmanager(), p.getDescription(), p.getDevelopers());
    }

    @Override
    public int edit(Project p) {
        String sql="update projectstb set nameproject=?, projectmanager=?, description=?, developers=? where idproject=?";
        return template.update(sql, p.getNameproject(), p.getProjectmanager(), p.getDescription(), p.getDevelopers(), p.getIdproject());
    }

    @Override
    public int delete(int id) {
        String sql="delete from projectstb where idproject=?";
        return template.update(sql,id);
    }

}
