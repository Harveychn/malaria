$(document).ready(function () {

    $('.footable').footable();
    $('.footable2').footable();

});

function checkUserAgree(obj) {
    var tr1 = obj.parentNode.parentNode;
    var num = tr1.rowIndex;
    console.log(num);

    var userEmailTemp = document.getElementById("myTable").rows[num].cells[2].innerHTML;
    $.ajax({
        type: "post",
        url: "../user/checkUserAgree/" + userEmailTemp,
        dataType: "json",
        success: function () {
            console.log(userEmailTemp);
            window.open("../user/showCheckUser", "_self");
        }
    })
}

function checkUserReject(obj) {
    var tr1 = obj.parentNode.parentNode;
    var num = tr1.rowIndex;
    console.log(num);
    var userEmailTemp = document.getElementById("myTable").rows[num].cells[2].innerHTML;
    $.ajax({
        type: "post",
        url: "../user/checkUserReject/" + userEmailTemp,
        dataType: "json",
        success: function () {
            console.log("2222222222222222222");
            window.open("../user/showCheckUser", "_self");
        }
    })
}