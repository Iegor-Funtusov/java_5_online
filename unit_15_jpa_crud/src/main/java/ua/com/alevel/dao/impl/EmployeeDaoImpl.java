package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.datatable.DataTableRequest;
import ua.com.alevel.datatable.DataTableResponse;
import ua.com.alevel.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public boolean existsById(Long id) {
        Query query = entityManager
                .createQuery("select count(e.id) from Employee as e where e.id = :id")
                .setParameter("id", id);
        return (Long) query.getSingleResult() == 1;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.of(entityManager.find(Employee.class, id));
    }

    @Override
    public DataTableResponse<Employee> findAll(DataTableRequest request) {
        DataTableResponse<Employee> employeeDataTableResponse = new DataTableResponse<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        if (request.getOrderBy().equals("desc")) {
            criteriaQuery.orderBy(criteriaBuilder.desc(from.get(request.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.asc(from.get(request.getSortBy())));
        }

        int page = (request.getPage() - 1) * request.getSize();

        List<Employee> employees = entityManager.createQuery(criteriaQuery)
                .setFirstResult(page)
                .setMaxResults(request.getSize())
                .getResultList();

        employeeDataTableResponse.setItems(employees);
        employeeDataTableResponse.setPage(request.getPage());
        employeeDataTableResponse.setSize(request.getSize());
        employeeDataTableResponse.setOrderBy(request.getOrderBy());
        employeeDataTableResponse.setSortBy(request.getSortBy());
        return employeeDataTableResponse;
    }
}
