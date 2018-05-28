var map;
var featurelayer;
var count = 1;
//获取后台年份数据
$(function () {
    $.ajax({
        type: "get",
        url: "../cluster/getAllYear",
        dataType: "json",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var $option = '<option>' + data[i] + '</option>';
                $("#year").append($option);
            }
        },
        error: function (data) {
            console.error("出错了，返回的data：" + data);
        }
    });
});

var mapdata = {
    //数据的基本属性
    "displayFieldName": "",
    "fieldAliases": {
        "FID": "FID",
        "COUNT": "COUNT"
    },
    "geometryType": "esriGeometryPoint",
    "spatialReference": {
        "wkid": 4326,
        "latestWkid": 4326
    },
    //所含有的字段信息
    "fields": [
        {
            "name": "FID",
            "type": "esriFieldTypeOID",
            "alias": "FID"
        },
        {
            "name": "COUNT",
            "type": "esriFieldTypeInteger",
            "alias": "COUNT"
        },
    ],
    //所含有的集合要素集
    "features": []
}

function mapInit(esriBasemaps, Map) {
    esriBasemaps.delorme = {
        baseMapLayers: [
            //中国矢量地图服务
            {url: "http://cache1.arcgisonline.cn/arcgis/rest/services/ChinaOnlineCommunity/MapServer"}
        ],
        //缩略图
        thumbnailUrl: "Imgs/shiliang.jpg",
        title: "矢量图"
    };
    //初始化地图
    map = new Map("map", {
        basemap: "delorme",
        center: [116.46, 39.92],
        zoom: 5,
        logo: false
    });
}

function getMapLayer(esriBasemaps, Map, Color, HeatmapRenderer, FeatureLayer, FeatureSet) {
    var layerDefinition = {
        "geometryType": "esriGeometryPoint",
        "fields": [
            {
                "name": "FID",
                "type": "esriFieldTypeOID",
                "alias": "FID"
            },
            {
                "name": "COUNT",
                "type": "esriFieldTypeInteger",
                "alias": "COUNT"
            },
        ]
    };

    var featureSet = new FeatureSet(mapdata);
    var featureCollection = {
        layerDefinition: layerDefinition,
        featureSet: featureSet
    };
    featurelayer = new FeatureLayer(featureCollection);
    featurelayer.id = "point";

    var heatmaprenderer = new HeatmapRenderer({
        field: "COUNT",
        colors: ["rgba(0, 0, 255, 0)", "rgb(255, 255, 0)", "rgb(255,110 ,0 )", "rgb(255, 0, 0)"],
        blurRadius: 12,
        maxPixelIntensity: 75,
        minPixelIntensity: 1
    });


        if(count!=1){
            map.removeLayer(featurelayer);
        }
        count++;
        featurelayer.setRenderer(heatmaprenderer);
        map.addLayer(featurelayer);


}

require(
    [
        "esri/basemaps",
        "esri/map",
        "esri/Color",
        "esri/renderers/HeatmapRenderer",
        "esri/layers/FeatureLayer",
        "esri/tasks/FeatureSet"
    ],
    function (esriBasemaps, Map, Color, HeatmapRenderer, FeatureLayer, FeatureSet) {
        mapInit(esriBasemaps, Map);
        $('#searchBtn').on('click', function () {

            var year = $('#year option:selected').val();
            var diseaseName = $('#diseaseName option:selected').val();
            var career = $('#career option:selected').val();
            getAddress(diseaseName, year, career);
            setTimeout(function () {
                getMapLayer(esriBasemaps, Map, Color, HeatmapRenderer, FeatureLayer, FeatureSet);
            }, 5000);
        });
    }
);

function getAddress(diseaseName, year, career) {
    $.ajax({
        type: "post",
        url: "../hotMap/selectAddress",
        data: {
            'diseaseName': diseaseName,
            'year': year,
            'career': career
        },
        dataType: "json",
        success:
            function (data) {
                console.log(data);
                mapdata = {
                    //数据的基本属性
                    "displayFieldName": "",
                    "fieldAliases": {
                        "FID": "FID",
                        "COUNT": "COUNT"
                    },
                    "geometryType": "esriGeometryPoint",
                    "spatialReference": {
                        "wkid": 4326,
                        "latestWkid": 4326
                    },
                    //所含有的字段信息
                    "fields": [
                        {
                            "name": "FID",
                            "type": "esriFieldTypeOID",
                            "alias": "FID"
                        },
                        {
                            "name": "COUNT",
                            "type": "esriFieldTypeInteger",
                            "alias": "COUNT"
                        },
                    ],
                    //所含有的集合要素集
                    "features": []
                };
                //遍历并将经纬度存入地图数据
                for (var i = 0; i < data.length; i++) {
                    if (data[i].lng != "" && data[i].lat != "") {
                        var featuresData =
                            {
                                "attributes": {
                                    "FID": parseInt(data[i].addressID),
                                    "COUNT": 3
                                },
                                "geometry": {
                                    "x": parseFloat(data[i].lng),
                                    "y": parseFloat(data[i].lat)
                                }
                            };
                        mapdata.features.push(featuresData);
                    }
                }
                console.log(mapdata.features);
            },
        error: function (data) {
            console.error("出错了，返回的data：" + data);
        }
    });
}