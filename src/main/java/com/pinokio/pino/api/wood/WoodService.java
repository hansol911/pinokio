package com.pinokio.pino.api.wood;

import com.pinokio.pino.api.model.Wood;
import com.pinokio.pino.exception.WoodNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class WoodService {
    private final WoodRepo woodRepo;

    public WoodService(WoodRepo woodRepo) {
        this.woodRepo = woodRepo;
    }

    public WoodDTO createWood(WoodCommand.CreateWood woodCommand) {
        return WoodDTO.toDTO(woodRepo.save(woodCommand.toWood()));
    }

    public List<WoodDTO> readAllWoods() {
        List<Wood> woods = woodRepo.findAll();
        return woods.stream().map(WoodDTO::toDTO).collect(Collectors.toList());
    }

    public WoodDTO readWoodById(Long woodNum) {
        Wood wood = woodRepo.findById(woodNum).orElseThrow(() -> new WoodNotFoundException("wood not found"));
        return WoodDTO.toDTO(wood);
    }

    public WoodDTO updateByWoodNum(Long woodNum, WoodCommand.UpdateWood woodCommand) {
        Wood wood = woodRepo.findById(woodNum).orElseThrow(() -> new WoodNotFoundException("wood not found"));
        return WoodDTO.toDTO(woodRepo.save(woodCommand.toWood(wood)));
    }

    public String deleteByWoodNum(Long woodNum) {
        woodRepo.deleteById(woodNum);
        return "DELETE SUCCESS";
    }

}

