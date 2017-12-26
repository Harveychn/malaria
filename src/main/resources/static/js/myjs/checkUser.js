$(document).ready(function () {

    $('.footable').footable();
    $('.footable2').footable();

});

function checkUserAgree() {
    var userEmailTemp = document.getElementById("userEmail").innerHTML;
    $.ajax({
        type: "post",
        url: "/user/checkUserAgree/" + userEmailTemp,
        dataType: "json",
        success: function () {
            console.log("11111111111111111111111111111111111111111");
            window.open("../user/showCheckUser", "_self");
        }
    })
}

function checkUserReject() {
    var userEmailTemp = document.getElementById("userEmail").innerHTML;
    $.ajax({
        type: "post",
        url: "/user/checkUserReject/" + userEmailTemp,
        dataType: "json",
        success: function () {
            console.log("2222222222222222222");
            window.open("../user/showCheckUser", "_self");
        }
    })
}