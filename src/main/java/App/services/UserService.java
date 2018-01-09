package App.services;

import App.entities.User;
import App.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by MoustafaELkady on 1/8/18.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Page<User> listAllByPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
