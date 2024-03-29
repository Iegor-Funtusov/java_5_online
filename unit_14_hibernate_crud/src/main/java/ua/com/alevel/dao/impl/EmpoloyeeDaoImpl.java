package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.EmpoloyeeDao;
import ua.com.alevel.datatable.DataTableRequest;
import ua.com.alevel.datatable.DataTableResponse;
import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmpoloyeeDaoImpl implements EmpoloyeeDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void update(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public void delete(Employee employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            transaction.commit();
            return Optional.of(employee);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public Collection<Employee> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Employee");
            List<Employee> employees = query.getResultList();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public DataTableResponse<Employee> findAll(DataTableRequest request) {
        DataTableResponse<Employee> employeeDataTableResponse = new DataTableResponse<>();
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> from = criteriaQuery.from(Employee.class);
            if (request.getOrderBy().equals("desc")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(from.get(request.getSortBy())));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.asc(from.get(request.getSortBy())));
            }

            int page = (request.getPage() - 1) * request.getSize();

            List<Employee> employees = session.createQuery(criteriaQuery)
                    .setFirstResult(page)
                    .setMaxResults(request.getSize())
                    .getResultList();

            employeeDataTableResponse.setItems(employees);
            employeeDataTableResponse.setPage(request.getPage());
            employeeDataTableResponse.setSize(request.getSize());
            employeeDataTableResponse.setOrderBy(request.getOrderBy());
            employeeDataTableResponse.setSortBy(request.getSortBy());

            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return employeeDataTableResponse;
    }

    @Override
    public boolean existsByFirstNameOrLastName(String firstName, String lastName) {
        return false;
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
