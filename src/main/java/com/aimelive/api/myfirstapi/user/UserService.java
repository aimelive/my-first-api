package com.aimelive.api.myfirstapi.user;

import com.aimelive.api.myfirstapi.dto.ResponseData;
import com.aimelive.api.myfirstapi.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseData<List<User>> getAllUsers(){
        return new ResponseData<>(
                "Users retrieved successfully!",
               userRepository.findAll()
        );
    }

    @Transactional
    public ResponseData<User> newUser(User newUserBody){
        Optional<User> userByEmail = userRepository.findUserByEmail(newUserBody.getEmail());

        if(userByEmail.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        User createdUser = userRepository.save(newUserBody);
        return new ResponseData<User>("New user created successfully",createdUser);
    }

    ResponseData<User> getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
        return  new ResponseData<>("User retrieved successfully",user);
    }

    public ResponseData<User> getUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if(user.isPresent()){
            return new ResponseData<User>("User retrieved successfully",user.get());
        }
       throw new IllegalStateException("User with this email "+email+" does not exist.");
    }

    public ResponseData<User> updateUser(Long id, UpdateUserRequest newUser){
        User updatedUser = userRepository.findById(id).map(user -> {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setDob(newUser.getDob());
            return userRepository.save(user);
        }).orElseThrow(()-> new UserNotFoundException(id));
        return  new ResponseData<User>("User updated successfully!", updatedUser);
    }

    public ResponseData<Boolean> deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return new ResponseData<Boolean>("User with ID "+id+" has deleted successfully!",true);
    }
}
