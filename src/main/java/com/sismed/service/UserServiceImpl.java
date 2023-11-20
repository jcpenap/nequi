package com.sismed.service;

import com.sismed.domain.User;
import com.sismed.exception.CustomException;
import com.sismed.repository.RoleRepository;
import com.sismed.repository.UserRepository;
import com.sismed.request.UserRequest;
import com.sismed.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(users())
                .collect(Collectors.toList());
    }

    private Function<User, UserResponse> users() {
        return user -> {
            UserResponse response = new UserResponse();
            response.setEmail(user.getEmail());
            response.setId(user.getId());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            List<String> roles = userRepository.rolesByUserId(user.getId());
            response.setRoles(roles);
            return response;
        };
    }

    @Override
    public void edit(int id, UserRequest request) throws CustomException {
        User user = userRepository.findById(id).orElseThrow(() -> new CustomException("user not found","500"));
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setRoles(request.getRoles().stream().map(roleRepository::findByName).collect(Collectors.toSet()));
        userRepository.save(user);
    }
}
