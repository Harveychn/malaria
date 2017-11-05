//创建和初始化地图函数：
   function initMap() {
    createMap();//创建地图
    setMapEvent();//设置地图事件
    addMapControl();//向地图添加控件
}

//创建地图函数：
function createMap() {
	var map = new BMap.Map("mapContainer");//在百度地图容器中创建一个地图
    var point = new BMap.Point(120.16198, 30.280059);//定义一个中心点坐标
    map.centerAndZoom(point, 15);//设定地图的中心点和坐标并将地图显示在地图容器中
    window.map = map;//将map变量存储在全局
}

//地图事件设置函数：
function setMapEvent() {
	map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
	map.enableScrollWheelZoom();//启用地图滚轮放大缩小
	map.disableDoubleClickZoom();//禁用鼠标双击放大
	map.enableKeyboard();//启用键盘上下左右键移动地图
}

//地图控件添加函数：
function addMapControl() {
	//向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
}

$(document).ready(function () {
    initMap();
});
