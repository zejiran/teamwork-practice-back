package co.edu.uniandes.dse.treeking.controllers;

import co.edu.uniandes.dse.treeking.dto.RouteDTO;
import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.services.RouteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<RouteDTO> findAll() {
        List<RouteEntity> routes = routeService.getRoutes();
        return modelMapper.map(routes, new TypeToken<List<RouteDTO>>(){}.getType());
    }
}
