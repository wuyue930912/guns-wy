package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * rtmp表
 * </p>
 *
 * @author stylefeng
 * @since 2019-01-09
 */
@TableName("sys_rtmp")
public class Rtmp extends Model<Rtmp> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer userid;
    private String livertmp;
    private String livename;
    private String livetitle;
    private String livepage;
    private String liveimage;
    private Integer livestate;
    private String red5url;
    private Date createtime;
    private String bz;
    private Integer top;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLivertmp() {
        return livertmp;
    }

    public void setLivertmp(String livertmp) {
        this.livertmp = livertmp;
    }

    public String getLivename() {
        return livename;
    }

    public void setLivename(String livename) {
        this.livename = livename;
    }

    public String getLivetitle() {
        return livetitle;
    }

    public void setLivetitle(String livetitle) {
        this.livetitle = livetitle;
    }

    public String getLivepage() {
        return livepage;
    }

    public void setLivepage(String livepage) {
        this.livepage = livepage;
    }

    public String getLiveimage() {
        return liveimage;
    }

    public void setLiveimage(String liveimage) {
        this.liveimage = liveimage;
    }

    public Integer getLivestate() {
        return livestate;
    }

    public void setLivestate(Integer livestate) {
        this.livestate = livestate;
    }

    public String getRed5url() {
        return red5url;
    }

    public void setRed5url(String red5url) {
        this.red5url = red5url;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Rtmp{" +
        ", id=" + id +
        ", userid=" + userid +
        ", livertmp=" + livertmp +
        ", livename=" + livename +
        ", livetitle=" + livetitle +
        ", livepage=" + livepage +
        ", liveimage=" + liveimage +
        ", livestate=" + livestate +
        ", red5url=" + red5url +
        ", createtime=" + createtime +
        ", bz=" + bz +
        ", top=" + top +
        "}";
    }
}
