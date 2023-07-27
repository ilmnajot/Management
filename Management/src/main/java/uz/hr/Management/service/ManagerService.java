package uz.hr.Management.service;

import uz.hr.Management.dto.SuccessDto;
import uz.hr.Management.dto.UserDto;
import uz.hr.Management.dto.UserForm;

import java.util.List;

public interface ManagerService {
    UserDto add(UserForm form);

    UserDto getOne(Long id);

    List<UserDto> getAll();

    UserDto update(UserForm form, Long id);

    SuccessDto delete(Long id);
}
