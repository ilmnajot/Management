package uz.hr.Management.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.hr.Management.dto.SuccessDto;
import uz.hr.Management.dto.UserDto;
import uz.hr.Management.dto.UserForm;
import uz.hr.Management.service.DirectorService;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class DirectorController {

    private final DirectorService directorService;

    @PostMapping("/register")
    public UserDto saveDirector(@RequestBody UserForm form) {
        return directorService.add(form);
    }

    @PostMapping("/{id}")
    public UserDto getOneDirector(@PathVariable Long id) {
        return directorService.getOne(id);
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return directorService.getAll();
    }

    @PutMapping("/{id}")
    public UserDto edit(@PathVariable Long id, @RequestBody UserForm form) {
        return directorService.update(form, id);
    }
    @DeleteMapping("/{id}")
    public SuccessDto delete(@PathVariable Long id){
        return directorService.delete(id);
    }
}
