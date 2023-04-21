package ua.com.alevel.persistence.repositoty;

import org.springframework.data.jpa.repository.Query;
import ua.com.alevel.persistence.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee> {

    List<Employee> findAllByAgeBetween(Integer left, Integer right);
    List<Employee> findAllByAgeBeforeAndAgeAfterAndEmailInAndAgeBetween(Integer left, Integer right, List<String> emails, Integer start, Integer end);

    void deleteAllByFirstNameContainingIgnoreCase(String like);

    Long countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith(String like, Integer age, String name);

    boolean existsAllByEmailContainingIgnoreCase(String email);

    @Query(value = "Select Id, Postcode, Lat, Lon,\n" +
            "       acos(sin(:lat)*sin(radians(Lat)) + cos(:lat)*cos(radians(Lat))*cos(radians(Lon)-:lon)) * :R As D\n" +
            "From (\n" +
            "    Select Id, Postcode, Lat, Lon\n" +
            "    From MyTable\n" +
            "    Where Lat Between :minLat And :maxLat\n" +
            "      And Lon Between :minLon And :maxLon\n" +
            "    ) As FirstCut\n" +
            "Where acos(sin(:lat)*sin(radians(Lat)) + cos(:lat)*cos(radians(Lat))*cos(radians(Lon)-:lon)) * :R < :rad\n" +
            "Order By D", nativeQuery = true)
    List<?> f();
}
