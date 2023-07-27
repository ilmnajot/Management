package uz.hr.Management.service.Impl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.hr.Management.dto.SuccessDto;
import uz.hr.Management.dto.UserDto;
import uz.hr.Management.dto.UserForm;
import uz.hr.Management.entity.User;
import uz.hr.Management.enums.UserRole;
import uz.hr.Management.exception.AppException;
import uz.hr.Management.repository.UserRepository;
import uz.hr.Management.service.ManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ManagerServiceImpl implements ManagerService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto add(UserForm form) {
        return UserDto.toDto(userRepository.save(User.builder()
                .name(form.getName())
                .username(form.getUsername())
                .password(passwordEncoder.encode(form.getPassword()))
                .email(form.getEmail())
                .confirmed(true)
                .role(UserRole.HR_MANAGER)
                .phoneNumber(form.getPhoneNumber())
                .build()));
    }
    @Override
    public UserDto getOne(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new AppException(String.format("user not found with id " + id));
        }
        return UserDto.toDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(UserDto.toDto(user));
        }
        return userDtoList;
    }
    @Override
    public UserDto update(UserForm form, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new AppException(String.format("user not found with id " + id));
        }
        User user = optionalUser.get();
        user.setId(id);
        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());
    return UserDto.toDto(user);
    }
    @Override
    public SuccessDto delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new AppException(String.format("user not found with id " + id));
        }
        userRepository.deleteById(id);
        SuccessDto successDto = new SuccessDto();
        successDto.setStatus("deleted successfully");
        successDto.setSuccess(true);
        return successDto;
    }
}
