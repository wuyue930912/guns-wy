/**
 * 初始化red5详情对话框
 */
var RtmpInfoDlg = {
    rtmpInfoData : {}
};

/**
 * 清除数据
 */
RtmpInfoDlg.clearData = function() {
    this.rtmpInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RtmpInfoDlg.set = function(key, val) {
    this.rtmpInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RtmpInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RtmpInfoDlg.close = function() {
    parent.layer.close(window.parent.Rtmp.layerIndex);
}

/**
 * 收集数据
 */
RtmpInfoDlg.collectData = function() {
    this
    .set('id')
    .set('userid')
    .set('livertmp')
    .set('livename')
    .set('livetitle')
    .set('livepage')
    .set('liveimage')
    .set('livestate')
    .set('red5url')
    .set('createtime')
    .set('bz')
    .set('top');
}

/**
 * 提交添加
 */
RtmpInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/rtmp/add", function(data){
        Feng.success("添加成功!");
        window.parent.Rtmp.table.refresh();
        RtmpInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.rtmpInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RtmpInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/rtmp/update", function(data){
        Feng.success("修改成功!");
        window.parent.Rtmp.table.refresh();
        RtmpInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.rtmpInfoData);
    ajax.start();
}

$(function() {

});
