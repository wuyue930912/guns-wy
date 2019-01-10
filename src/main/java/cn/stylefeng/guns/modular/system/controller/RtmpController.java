package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Rtmp;
import cn.stylefeng.guns.modular.system.service.IRtmpService;

/**
 * red5控制器
 *
 * @author fengshuonan
 * @Date 2019-01-09 10:32:13
 */
@Controller
@RequestMapping("/rtmp")
public class RtmpController extends BaseController {

    private String PREFIX = "/system/rtmp/";

    @Autowired
    private IRtmpService rtmpService;

    /**
     * 跳转到red5首页
     */
    @RequestMapping("/toRtmp")
    public String index() {
        return PREFIX + "rtmp.html";
    }

    /**
     * 跳转到添加red5
     */
    @RequestMapping("/rtmp_add")
    public String rtmpAdd() {
        return PREFIX + "rtmp_add.html";
    }

    /**
     * 跳转到修改red5
     */
    @RequestMapping("/rtmp_update/{rtmpId}")
    public String rtmpUpdate(@PathVariable Integer rtmpId, Model model) {
        Rtmp rtmp = rtmpService.selectById(rtmpId);
        model.addAttribute("item",rtmp);
        LogObjectHolder.me().set(rtmp);
        return PREFIX + "rtmp_edit.html";
    }

    /**
     * 获取red5列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return rtmpService.selectList(null);
    }

    /**
     * 新增red5
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Rtmp rtmp) {
        rtmpService.insert(rtmp);
        return SUCCESS_TIP;
    }

    /**
     * 删除red5
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer rtmpId) {
        rtmpService.deleteById(rtmpId);
        return SUCCESS_TIP;
    }

    /**
     * 修改red5
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Rtmp rtmp) {
        rtmpService.updateById(rtmp);
        return SUCCESS_TIP;
    }

    /**
     * red5详情
     */
    @RequestMapping(value = "/detail/{rtmpId}")
    @ResponseBody
    public Object detail(@PathVariable("rtmpId") Integer rtmpId) {
        return rtmpService.selectById(rtmpId);
    }
}
