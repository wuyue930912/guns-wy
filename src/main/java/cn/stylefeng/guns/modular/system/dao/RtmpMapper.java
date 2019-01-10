package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Rtmp;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * rtmp表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-01-09
 */
public interface RtmpMapper extends BaseMapper<Rtmp> {

    List<Rtmp> selectLives();
}
