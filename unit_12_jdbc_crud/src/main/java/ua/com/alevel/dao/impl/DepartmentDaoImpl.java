package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.jdbc.JdbcService;
import ua.com.alevel.util.DBOrderUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DepartmentDaoImpl implements DepartmentDao {

    private final Connection connection = JdbcService.getInstance().getConnection();
    private final Statement statement = JdbcService.getInstance().getStatement();

    private static final String CREATE_DEPARTMENT = "insert into departments values (default, ?)";
    private static final String UPDATE_DEPARTMENT = "update departments set name = ? where id = ?";
    private static final String DELETE_DEPARTMENT = "delete from departments where id = ?";
    private static final String FIND_DEPARTMENT_BY_ID = "select * from departments where id = ?";
    private static final String FIND_ALL_DEPARTMENTS = "select * from departments";
    private static final String FIND_ALL_DEPARTMENTS_STATISTICS = "select d.id, d.name, count(dep_id) as employee_count from departments as d join dep_emp de on d.id = de.dep_id group by d.id order by ";
    private static final String ATTACH_EMPLOYEE_TO_DEPARTMENT = "insert into dep_emp values (?, ?)";
    private static final String DETACH_EMPLOYEE_TO_DEPARTMENT = "delete from dep_emp where dep_id = ? and emp_id = ?";

    @Override
    public void create(Department department) {
        try(PreparedStatement ps = connection.prepareStatement(CREATE_DEPARTMENT)) {
            ps.setString(1, department.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Department department) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_DEPARTMENT)) {
            ps.setString(1, department.getName());
            ps.setLong(2, department.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_DEPARTMENT)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Optional<Department> findById(Long id) {
        try(PreparedStatement ps = connection.prepareStatement(FIND_DEPARTMENT_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Optional.of(convertResultSetToDepartment(rs));
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(FIND_ALL_DEPARTMENTS)) {
            while (resultSet.next()) {
                departments.add(convertResultSetToDepartment(resultSet));
            }
            return departments;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return departments;
    }

    @Override
    public void attachEmployeeToDepartment(Long departmentId, Long employeeId) {
        try(PreparedStatement ps = connection.prepareStatement(ATTACH_EMPLOYEE_TO_DEPARTMENT)) {
            ps.setLong(1, departmentId);
            ps.setLong(2, employeeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void detachEmployeeToDepartment(Long departmentId, Long employeeId) {
        try(PreparedStatement ps = connection.prepareStatement(DETACH_EMPLOYEE_TO_DEPARTMENT)) {
            ps.setLong(1, departmentId);
            ps.setLong(2, employeeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Collection<DepartmentDto> findDepartmentStatistics(String sortBy, DBOrderUtil orderBy) {
        List<DepartmentDto> departments = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery(FIND_ALL_DEPARTMENTS_STATISTICS + sortBy + " " + orderBy.getType())) {
            while (resultSet.next()) {
                departments.add(convertResultSetToDepartmentDto(resultSet));
            }
            return departments;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return departments;
    }

    private Department convertResultSetToDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        department.setId(id);
        department.setName(name);
        return department;
    }

    private DepartmentDto convertResultSetToDepartmentDto(ResultSet resultSet) throws SQLException {
        DepartmentDto departmentDto = new DepartmentDto();
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Long count = resultSet.getLong("employee_count");
        departmentDto.setId(id);
        departmentDto.setName(name);
        departmentDto.setEmployeeCount(count);
        return departmentDto;
    }
}
