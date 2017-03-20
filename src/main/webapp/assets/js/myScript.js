/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 */
$("#btnSubmit").click(function (e) {
    e.preventDefault();
    var priceVal = $("#price").val();
    var nameVal = $("#name").val();
    var descriptionVal = $("#description").val();
    if (!isNumber(priceVal)) {
        $("#errPrice").text("price is number");
    }
    if (isEmptys(nameVal)) {
        $("#errName").text("name is not empty");
    }
    if (isEmptys(priceVal)) {
        $("#errPrice").text("price is not empty");
    }
    if (isEmptys(descriptionVal)) {
        $("#errDescription").text("description in not empty");
    }
});

function isNumber(strNumber) {
    return !isNaN(strNumber);
}

function isEmptys(str) {
    if (str == "")
        return true;
}
