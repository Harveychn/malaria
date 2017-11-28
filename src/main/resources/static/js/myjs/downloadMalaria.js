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
    //获取选择的年龄
    var minAge = $('#minAge').val();
    var maxAge = $('#maxAge').val();
    //获取选择的时间
    // var beginYear = $('#start').val();
    var beginYear = $('#beginYear').val();
    // console.log(beginYear);
    // var endYear = $('#end').val();
    var endYear = $('#endYear').val();
    // console.log(endYear);
    //获取选择的性别
    var sex = $('input[type="radio"]:checked').val();
    // console.log(sex);
    //获取选择的地址
    var addsPro = $('#province option:selected').val();
    // console.log(addsPro);
    var addsCity = $('#city option:selected').val();
    // console.log(addsCity);
    var addsCounty = $('#county option:selected').val();
    // console.log(addsCounty);
    var addsVillage = $('#village option:selected').val();
    // console.log(addsVillage);

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
        url: "/DownloadDBData/diseaseParams",
        data: {
            'selectedFields': fields,
            'province': addsPro,
            'city': addsCity,
            'county': addsCounty,
            'village': addsVillage,
            'sex': sex,
            'beginYear': beginYear,
            'endYear': endYear,
            'minAge': minAge,
            'maxAge': maxAge
        },
        type: "post",
        traditional: true,
        success: function (data) {
            console.log("OK :" + data);
            layer.close(loading);
            window.open("/DownloadDBData/downloadExcel", "_self");
        },
        error: function () {
            console.error("'/DownloadDBData/diseaseParams' Error");
            window.open("view/error/500.jsp", "_self");
        }
    });
});
