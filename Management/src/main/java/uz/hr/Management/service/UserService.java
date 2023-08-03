package uz.hr.Management.service;

import uz.hr.Management.dto.SuccessDto;
import uz.hr.Management.dto.UserDto;
import uz.hr.Management.dto.UserForm;

import java.util.List;

public interface UserService {
    UserDto addDirector(UserForm form);

    UserDto addManager(UserForm form);

    UserDto addUser(UserForm form);

    ConfirmDto confirmLink(String hash);

    SuccessDto confirm(ConfirmDto dto);

    UserDto update(UserForm form, Long id);

    UserDto getOne(Long id);

    List<UserDto> getAll();

    SuccessDto delete(Long id);
}
