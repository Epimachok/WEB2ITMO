const canvas = document.getElementById("area")
const ctx = canvas.getContext("2d");
const height = canvas.height
const width = canvas.width
var x_cord = NaN
var y_cord = NaN
var r_cord = NaN
var Hits = []
function setX(x){x_cord=x}
function setY(y){y_cord=y}
function setR(r){r_cord=r}
function getR(){
    return $("#r-val").val()
}
$(function () {
    setR(getR())
    if (localStorage.hit){
        let hit = JSON.parse( localStorage.hit )
        Hits = hit.hits
    }
    draw()
    for (var i =0;i<Hits.length;i+=1){
        drawHit(Hits[i][0],Hits[i][1],true)
    }
})
$("#r-val").click(function (){
    var r = getR();
    setR(r)
    draw()
    for (var i =0;i<Hits.length;i+=1){
        drawHit(Hits[i][0],Hits[i][1],true)
    }
})
function draw(){
    ctx.fillStyle = "rgba(255, 255, 255, 1)"
    ctx.fillRect(0, 0, width, height)

    //draw figures
    ctx.strokeStyle = "rgba(30,107,195,0.9)"
    ctx.fillStyle = "rgba(73,158,255,0.9)"
    drawTriangle(width*0.75, height/2, width/2, height/2, width/2, height)
    ctx.stroke()
    drawRectangle(width/2, height/2, 0, height/2, 0, height * 0.75, width/2, height * 0.75)
    ctx.stroke()
    ctx.arc(width/2, height/2, height/2, -Math.PI/2, Math.PI, true)
    ctx.stroke()
    ctx.fill()

    //draw axis
    ctx.strokeStyle = "rgba(0, 0, 0, 1)"
    ctx.lineWidth = 2
    drawLine(width/2, 0, width/2, height)
    drawLine(0, height/2, width, height/2)

    //draw axis keys
    ctx.fillStyle = "rgba(0, 0, 0, 1)"
    const off = 5
    drawTriangle(width/2, 0, width/2 + off, off, width/2 - off, off)
    drawTriangle(width, height/2, width - off, height/2 + off, width - off, height/2 - off)

    //draw axis
    ctx.fillText("R", width/2 + 5, 15)
    ctx.fillText("R", width - 17, height/2 + 15)
}
function drawLine(x1, y1, x2, y2) {
    ctx.beginPath()
    ctx.moveTo(x1, y1)
    ctx.lineTo(x2, y2)
    ctx.stroke()
}

function drawTriangle(x1, y1, x2, y2, x3, y3) {
    ctx.beginPath()
    ctx.moveTo(x1, y1)
    ctx.lineTo(x2, y2)
    ctx.lineTo(x3, y3)
    ctx.lineTo(x1, y1)
    ctx.fill()
}
function drawRectangle(x1, y1, x2, y2, x3, y3, x4, y4) {
    ctx.beginPath()
    ctx.moveTo(x1, y1)
    ctx.lineTo(x2, y2)
    ctx.lineTo(x3, y3)
    ctx.lineTo(x4, y4)
    ctx.lineTo(x1, y1)
    ctx.fill()
}
$("#area").click(function (event) {
    if (isNaN(getR())) {
        show_message()
    }
    else {
        const rect = canvas.getBoundingClientRect()
        const x = event.clientX - rect.left
        const y = event.clientY - rect.top
        const r = getR()
        setX((x / width * 2 * r) - r)
        setY(-((y / height * 2 * r) - r))
        setR(r)
        sendRequest()
    }
})

function drawHit(x, y, transfrom ) {
    ctx.beginPath()
    ctx.strokeStyle = "rgba(0, 0, 0, 1)"
    ctx.fillStyle = "rgba(0, 0, 0, 1)"
    const x1 = transfrom?(x/r_cord*width/2+width/2):x
    const y1 = transfrom?height-(y/r_cord*height/2+height/2):y
    ctx.moveTo(x1, y1)
    ctx.arc(x1, y1, 2, 0, 2*Math.PI)
    ctx.fill()
    ctx.stroke()
}
function sendRequest() {
        $.ajax({
            url: './area',
            method: 'post',
            dataType: 'json',
            data: {
                x: x_cord,
                y: y_cord,
                r: r_cord
            },
            success: function (record) {
                Hits.push([x_cord,y_cord])
                localStorage.hit = JSON.stringify({hits: Hits});
                drawHit(x_cord,y_cord,true)
                window.location.href = record.url;
                //window.open(record.url).focus();
            }
        })
    return true
}
function show_message() {
    const msg = document.createElement("div")
    msg.appendChild(document.createTextNode("НЕПРАВИЛЬНО"))
    msg.classList.add("message")
    document.body.appendChild(msg)
    setTimeout(() => {  msg.remove(); }, 5000);
}