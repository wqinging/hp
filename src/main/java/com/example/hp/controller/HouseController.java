package com.example.hp.controller;


import com.example.hp.domian.Agent;
import com.example.hp.domian.House;
import com.example.hp.domian.Page;
import com.example.hp.service.IAgentService;
import com.example.hp.utils.FileUtils;
import com.example.hp.vo.HouseResponse;
import com.example.hp.vo.PageResult;
import com.example.hp.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/house")
public class HouseController {


    @Autowired
    private IHouseService houseService;

    @Autowired
    private IAgentService agentService;

    @Value("${file.house.uploadPath}")
    private String uploadPath;

    @GetMapping(value = "/all")
    public ResponseEntity getAll(House house, Page page){
        List<House> houses = houseService.showHouse(house, page);
        List<HouseResponse> houseResponses = new ArrayList<>();
        for(House house1 : houses){
            HouseResponse houseResponse = new HouseResponse();
            houseResponse.setHouse(house);
            Integer agentId = house1.getAgent();
            if(agentId != null){
                Agent agent = agentService.findById(agentId);
                houseResponse.setAgent(agent);
            }
            houseResponses.add(houseResponse);
        }
        int total = houseService.countHouse(house);
        PageResult pageResult = new PageResult();
        pageResult.setBody(houses);
        pageResult.setTotal(total);
        return ResponseEntity.ok().body(houseResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity details(@PathVariable(value = "id") int id){
        House house = houseService.showHouseById(id);
        HouseResponse houseResponse = new HouseResponse();
        houseResponse.setHouse(house);
        Integer agentId = house.getAgent();
        if(agentId != null){
            Agent agent = agentService.findById(agentId);
            houseResponse.setAgent(agent);
        }
        return ResponseEntity.ok().body(house);
    }

    @PostMapping("/create")
    public ResponseEntity create(House house, MultipartFile file) throws Exception {
        String upload = FileUtils.upload(file, uploadPath, file.getOriginalFilename());
        house.setImage(upload);
        houseService.insert(house);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity update(House house, MultipartFile file) throws Exception {
        if(file != null){
            String upload = FileUtils.upload(file, uploadPath, file.getOriginalFilename());
            house.setImage(upload);
        }
        houseService.update(house);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id) throws Exception {
        House house = houseService.showHouseById(id);
        FileUtils.delete(uploadPath+"/"+house.getImage());
        houseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
