package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Rtmp;
import cn.stylefeng.guns.modular.system.dao.RtmpMapper;
import cn.stylefeng.guns.modular.system.service.IRtmpService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * rtmp表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-01-09
 */
@Service
public class RtmpServiceImpl extends ServiceImpl<RtmpMapper, Rtmp> implements IRtmpService {

    @Override
    public List<Rtmp> findAll() {
        return this.baseMapper.selectLives();
    }
}
