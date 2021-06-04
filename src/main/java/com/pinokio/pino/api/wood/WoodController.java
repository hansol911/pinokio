package com.pinokio.pino.api.wood;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("woods")
public class WoodController {
    private final WoodService woodService;

    public WoodController(WoodService woodService) {
        this.woodService = woodService;
    }

    @PostMapping
    public WoodDTO createWood(@RequestBody WoodCommand.CreateWood woodCommand) {
        return woodService.createWood(woodCommand);
    }

    @GetMapping
    public List<WoodDTO> readAllWoods() {
        return woodService.readAllWoods();
    }

    @GetMapping(value = "/{woodNum}")
    public WoodDTO readWoodById(@PathVariable Long woodNum) {
        return woodService.readWoodById(woodNum);
    }

    @PutMapping(value = "/{woodNum}")
    public WoodDTO updateWood(@PathVariable Long woodNum, @RequestBody WoodCommand.UpdateWood woodCommand) {
        return woodService.updateByWoodNum(woodNum, woodCommand);
    }

    @DeleteMapping(value = "/{woodNum}")
    public String deleteWood(@PathVariable Long woodNum){
        return woodService.deleteByWoodNum(woodNum);
    }

}
