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

    public Page<User> listAllByNumber(String number,Pageable pageable){
        return userRepository.findByPhoneNumber(number,pageable);
    }

    public Page<User> listAllByName(String name,Pageable pageable){
        String lastname = "";
        String firstname = "";

        if(name.split("\\w+").length>1){
            lastname = name.substring(name.lastIndexOf(" ")+1);
            firstname = name.substring(0, name.lastIndexOf(' '));
        }else{
            firstname = name;
        }

        System.out.println(firstname);
        System.out.println(lastname);

        return userRepository.findByFirstNameAndLastName(firstname,lastname,pageable);
    }

    public void save(User newuser){
        User user = userRepository.findByPhoneNumber(newuser.getPhoneNumber());
        if (user == null) {
            userRepository.save(newuser);
        }else{
            user.setFirstName(newuser.getFirstName());
            user.setLastName(newuser.getLastName());
            user.setPhoneBook(newuser.getPhoneBook());
            userRepository.save(user);
        }
    }
}
