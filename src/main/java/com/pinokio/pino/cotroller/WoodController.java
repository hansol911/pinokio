package com.pinokio.pino.cotroller;

import com.pinokio.pino.entity.Wood;
import com.pinokio.pino.service.WoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("woods")
public class WoodController {
    private final WoodService woodService;

    public WoodController(WoodService woodService) {
        this.woodService = woodService;
    }

    @GetMapping
    public ResponseEntity<List<Wood>> getAllWood() {
        List<Wood> wood = woodService.findAllWood();
        return new ResponseEntity<List<Wood>>(wood, HttpStatus.OK);
    }

    @GetMapping(value = "/{num}")
    public ResponseEntity<Wood> getWood(@PathVariable Integer num) {
        Optional<Wood> wood = woodService.findByWoodNum(num);
        return new ResponseEntity<Wood>(wood.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Wood> save(@RequestBody Wood wood) {
        return new ResponseEntity<Wood>(woodService.save(wood), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{num}")
    public ResponseEntity<Void> deleteWood(@PathVariable Integer num){
        woodService.deleteByWoodNum(num);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{num}")
    public ResponseEntity<Wood> updateWood(@PathVariable Integer num, @RequestBody Wood wood) {
        woodService.updateByWoodNum(num, wood);
        return new ResponseEntity<Wood>(wood, HttpStatus.OK);
    }

}
