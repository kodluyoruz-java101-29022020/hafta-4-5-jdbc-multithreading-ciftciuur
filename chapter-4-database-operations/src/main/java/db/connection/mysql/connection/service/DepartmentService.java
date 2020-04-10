package db.connection.mysql.connection.service;

import db.connection.mysql.connection.dao.DepartmentDAO;
import db.connection.mysql.connection.model.Department;
import db.connection.mysql.connection.model.Employee;

import java.util.List;
import java.util.Set;

public class DepartmentService {

    private DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    // burada tüm departmanları listeleyen fonksiyonu yazınız.

    public List<Department> findAll() {
        return this.departmentDAO.getAll();
    }
}
