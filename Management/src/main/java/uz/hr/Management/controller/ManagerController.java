package uz.hr.Management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.hr.Management.dto.SuccessDto;
import uz.hr.Management.dto.UserDto;
import uz.hr.Management.dto.UserForm;
import uz.hr.Management.service.ManagerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/managers")
public class ManagerController {

    private final ManagerService managerService;
    @PostMapping("/register")
    public UserDto saveDirector(@RequestBody UserForm form) {
        return managerService.add(form);
    }

    @PostMapping("/{id}")
    public UserDto getOneDirector(@PathVariable Long id) {
        return managerService.getOne(id);
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return managerService.getAll();
    }

    @PutMapping("/{id}")
    public UserDto edit(@PathVariable Long id, @RequestBody UserForm form) {
        return managerService.update(form, id);
    }
    @DeleteMapping("/{id}")
    public SuccessDto delete(@PathVariable Long id){
        return managerService.delete(id);
    }
}
