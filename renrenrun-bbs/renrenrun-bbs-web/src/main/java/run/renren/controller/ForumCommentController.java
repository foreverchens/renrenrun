package run.renren.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.service.ForumCommentService;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class ForumCommentController {
    @Autowired
    private ForumCommentService forumCommentService;

    /**
     * 列表
     */
    @GetMapping("/comment/list")
    public Object list(){
        return forumCommentService.list();
    }
}
