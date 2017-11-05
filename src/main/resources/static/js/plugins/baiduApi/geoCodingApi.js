var SAMPLE_ADVANCED_POST = 'http://api.map.baidu.com/geocoder/v2/?ak=您的密钥&callback=renderOption&output=json';
var index = 0;
var count = 0;
var sendCount = 0;
var advancedOptions = '';
var adds = [];
var addsAndCodes = [];
function showOptionsURL() {
    advancedOptions = SAMPLE_ADVANCED_POST;
    advancedOptions += "&address=" + adds[index];
    var safe = advancedOptions;
    // console.log(safe);
};
function doOptions() {
    $.ajax({
        url: "/preDeal/addressToGeoCode.do",
        dataType: "json",
        success: function (data) {
            adds = data;
            console.log("adds.length" + adds.length);
            for (; index < adds.length; index++) {
                var script = document.createElement('script');
                script.type = 'text/javascript';
                showOptionsURL('buttonClick');
                var newURL = advancedOptions.replace('您的密钥', 'fKhoym1WRjv6As8wpebyVtndCGnDWZuU');
                script.src = newURL;
                document.body.appendChild(script);
            }
        },
        error: function () {
            console.log("ERROR Happened !");
        }
    });
};
//百度GeoCoding API回调函数
function renderOption(response) {
    if (response.status) {
        console.log(index + "无正确的返回结果");
    } else if (302 == response.status) {
        console.log("当天配额用完");
    } else {
        var result = response.result;
        var location = response.result.location;
        addsAndCodes.push({
            "address": adds[count],
            "lat": location.lat,
            "lng": location.lng,
            "precise": result.precise,
            "confidence": result.confidence,
            "level": result.level
        });
        sendCount++;
    }
    count++;
    // console.log("count : " + count);
    if (50 == sendCount) {
        var jsonStyle = JSON.stringify(addsAndCodes);
        $.ajax({
            url: "/preDeal/addsAndCodes.do",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            data: jsonStyle,
            type: "post",
            success: function (data) {
                console.log("后台接收到了 " + eval(data) + " 条记录");
            },
            error: function (data) {
                console.log("出错了！")
            }
        });
        addsAndCodes = [];
        sendCount = 0;
    }
}