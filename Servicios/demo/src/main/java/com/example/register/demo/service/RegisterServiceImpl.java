package com.example.register.demo.service;

import com.example.register.demo.dto.request.UserRequest;
import com.example.register.demo.dto.response.UserResponse;
import com.example.register.demo.exceptions.RepeatedEmailException;
import com.example.register.demo.exceptions.RepeatedUsernameException;
import com.example.register.demo.model.User;
import com.example.register.demo.repository.UserRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    @Autowired
    UserRepositorty userRepository;

    @Transactional
    @Override
    public UserResponse registerUser(UserRequest userRequest) throws Exception{

        User user = new User();

        User transactionUser = new User();
        String error = "";

        List<User> emailOccurrences = userRepository.findUserByEmail(userRequest.getEmail());
        List<User> usernameOccurrences = userRepository.findUserByUserName(userRequest.getUsername());

        int emailOccurrencesSize = emailOccurrences.size();
        int usernameOccurrencesSize = usernameOccurrences.size();

        user.setIdUser(userRequest.getIdUser());
        user.setName(userRequest.getName());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setLeader(userRequest.isLeader());
        user.setUsername(userRequest.getUsername());
        user.setActivo(userRequest.isActivo());

        UserResponse userResponse = new UserResponse();

        try{

            if(emailOccurrencesSize > 0) {
                error = "Ya existe un usuario registrado con ese email. Vuelve a intentar con otro.";
                throw new RepeatedEmailException("RESP_REGISTER_00_ERROR: "+"Ya existe un usuario registrado con ese email. Vuelve a intentar con otro.");
            } else if(usernameOccurrencesSize  > 0){
                error = "Ya existe un usuario registrado con ese username. Vuelve a intentar con otro.";
                throw new RepeatedUsernameException("RESP_REGISTER_00_ERROR: "+"Ya existe un usuario registrado con ese username. Vuelve a intentar con otro.");
            } else if(emailOccurrencesSize  == 0 && usernameOccurrencesSize == 0){
                transactionUser = userRepository.save(user);
            }

            userRepository.flush();

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            userResponse.setIdUser(transactionUser.getIdUser());
            userResponse.setName(transactionUser.getName());
            userResponse.setFirstname(transactionUser.getFirstname());
            userResponse.setLastname(transactionUser.getLastname());
            userResponse.setEmail(transactionUser.getEmail());
            userResponse.setPassword(transactionUser.getPassword());
            userResponse.setLeader(transactionUser.isLeader());
            userResponse.setUsername(transactionUser.getUsername());
            userResponse.setActivo(transactionUser.isActivo());

            userResponse.setRegisterStatus(true);
            userResponse.setRegisterMsg("Usuario registrado exitósamente. Enviando mensaje de confirmación.");
            userResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));


        }catch (Exception e){
            userResponse.setIdUser(user.getIdUser());
            userResponse.setName(user.getName());
            userResponse.setFirstname(user.getFirstname());
            userResponse.setLastname(user.getLastname());
            userResponse.setEmail(user.getEmail());
            userResponse.setPassword(user.getPassword());
            userResponse.setLeader(user.isLeader());
            userResponse.setUsername(user.getUsername());
            userResponse.setActivo(user.isActivo());

            userResponse.setRegisterStatus(false);
            userResponse.setRegisterMsg(error);
            userResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));

            e.printStackTrace();
        }

        return userResponse;
    }

}
