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
            show: true,
            data: ["现存确诊变化","昨日新增","较昨日治愈","较昨日死亡"],
            type: 'category',
            axisLabel:{
                interval:0,//横轴信息全部显示
            },

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
                            "#ff0000",
                            "#ff0000",
                            "#00a35c",
                            "#000000"
                        ];
                        return colorList[params.dataIndex];
                    }
                }
            }
        }]
    };
    ec_right1.setOption(ec_right1_option);
