package cn.stylefeng.guns.app.controller;

import cn.stylefeng.guns.modular.system.model.Rtmp;
import cn.stylefeng.guns.modular.system.service.IRtmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eureka")
public class eurekaController {

    @Autowired
    private IRtmpService service;

    @GetMapping("/getRtmp")
    public List<Rtmp> getRtmp(){
        return service.findAll();
    }

}
