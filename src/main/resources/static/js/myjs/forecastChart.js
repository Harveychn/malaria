$(function () {
    // 基于准备好的dom，初始化echarts图表
    var province1ChartTab_1 = echarts.init(document.getElementById('province1ChartTab_1'));
    var province1ChartTab_2 = echarts.init(document.getElementById('province1ChartTab_2'));

    var initOption = initChartOption();
    province1ChartTab_1.setOption(initOption);
    province1ChartTab_2.setOption(initOption);

    //初始化时加载
    $(function () {
        var dataSource = $('#dataSource').val();
        forecastAjaxFunction(dataSource, province1ChartTab_1, province1ChartTab_2);
    });
    //点击查询按钮,使用刚指定的配置项和数据显示图表。
    $('#searchBtn').on('click', function () {
        province1ChartTab_1.clear();
        province1ChartTab_2.clear();

        province1ChartTab_1.setOption(initOption);
        province1ChartTab_2.setOption(initOption);
        var dataSource = $('#dataSource').val();
        console.info(dataSource);
        forecastAjaxFunction(dataSource, province1ChartTab_1, province1ChartTab_2);
    });
});

function markLineOption() {
    return {
        animation: false,
        label: {
            normal: {
                formatter: 'y = 0.5 * x + 3',
                textStyle: {
                    align: 'right'
                }
            }
        },
        lineStyle: {
            normal: {
                type: 'solid'
            }
        },
        tooltip: {
            formatter: 'y = 0.5 * x + 3'
        },
        data: ['dynamic data']
    }
}


function initChartOption() {
    return {
        title: {
            text: '',
            x: 'Year',
            y: 'Patient Number'
        },
        tooltip: {
            formatter: '{c}'
        },
        xAxis: [{
            gridIndex: 0,
            min: 2005,
            max: 2017
        }],
        yAxis: [{
            gridIndex: 0,
            min: -30000,
            max: 30000
        }],
        series: [
            {
                symbolSize:8,
                type: 'scatter',
                xAxisIndex: 0,
                yAxisIndex: 0,
                data: 'dynamic data',
                markLine: 'dynamic data'
            }
        ]
    }
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
            var dataSet = data.dataSet;
            console.log(dataSet);
            var theta = data.theta;
            console.log(theta);
            var forecastDataSet = data.forecastDataSet;
            console.log(forecastDataSet);
            for (var i = 0; i < 2; i++) {
                var equation = 'y = ' + theta[i][0] + '* x ' + theta[i][1];
                var markLineOpt = markLineOption();
                markLineOpt.label.normal.formatter = equation;
                markLineOpt.tooltip.formatter = equation;
                console.log(forecastDataSet[i][0]);
                console.log(forecastDataSet[i][forecastDataSet[i].length - 1]);

                var temp = [[{
                    coord: forecastDataSet[i][0],
                    symbol: 'none'
                }, {
                    coord: forecastDataSet[i][forecastDataSet[i].length - 1],
                    symbol: 'none'
                }]];

                markLineOpt.data = temp;

                var eChartsOption = initChartOption();
                forecastDataSet[i].push.apply(forecastDataSet[i], dataSet[i]);
                eChartsOption.series[0].markLine = markLineOpt;
                eChartsOption.series[0].data = forecastDataSet[i];

                if (i == 0) {
                    eChartsOption.title.text = "间日疟";
                    provinceChartTab_1.setOption(eChartsOption);
                }
                else if (i == 1) {
                    eChartsOption.title.text = "恶性疟";
                    provinceChartTab_2.setOption(eChartsOption);
                }
            }

        },
        error: function (data) {
            console.error(data);
        }
    });
}
