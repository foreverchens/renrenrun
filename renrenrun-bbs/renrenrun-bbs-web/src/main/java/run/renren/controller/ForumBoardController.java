package run.renren.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.service.ForumBoardService;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class ForumBoardController {
    @Autowired
    private ForumBoardService forumBoardService;

    /**
     * 列表
     */
    @GetMapping("/board/list")
    public Object list(){
        return forumBoardService.list();
    }
}
