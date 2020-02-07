package com.example.hp.controller;


import com.example.hp.domian.Agent;
import com.example.hp.service.IAgentService;
import com.example.hp.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "api/agent")
public class AgentController {

    @Autowired
    private IAgentService agentService;

    @Value("${file.agent.uploadPath}")
    private String uploadPath;


    @GetMapping("/all")
    public ResponseEntity findAll(){
        List<Agent> all = agentService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping("/register")
    public ResponseEntity register(Agent agent, MultipartFile file) throws Exception {
        String upload = FileUtils.upload(file, uploadPath, file.getOriginalFilename());
        agent.setImage(upload);
        agentService.insert(agent);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity update(Agent agent,MultipartFile file) throws Exception {
        if(file != null){
            String upload = FileUtils.upload(file, uploadPath, file.getOriginalFilename());
            agent.setImage(upload);
        }
        agentService.update(agent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        Agent agent = agentService.findById(id);
        String image = agent.getImage();
        FileUtils.delete(uploadPath+"/"+image);
        agentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
