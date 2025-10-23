package dev.peixotim.financecore.user.Controller;

import dev.peixotim.financecore.user.DTOs.UserRequest;
import dev.peixotim.financecore.user.DTOs.UserResponse;
import dev.peixotim.financecore.user.Service.UserService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(name = "user")
@RestController
public class Controller {

    private UserService service;

    public Controller(UserService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<UserResponse> deleteByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteByName(name));
    }
}
