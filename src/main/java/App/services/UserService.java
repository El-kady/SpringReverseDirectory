package App.services;

import App.entities.Contact;
import App.entities.User;
import App.repositories.ContactRepository;
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

    @Autowired
    ContactRepository contactRepository;

    public Page<User> listAllByPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public void save(User newuser){
        User user = userRepository.findByPhoneNumber(newuser.getPhoneNumber());
        if (user == null) {
            userRepository.save(newuser);
        }else{
            newuser.getPhoneBook().forEach(newcontact -> {

            });
        }
    }
}
