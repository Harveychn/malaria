$('#needAll').on('click', function (event) {
    $('input#fields').iCheck('check');
});
$('#needNon').on('click', function (event) {
    $('input#fields').iCheck('uncheck');
});
$('#submitTerm').on('click', function (event) {
    var loading = layer.load(0, {
        shade:[0.8,'white']
    });
    //获取选择的时间
    // // var beginYear = $('#start').val();
    // var beginYear = $('#beginYear').val();
    // console.log(beginYear);
    // var endYear = $('#end').val();
    // var endYear = $('#endYear').val();
    // console.log(endYear);
    //获取选择的地址
    // var addsPro = $('#province option:selected').val();
    // var addsCity = $('#city option:selected').val();
    // var addsCounty = $('#county option:selected').val();
    // var addsVillage = $('#village option:selected').val();

    //获取选择的字段
    var fields = [];
    $('input#fields').each(function () {
        if (true == $(this).is(':checked')) {
            var fd = $(this).val();
            fields.push(fd);
        }
    });
    if (null == fields) {
        alert("请选择要下载的数据字段");
        return;
    }
    $.ajax({
        url: "stationParams.do",
        data: {
            'selectedFields': fields
            // 'province': addsPro,
            // 'city': addsCity,
            // 'county': addsCounty,
            // 'village': addsVillage,
            // 'beginYear': beginYear,
            // 'endYear': endYear
        },
        type: "post",
        traditional: true,
        success: function (data) {
            console.log("OK :" + data);
            layer.close(loading);
            window.open("downloadExcel", "_self");
        },
        error: function () {
            console.error("访问服务器'/DownloadDBData/stationParams.do' Error");
            window.open("/error/500.jsp", "_self");
        }
    });
});

$(document).ready(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
    });