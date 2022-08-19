package com.example.week56.controller;

import com.example.week56.bean.Lost;
import com.example.week56.service.LostService;
import com.example.week56.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lost")
public class LostController {
    @Autowired
    private LostService lostService;

    @PostMapping(value ="/add")
    public Result add(Lost lost){
        return lostService.add(lost);
    }

    @GetMapping(value = "/delete/{value}")
    public Result delete(@PathVariable("value") Long lost_id){
        return lostService.delete(lost_id);
    }

    @GetMapping(value = "/search/{value}")
    public Result search(@PathVariable("value") Long lost_id) {
        return lostService.search(lost_id);
    }

    @PostMapping(value = "/update")
    public Result update(Lost lost){
        return lostService.update(lost);
    }

}
