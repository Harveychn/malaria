var map;
//获取后台年份数据
$(function(){
    $.ajax({
        type:"get",
        url:"",
        dataType:"json",
        success: function (data) {
            $.each(data.data, function (i, item) {
                var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                $("#year").append($option);
            });
        },
        error: function (data) {
            console.error("出错了，返回的data：" + data);
        }
    })
})
//得到三个筛选值
$(document).ready(function(){
    $("#searchBtn").click(function(){
        var disease = $("#diseaseKind").val();
        var work = $("#workKind").val();
        var year = $("#year").val();
        showmap();
    })
})

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
    }
    //后端点数据传入
    $.ajax({
        type: "post",
        url: "",
        dataType: "json",
        success: function (data) {
            mapdata = mapdata + data;
        },
        error: function (data) {
            console.error("出错了，返回的data：" + data);
        }
    });
  
require([

    "esri/basemaps",
    "esri/map", 
    "esri/Color",
    "esri/renderers/HeatmapRenderer",
    "esri/layers/FeatureLayer",
    "esri/tasks/FeatureSet"
    ], function(esriBasemaps,Map,Color,HeatmapRenderer,FeatureLayer,FeatureSet) {  
            
        esriBasemaps.delorme = {
            baseMapLayers: [
                //中国矢量地图服务
                { url: "http://cache1.arcgisonline.cn/arcgis/rest/services/ChinaOnlineCommunity/MapServer" }
            ],
                //缩略图
            thumbnailUrl: "Imgs/shiliang.jpg",
            title: "矢量图"
        };
        //初始化地图
        map = new Map("map" ,{
            basemap: "delorme",
            center: [120.3420918, 30.3151956],
            zoom: 15,
            logo:false
        });


        // var data = {
        //     //数据的基本属性  
        //     "displayFieldName": "",
        //     "fieldAliases": {
        //         "FID": "FID",
        //         "COUNT": "COUNT"
        //     },
        //     "geometryType": "esriGeometryPoint",
        //     "spatialReference": {
        //         "wkid": 4326,
        //         "latestWkid": 4326
        //     },
        //     //所含有的字段信息  
        //     "fields": [
        //         {
        //             "name": "FID",
        //             "type": "esriFieldTypeOID",
        //             "alias": "FID"
        //         },
        //         {
        //             "name": "COUNT",
        //             "type": "esriFieldTypeInteger",
        //             "alias": "COUNT"
        //         },
        //     ],
        //     //所含有的集合要素集  
        //     "features": [
        //         {
        //             "attributes": {
        //                 "FID": 2,
        //                 "COUNT": 1
        //             },
        //             "geometry": {
        //                 "x": 120.3420918,
        //                 "y": 30.3151956
        //             }
        //         },
        //         {
        //             "attributes": {
        //                 "FID": 10,
        //                 "COUNT": 10
        //             },
        //             "geometry": {
        //                 "x": 120.3420,
        //                 "y": 30.315
        //             }
        //         },
        //         {
        //             "attributes": {
        //                 "FID": 30,
        //                 "COUNT": 1
        //             },
        //             "geometry": {
        //                 "x": 120.34,
        //                 "y": 31.3
        //             }
        //         }
        //     ]
        // }

        var layerDefinition = {  
            "geometryType": "esriGeometryPoint",  
            "fields":[  
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

        var featureSet = new FeatureSet(data);  
        var featureCollection = {  
            layerDefinition: layerDefinition,  
            featureSet: featureSet  
        };  
        var featurelayer = new FeatureLayer(featureCollection);

        var heatmaprenderer = new HeatmapRenderer({
                field:"COUNT",
                colors:["rgba(0, 0, 255, 0)","rgb(255, 255, 0)","rgb(255,110 ,0 )", "rgb(255, 0, 0)"],
                blurRadius:12,
                maxPixelIntensity: 75,
                minPixelIntensity: 1
            });
        
        map.on("load",function()
            {
                featurelayer.setRenderer(heatmaprenderer);
                map.addLayer(featurelayer);
            }
        )    
    }
);  