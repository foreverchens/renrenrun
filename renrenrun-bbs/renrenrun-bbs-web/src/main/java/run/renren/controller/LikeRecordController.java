package run.renren.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.service.LikeRecordService;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class LikeRecordController {
    @Autowired
    private LikeRecordService likeRecordService;

    /**
     * 列表
     */
    @GetMapping("/like/list")
    public Object list(){
        return likeRecordService.list();
    }
}
