package App.repositories;

import App.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String phoneNumber);
}
