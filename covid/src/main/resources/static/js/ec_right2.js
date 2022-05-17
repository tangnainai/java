var ec_right2 = echarts.init(document.querySelector("#r2"), "dark");
var ec_right2_option = {
    title: {
        text: "疫情病人情况",
        textStyle: {
            color: "white",
        },
        left: "left"
    },
    //#ff0000
    color: ["#ff0000"],
    tooltip: {
        trigger: "axis",
        axisPointer: {
            type: "shadow"
        }
    },
    xAxis: [{
        data: ["今日治愈","今日死亡"],
        type: 'category',
    }],
    yAxis: {
        type: "value"
    },
    series: [{
        data: [],
        type: 'bar',
        barMaxWidth: "50%",
        itemStyle:{
            normal:{
                // 没根柱子的颜色
                color:function (params){
                    let colorList =[
                        "#00a35c",
                        "#000000"
                    ];
                    return colorList[params.dataIndex];
                }
            }
        }
    }]
};
ec_right2.setOption(ec_right2_option);
