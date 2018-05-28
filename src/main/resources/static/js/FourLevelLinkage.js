$(function () {
    $.ajax({
        type: "get",
        url: "../../district/getProvinces.do",
        dataType: "json",
        success: function (data) {
            // var selPro = data.data[0];
            $.each(data.data, function (i, item) {
                var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                $("#province").append($option);
            });
            // $('#province option[value="' + selPro.name + '"]').attr("selected", "true");
            $('#province option[value="未选"]').attr("selected", "true");
            var cityUrl = "../../district/getCities.do?provinceId=" + selPro.id;
            $.ajax({
                url: cityUrl,
                success: function (data) {
                    var selCity = data.data[0];
                    $.each(data.data, function (i, item) {
                        var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                        $('#city').append($option);
                    });
                    // $('#city option[value="' + selCity.name + '"]').attr("selected", "true");
                    $('#city option[value="未选"]').attr("selected", "true");
                    var countyUrl = "../..//district/getCounties.do?cityId=" + selCity.id;
                    $.ajax({
                        url: countyUrl,
                        success: function (data) {
                            var selCounty = data.data[0];
                            $.each(data.data, function (i, item) {
                                var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                                $('#county').append($option);
                            });
                            // $('#county option[value="' + selCounty.name + '"]').attr("selected", "true");
                            $('#county option[value="未选"]').attr("selected", "true");
                            var villageUrl = "../..//district/getVillages.do?countyId=" + selCounty.id;
                            $.ajax({
                                url: villageUrl,
                                success: function (data) {
                                    $.each(data.data, function (i, item) {
                                        var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                                        $('#village').append($option);
                                    });
                                    $('#village').attr('villageId', $('#village').find('option').eq(0).attr('code'));
                                }
                            })
                        }
                    })
                }
            })
        }
    })
});

$('#province').change(function () {
    var _this = $(this);
    var provinceCode = _this.find('option:selected').attr('code');
    if (undefined != provinceCode) {
        var cityUrl = "../..//district/getCities.do?provinceId=" + provinceCode;
    } else {
        var cityUrl = "../..//district/getCities.do?provinceId=0";
    }
    masterAddrC(cityUrl, 'city');
    setTimeout(function () {
        var cityCode = $('#city').find('option').eq(0).attr('code');
        if (cityCode != undefined) {
            var countyUrl = '../..//district/getCounties.do?cityId=' + cityCode;
        } else {
            var countyUrl = '../..//district/getCounties.do?cityId=0';
        }
        masterAddrC(countyUrl, 'county');
        setTimeout(function () {
            var countyCode = $('#county').find('option').eq(0).attr('code');
            if (undefined != countyCode) {
                var villageUrl = '../..//district/getVillages.do?countyId=' + countyCode;
            } else {
                var villageUrl = '../..//district/getVillages.do?countyId=0';
            }
            masterAddrC(villageUrl, 'village');
            setTimeout(function () {
                $('#province').attr('provinceId', provinceCode);
                $('#city').attr('cityId', $('#city').find().eq(0).attr('code'));
                $('#county').attr('countyId', $('#county').find().eq(0).attr('code'));
                $('#village').attr('villageId', $('#village').find().eq(0).attr('code'));
            }, 300)
        }, 400);
    }, 500);
});

$('#city').change(function () {
    var _this = $(this);
    var cityCode = _this.find('option:selected').attr('code');
    if (cityCode != undefined) {
        var countyUrl = '../..//district/getCounties.do?cityId=' + cityCode;
    } else {
        var countyUrl = '../..//district/getCounties.do?cityId=0';
    }

    masterAddrC(countyUrl, 'county');
    setTimeout(function () {
        var countyCode = $('#county').find('option').eq(0).attr('code');

//            console.log("countyCode:" + countyCode);
        if (undefined != countyCode) {
            var villageUrl = '../..//district/getVillages.do?countyId=' + countyCode;
        } else {
            var villageUrl = '../..//district/getVillages.do?countyId=0';
        }
        masterAddrC(villageUrl, 'village');
        setTimeout(function () {
            $('#city').attr('cityId', cityCode);
            $('#county').attr('countyId', $('#county').find().eq(0).attr('code'));
            $('#village').attr('villageId', $('#village').find().eq(0).attr('code'));
        }, 100)
    }, 200);
});

$('#county').change(function () {
    var _this = $(this);
    var countyCode = _this.find('option:selected').attr('code');

//        console.log("countyCode: " + countyCode);
    if (countyCode != undefined) {
        var villageUrl = '../..//district/getVillages.do?countyId=' + countyCode;
    } else {
        var villageUrl = '../..//district/getVillages.do?countyId=0';
    }
    masterAddrC(villageUrl, 'village');
    setTimeout(function () {
        $('#county').attr('countyId', countyCode);
        $('#village').attr('villageId', $('#village').find().eq(0).attr('code'));
    }, 100)
});

$('#village').change(function () {
    var _this = $(this);
    var villageCode = _this.find('option:selected').attr('code');

    setTimeout(function () {
        $('#village').attr('villageId', villageCode);
    }, 100)
});

function masterAddrC(url, select) {
    $.ajax({
        url: url,
        success: function (data) {
            $('#' + select).html('');
            var $option = '<option>未选</option>';
            $('#' + select).append($option);
            if (null != data.data) {
                $.each(data.data, function (i, item) {
                    var $option = '<option code=' + item.id + ' value=' + item.name + '>' + item.name + '</option>';
                    $('#' + select).append($option);
                });
            }
        },
        error: function () {
            console.log("fail");
        }
    });
}