package co.edu.uniandes.dse.treeking.controllers;


import co.edu.uniandes.dse.treeking.dto.AdminDTO;
import co.edu.uniandes.dse.treeking.dto.AdminDetailDTO;
import co.edu.uniandes.dse.treeking.entities.AdminEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.services.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<AdminDTO> findAll() {
        List<AdminEntity> admins = adminService.getAdmins();
        return modelMapper.map(admins, new TypeToken<List<AdminDTO>>() {
        }.getType());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AdminDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
        AdminEntity entity = adminService.getAdmin(id);
        return modelMapper.map(entity, AdminDetailDTO.class);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdminDetailDTO create(@RequestBody AdminDetailDTO adminDTO) {
        AdminEntity adminEntity = adminService.createAdmin(modelMapper.map(adminDTO, AdminEntity.class));
        return modelMapper.map(adminEntity, AdminDetailDTO.class);
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public AdminDTO update(@PathVariable("id") Long id, @RequestBody AdminDTO AdminDTO)
            throws EntityNotFoundException {
        AdminEntity adminEntity = adminService.updateAdmin(id, modelMapper.map(AdminDTO, AdminEntity.class));
        return modelMapper.map(adminEntity, AdminDTO.class);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws EntityNotFoundException, IllegalOperationException {
        adminService.deleteAdmin(id);
    }

}
