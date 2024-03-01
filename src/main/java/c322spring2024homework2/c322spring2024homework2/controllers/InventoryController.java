package c322spring2024homework2.c322spring2024homework2.controllers;

import c322spring2024homework2.c322spring2024homework2.model.GuitarData;
import c322spring2024homework2.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController{

    private InventoryRepository inventoryRepository;
    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }


    @GetMapping
    public List<GuitarData> findAll(){
        try{
            return inventoryRepository.findAll();
        } catch (IOException e){
            return null;
        }
    }


    @PostMapping
    public boolean add(@RequestBody GuitarData data){
        try{
            System.out.println("Adding guitar to inventory: " + data.serialNumber());
            return inventoryRepository.add(data);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<GuitarData> find(@PathVariable String serialNumber){
        try{
            GuitarData guitar = inventoryRepository.find(serialNumber);
            if(guitar != null){
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(guitar);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (IOException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }



}