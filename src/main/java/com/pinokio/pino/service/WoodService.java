package com.pinokio.pino.service;

import com.pinokio.pino.entity.Wood;
import com.pinokio.pino.repo.WoodRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Transactional
@Service
public class WoodService {
    private final WoodRepo woodRepo;

    public WoodService(WoodRepo woodRepo) {
        this.woodRepo = woodRepo;
    }

    public List<Wood> findAllWood(){
        return woodRepo.findAll();
    }

    public Optional<Wood> findByWoodNum(Integer num){
        Optional<Wood> wood = woodRepo.findById(num);
        return wood;
    }

    public Wood save(Wood wood) {
        woodRepo.save(wood);
        return wood;
    }

    public void deleteByWoodNum(Integer num) {
        woodRepo.deleteById(num);
    }

    public void updateByWoodNum(Integer num, Wood wood) {
        Optional<Wood> w = woodRepo.findById(num);
        if (w.isPresent()) {
            w.get().setWoodNum(wood.getWoodNum());
            w.get().setWoodName(wood.getWoodName());
            woodRepo.save(wood);
        }
    }

}
