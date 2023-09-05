package run.renren.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import run.renren.entity.ForumCommentEntity;
import run.renren.mapper.ForumCommentMapper;
import run.renren.service.ForumCommentService;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Service("forumCommentService")
public class ForumCommentServiceImpl extends ServiceImpl<ForumCommentMapper, ForumCommentEntity> implements ForumCommentService {

}