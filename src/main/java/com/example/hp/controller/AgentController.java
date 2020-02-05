package com.example.hp.controller;


import com.example.hp.domian.Agent;
import com.example.hp.service.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/agent")
public class AgentController {

    @Autowired
    private IAgentService agentService;


    @GetMapping("/all")
    public ResponseEntity findAll(){
        List<Agent> all = agentService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Agent agent){
        agentService.insert(agent);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Agent agent){
        agentService.update(agent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        agentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
