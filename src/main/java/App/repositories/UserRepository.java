package App.repositories;

import App.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);
    Page<User> findByPhoneNumber(String phoneNumber, Pageable pageable);
    Page<User> findByFirstNameAndLastName(String firstName,String lastName, Pageable pageable);
    Page<User> findByFirstNameOrLastName(String firstName,String lastName, Pageable pageable);

}
