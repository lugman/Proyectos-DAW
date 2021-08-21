$("document").ready(function () {
  var getUrlParameter = function getUrlParameter(sParam) {
  var sPageURL = decodeURIComponent(window.location.search.substring(1)),
      sURLVariables = sPageURL.split('&'),
      sParameterName,
      i;
  for (i = 0; i < sURLVariables.length; i++) {
      sParameterName = sURLVariables[i].split('=');
      if (sParameterName[0] === sParam) {
          return sParameterName[1] === undefined ? true : sParameterName[1];
      }
  }
};
var parameter = getUrlParameter("deal");

var deal = getOne(parameter);

$("#Reservame").click(function(){
  window.location = "comprar.php"+"?ide="+deal["id"];
});

$(".Tit").text(deal["destino"]);

$(".desc").text(deal["Descripcion"]);
$("#price").text(deal["Precio"]);
console.log(deal);
// $("#temp").text(deal["temperatura"]);
var Dur = new Date(deal["fecha2"]) - new Date(deal["fecha1"]);
Dur = Dur/1000/60/60;
Dur = Math.round(Dur, -1);
var dur = new Date(deal.Fecha_salida) - new Date(deal.Fecha_llegada);

$("#ClaseObj").text("Class: "+deal["clase"]);
$("#Hora1Obj").text("Departure time: "+deal["fecha1"]);
$("#Hora2Obj").text("Arrival time:"+deal["fecha2"]);
var estr = deal["estrellas"];
console.log(estr);
var imgS = '<img src="img/star.ico" alt="">';
var imgS2 = '<img src="img/no-star.png" alt="">';
for (var i = 0; i < 5; i++) {
  if (i<estr) {
    $(".stars").append(imgS);
  }else {
    $(".stars").append(imgS2);
  }
}
$(".imgPrincipal").attr("src",deal["foto"]);
});
