$("#y-val").on("input", function () {
    let val = parseInt(this.value);
    if (checkY(val)) {
        this.style.background = "rgba(0, 200, 0, 0.7)";
    } else {
        if (isNaN(val)) {
            this.style.background = "rgba(154,148,148,0.43)";
        } else {
            this.style.background = "rgba(200, 0, 0, 0.7)";
        }
    }
});

function checkY(n) {
    return (n >= -5 && n <= 5);
}
function ValidForm(){
    var y = parseFloat($("#y-val").val())
    let x_cor = NaN
    let x_m3 = document.getElementById("x-3");
    let x_m2 = document.getElementById("x-2");
    let x_m1 = document.getElementById("x-1");
    let x_0 = document.getElementById("x0");
    let x_p1 = document.getElementById("x+1");
    let x_p2 = document.getElementById("x+2");
    let x_p3 = document.getElementById("x+3");
    let x_p4 = document.getElementById("x+4");
    let x_p5 = document.getElementById("x+5");
    if (x_m3.checked){
        x_cor = x_m3.value
    }
    if (x_m2.checked){
        x_cor = x_m2.value
    }
    if (x_m1.checked){
        x_cor = x_m1.value
    }
    if (x_0.checked){
        x_cor = x_0.value
    }
    if (x_p1.checked){
        x_cor = x_p1.value
    }
    if (x_p2.checked){
        x_cor = x_p2.value
    }
    if (x_p3.checked){
        x_cor = x_p3.value
    }
    if (x_p4.checked){
        x_cor = x_p4.value
    }
    if (x_p4.checked){
        x_cor = x_p5.value
    }
    return !(isNaN(y) || !checkY(y) || isNaN(x_cor));
}
$("#submit").click(function (){
    if(ValidForm()){
        sendRequest()
    }
})

function sendRequest() {
    let x_m3 = document.getElementById("x-3");
    let x_m2 = document.getElementById("x-2");
    let x_m1 = document.getElementById("x-1");
    let x_0 = document.getElementById("x0");
    let x_p1 = document.getElementById("x+1");
    let x_p2 = document.getElementById("x+2");
    let x_p3 = document.getElementById("x+3");
    let x_p4 = document.getElementById("x+4");
    let x_p5 = document.getElementById("x+5");
    let x_cor = NaN
    if (x_m3.checked){
        x_cor = x_m3.value
    }
    if (x_m2.checked){
        x_cor = x_m2.value
    }
    if (x_m1.checked){
        x_cor = x_m1.value
    }
    if (x_0.checked){
        x_cor = x_0.value
    }
    if (x_p1.checked){
        x_cor = x_p1.value
    }
    if (x_p2.checked){
        x_cor = x_p2.value
    }
    if (x_p3.checked){
        x_cor = x_p3.value
    }
    if (x_p4.checked){
        x_cor = x_p4.value
    }
    if (x_p4.checked){
        x_cor = x_p5.value
    }
    $.ajax({
        url: './area',
        method: 'post',
        dataType: 'json',
        data: {
            x: x_cor,
            y: $("#y-val").val(),
            r: $("#r-val").val()
        },
        success: function (record) {
            window.location.href = record.url;
        }
    })
}
