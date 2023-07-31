package uz.hr.Management.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.hr.Management.dto.SuccessDto;
import uz.hr.Management.dto.UserDto;
import uz.hr.Management.dto.UserForm;
import uz.hr.Management.entity.User;
import uz.hr.Management.enums.UserRole;
import uz.hr.Management.exception.AppException;
import uz.hr.Management.repository.UserRepository;
import uz.hr.Management.service.DirectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final UserRepository userRepository;

    public UserDto add(UserForm form) {
        boolean existsByUsername = userRepository.existsByUsername(form.getEmail());
        if (existsByUsername) {
            return UserDto.toDto(userRepository.save(User.builder()
                    .name(form.getName())
                    .username(form.getUsername())
                    .email(form.getEmail())
                    .confirmed(true)
                    .role(UserRole.DIRECTOR)
                    .phoneNumber(form.getPhoneNumber())
                    .build()));
        } else {
            throw new AppException("username is already exists ");
        }
    }

    public UserDto update(UserForm form, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User user = userOptional.get();
        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setPhoneNumber(form.getPhoneNumber());
        return UserDto.toDto(user);
    }

    public UserDto getOne(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new AppException(String.format("there is no user with  " + id));
        }
        User user = optionalUser.get();
        return UserDto.toDto(user);
    }

    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = UserDto.toDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public SuccessDto delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new AppException(String.format("there is no user with id" + id));
        }
        userRepository.deleteById(id);
        SuccessDto successDto = new SuccessDto();
        successDto.setStatus("deleted successfully");
        successDto.setSuccess(true);
        return successDto;
    }
//   7/26/2023 1.get director crud done, 2. get hr_manager done, 3. get user done
}
