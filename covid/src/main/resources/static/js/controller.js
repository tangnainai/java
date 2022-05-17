
function getTime() {
    $.ajax({
        type: "post",
        url:"/time",
        timeout: 10000,
        success:function(data){
            $("#time").html(data)
        },
        error:function (xhr,type,errorThrown) {
        }
    });

}

function get_c1_data(){
    $.ajax({
        type: "post",
        url: "/c1",
        success:function (data) {
            $(".num h1").eq(0).text(data.confirm);
            $(".num h1").eq(1).text(data.nowConfirm);
            $(".num h1").eq(2).text(data.heal);
            $(".num h1").eq(3).text(data.dead);
        }
    });
}



function get_c2_data() {
    $.ajax({
        type: "post",
        url: "/c2",
        success: function (response) {
            ec_center2_option.series[0].data=response;
            //console.log(response);
           // console.log(ec_center2_option.series[0].data);
            ec_center2.setOption(ec_center2_option);
        }
    });
}

function get_r1_data() {
    $.ajax({
        type: "post",
        url: "/r1",
        success: function (response) {
            console.log(response);
            ec_right1_option.series[0].data[0]=response.currentConfirmedIncr;
            ec_right1_option.series[0].data[1]=response.confirmedIncr;
            // ec_right1_option.xAxis[0].data=response.city;
            // ec_right1_option.series[0].data=response.cityValue;
            ec_right1.setOption(ec_right1_option);
            // console.log(ec_right1_option.xAxis[0].data[1]);
        }
    });
}

function get_r2_data() {
    $.ajax({
        type: "post",
        url: "/r2",
        success: function (response) {
            console.log(response);
            ec_right2_option.series[0].data[0]=response.curedIncr;
            ec_right2_option.series[0].data[1]=response.deadIncr;
            // ec_right1_option.xAxis[0].data=response.city;
            // ec_right1_option.series[0].data=response.cityValue;
            ec_right2.setOption(ec_right2_option);
            // console.log(ec_right1_option.xAxis[0].data[1]);
        }
    });
}
function get_l1_data() {
    $.ajax({
        type: "post",
        url: "/l1",
        success: function (response) {
            console.log(response);
            ec_left1_option.xAxis[0].data=response.dateId;
            ec_left1_option.series[0].data=response.confirmedCount;
            ec_left1_option.series[1].data=response.currentConfirmedCount;
            ec_left1_option.series[2].data=response.curedCount;
            ec_left1_option.series[3].data=response.deadCount;
            ec_left1.setOption(ec_left1_option);
        }
    });
}
function get_l2_data() {
    $.ajax({
        type: "post",
        url: "/l2",
        success: function (response) {
            //  console.log(response);
            ec_left2_option.xAxis[0].data=response.dateId;
            ec_left2_option.series[0].data=response.confirmedIncr;
            ec_left2_option.series[1].data=response.currentConfirmedIncr;
            ec_left2_option.series[2].data=response.curedIncr;
            ec_left2_option.series[3].data=response.deadIncr;
            ec_left2.setOption(ec_left2_option);
        }
    });
}


setInterval(getTime,1000);
setInterval(get_c1_data,1000);
get_l2_data();
get_l1_data();
get_c2_data();
get_r1_data();
get_r2_data();

