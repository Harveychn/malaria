$(function () {
    $.ajax({
        type: "get",
        url: "../cluster/getAllYear",
        dataType: "json",
        success: function (data) {
            alert(data);
            for (var i = 0; i < data.length; i++) {
                var $option = '<option>' + item.name + '</option>';
                $("#year").append($option);
            }
        },
        error: function (data) {
            console.error("出错了，返回的data：" + data);
        }
    });
});
$('#submitTerm').on('click', function (event) {
    var year = $('#year option:selected').val();
    var attribute = $('#attribute option:selected').val();
    var diseaseName = $('#diseaseName option:selected').val();

    $(function () {
        $.ajax({
            type: "post",
            url: "../cluster/kMeans",
            data: {
                'diseaseName': diseaseName,
                'year': year,
                'attribute': attribute
            },
            dataType: "json",
            success:
                function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var color = ["#fff004", "#ff0000", "#ff9949"];
                        for (var j = 0; j < data[i].length; j++) {
                            getBoundary(provinces[i][j], color[i]);
                        }
                    }
                },
            error: function (data) {
                console.error("出错了，返回的data：" + data);
            }
        })
        ;
    });

});

var map = new BMap.Map("allmap");
map.centerAndZoom(new BMap.Point(116.403765, 39.914850), 5);
map.enableScrollWheelZoom();


function getBoundary(province, color) {
    var bdary = new BMap.Boundary();
    bdary.get(province, function (rs) {       //获取行政区域
        var count = rs.boundaries.length; //行政区域的点有多少个
        if (count === 0) {
            alert('未能获取当前输入行政区域');
            return;
        }
        for (var i = 0; i < count; i++) {
            var ply = new BMap.Polygon(rs.boundaries[i], {
                    strokeWeight: 2,
                    strokeColor: "#ff9949",
                    fillColor: color
                })
            ; //建立多边形覆盖物
            plys[i] = ply;
            map.addOverlay(ply);  //添加覆盖物
        }
    });
};
