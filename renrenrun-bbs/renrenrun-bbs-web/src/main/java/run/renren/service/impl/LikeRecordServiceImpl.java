package run.renren.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import run.renren.entity.LikeRecordEntity;
import run.renren.mapper.LikeRecordMapper;
import run.renren.service.LikeRecordService;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Service("likeRecordService")
public class LikeRecordServiceImpl extends ServiceImpl<LikeRecordMapper, LikeRecordEntity> implements LikeRecordService {}