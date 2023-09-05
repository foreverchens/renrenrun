package run.renren.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.service.ForumArticleService;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class ForumArticleController {
    @Autowired
    private ForumArticleService forumArticleService;
    /**
     * 列表
     */
    @GetMapping("/article/list")
    public Object list(){
        return forumArticleService.list();
    }
}
