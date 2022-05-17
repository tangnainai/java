var ec_right1 = echarts.init(document.querySelector("#r1"), "dark");
    var ec_right1_option = {
        title: {
            text: "疫情人数变化",
            textStyle: {
                color: "white",
            },
            left: "left"
        },
        color: ["#ff0000"],
        tooltip: {
            trigger: "axis",
            axisPointer: {
                type: "shadow"
            }
        },
        xAxis: [{
            data: ["现存确诊变化","昨日新增"],
            type: 'category',
        }],
        yAxis: {
            type: "value"
        },
        series: [{
            data: [],
            type: 'bar',
            barMaxWidth: "50%"
        }]
    };
    ec_right1.setOption(ec_right1_option);
