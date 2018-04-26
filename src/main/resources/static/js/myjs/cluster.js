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

$('#submitTerm').on('click', function (event) {
    var year = $('#year option:selected').val();
    var attribute = $('#attribute option:selected').val();
    var diseaseName = $('#diseaseName option:selected').val();


    var map = new BMap.Map("allMap");
    map.centerAndZoom(new BMap.Point(116.403765, 39.914850), 5);
    map.enableScrollWheelZoom();

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
                        var color = ["#8EE5EE", "#CDAD00", "#FF7F00","#BF3EFF"];
                        console.log(data[i]);
                        for (var j = 0; j < data[i].length; j++) {
                            getBoundary(data[i][j].province, color[i]);
                        }
                    }

                },
            error: function (data) {
                console.error("出错了，返回的data：" + data);
            }
        });
    });


    function getBoundary(province, color) {
        var bdary = new BMap.Boundary();
        bdary.get(province, function (rs) {       //获取行政区域
            var count = rs.boundaries.length; //行政区域的点有多少个
            if (count === 0) {
                // alert('未能获取当前输入行政区域');
                return;
            }
            for (var i = 0; i < count; i++) {
                var ply = new BMap.Polygon(rs.boundaries[i], {
                    strokeWeight: 2,
                    strokeColor: "#ff9949",
                    fillColor: color
                }); //建立多边形覆盖物
                map.addOverlay(ply);  //添加覆盖物
            }
        });
    };
});
