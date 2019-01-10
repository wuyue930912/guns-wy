/**
 * red5管理初始化
 */
var Rtmp = {
    id: "RtmpTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Rtmp.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'userid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'livertmp', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'livename', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'livetitle', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'livepage', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'liveimage', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'livestate', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'red5url', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'bz', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'top', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Rtmp.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Rtmp.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加red5
 */
Rtmp.openAddRtmp = function () {
    var index = layer.open({
        type: 2,
        title: '添加red5',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/rtmp/rtmp_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看red5详情
 */
Rtmp.openRtmpDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'red5详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/rtmp/rtmp_update/' + Rtmp.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除red5
 */
Rtmp.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/rtmp/delete", function (data) {
            Feng.success("删除成功!");
            Rtmp.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("rtmpId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询red5列表
 */
Rtmp.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Rtmp.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Rtmp.initColumn();
    var table = new BSTable(Rtmp.id, "/rtmp/list", defaultColunms);
    table.setPaginationType("client");
    Rtmp.table = table.init();
});
