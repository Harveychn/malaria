$(function (ec) {
    // 基于准备好的dom，初始化echarts图表
    var province1ChartTab_1 = ec.init(document.getElementById('province1ChartTab_1'));
    var province1ChartTab_2 = ec.init(document.getElementById('province1ChartTab_2'));
    var province2ChartTab_1 = ec.init(document.getElementById('province2ChartTab_1'));
    var province2ChartTab_2 = ec.init(document.getElementById('province2ChartTab_2'));
    var province3ChartTab_1 = ec.init(document.getElementById('province3ChartTab_1'));
    var province3ChartTab_2 = ec.init(document.getElementById('province3ChartTab_2'));

    var initOption = initChartOption();
    province1ChartTab_1.setOption(initOption);
    province1ChartTab_2.setOption(initOption);
    province2ChartTab_1.setOption(initOption);
    province2ChartTab_2.setOption(initOption);
    province3ChartTab_1.setOption(initOption);
    province3ChartTab_2.setOption(initOption);

    //初始化时加载
    $(function () {
        var dataSource = $('#dataSource').val();
        forecastAjaxFunction(dataSource, province1ChartTab_1, province1ChartTab_2);
        forecastAjaxFunction(dataSource, province2ChartTab_1, province2ChartTab_2);
        forecastAjaxFunction(dataSource, province3ChartTab_1, province3ChartTab_2);
    });
    //点击查询按钮,使用刚指定的配置项和数据显示图表。
    $('#searchBtn').on('click', function () {
        province1ChartTab_1.clear();
        province1ChartTab_2.clear();
        province2ChartTab_1.clear();
        province2ChartTab_2.clear();
        province3ChartTab_1.clear();
        province3ChartTab_2.clear();

        province1ChartTab_1.setOption(initOption);
        province1ChartTab_2.setOption(initOption);
        province2ChartTab_1.setOption(initOption);
        province2ChartTab_2.setOption(initOption);
        province3ChartTab_1.setOption(initOption);
        province3ChartTab_2.setOption(initOption);
        var dataSource = $('#dataSource').val();
        console.info(dataSource);
        forecastAjaxFunction(dataSource, province1ChartTab_1, province1ChartTab_2);
        forecastAjaxFunction(dataSource, province2ChartTab_1, province2ChartTab_2);
        forecastAjaxFunction(dataSource, province3ChartTab_1, province3ChartTab_2);
    });
});

function initChartOption() {
    return {
        title: {
            text: 'Forecast',
            x: 'Year',
            y: 'Patient Number'
        },
        tooltip: {
            formatter: '{c}'
        },
        xAxis: [{
            gridIndex: 0,
            min: 2005,
            max: 2016
        }],
        yAxis: [{
            gridIndex: 0,
            min: -1000,
            max: 10000
        }],
        series: [
            {
                name: 'I',
                type: 'scatter',
                xAxisIndex: 0,
                yAxisIndex: 0,
                data: ['dynamic data'],
                markLine: ['dynamic data']
            }
        ]
    };
}

function forecastAjaxFunction(dataSource, provinceChartTab_1, provinceChartTab_2) {
    $.ajax({
        type: "post",
        url: "../forecast/forecastChart",
        data: {
            dataSource: dataSource
        },
        dataType: "json",
        success: function (data) {

        },
        error: function (data) {
            console.error(data);
        }
    });
}
