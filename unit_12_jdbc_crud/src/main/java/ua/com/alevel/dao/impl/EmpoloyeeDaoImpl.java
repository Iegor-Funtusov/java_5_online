package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.EmpoloyeeDao;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.jdbc.JdbcService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EmpoloyeeDaoImpl implements EmpoloyeeDao {

    private final Connection connection = JdbcService.getInstance().getConnection();
    private final Statement statement = JdbcService.getInstance().getStatement();

    private static final String CREATE_EMPLOYEE = "insert into employees values (default, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "update employees set first_name = ?, last_name = ?, age = ? where id = ?";
    private static final String DELETE_EMPLOYEE = "delete from employees where id = ?";
    private static final String FIND_ALL_EMPLOYEES = "select * from employees";
    private static final String FIND_EMPLOYEE_BY_ID = "select * from employees where id = ";

    @Override
    public void create(Employee employee) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_EMPLOYEE)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Employee employee) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getAge());
            ps.setLong(4, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        try(ResultSet rs = statement.executeQuery(FIND_EMPLOYEE_BY_ID + id)) {
            rs.next();
            return Optional.of(convertResultSetToEmployee(rs));
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try(ResultSet rs = statement.executeQuery(FIND_ALL_EMPLOYEES)) {
            while (rs.next()) {
                employees.add(convertResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return employees;
    }

    @Override
    public boolean existsByFirstNameOrLastName(String firstName, String lastName) {
        try(PreparedStatement ps = connection.prepareStatement("select count(*) as count_of_employee from employees where first_name like ? or last_name like ?")) {
            ps.setString(1, "%" + firstName + "%");
            ps.setString(2, "%" + lastName + "%");
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            long count = resultSet.getLong("count_of_employee");
            return count > 0;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return false;
    }

    private Employee convertResultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int age = resultSet.getInt("age");
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        return employee;
    }
}
