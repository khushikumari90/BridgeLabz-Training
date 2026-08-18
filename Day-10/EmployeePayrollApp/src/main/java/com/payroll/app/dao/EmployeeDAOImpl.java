package com.payroll.app.dao;

import com.payroll.app.dto.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Employee> employeeRowMapper = (rs, rowNum) -> new Employee(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("department"),
            rs.getBigDecimal("salary")
    );

    @Override
    public List<Employee> findAll(){
        return jdbcTemplate.query("SELECT * FROM employees",employeeRowMapper);
    }

    @Override
    public Optional<Employee> findById(Long id){
        List<Employee> results = jdbcTemplate.query(
                "SELECT * FROM employees WHERE id = ?", employeeRowMapper,id);
        return results.stream().findFirst();
    }

    @Override
    public Employee save(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection ->{
                    PreparedStatement ps = connection.prepareStatement(
                            "INSERT INTO employees(name, department, salary) VALUES (?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, employee.getName());
                    ps.setString(2, employee.getDepartment());
                    ps.setBigDecimal(3, employee.getSalary());
                    return ps;
                }, keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        employee.setId(generatedId);
        return employee;
    }

    @Override
    public Employee update(Long id, Employee employee) {
        jdbcTemplate.update(
                "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?",
                employee.getName(), employee.getDepartment(), employee.getSalary(), id);
        employee.setId(id);
        return employee;
    }

    @Override
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM employees WHERE id = ?",id);
    }

    @Override
    public boolean existsById(Long id){
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM employees WHERE id = ?", Integer.class, id);
        return count != null && count > 0;
    }

}
