package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Rtmp;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * rtmp表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-01-09
 */
public interface IRtmpService extends IService<Rtmp> {
    List<Rtmp> findAll();
}
