var Viajes = [];
$("document").ready(function () {
  //  elementos html a imprimir

var viajes = "";
$.ajax({
  url     : "php/simpleO.php",
  async   : false,
  success : function (data){
    Viajes = JSON.parse(data);
    console.log(Viajes);
  }
})

if (Viajes.length%3==0) {
  tarjetas = Viajes.length/3;
}else {
  tarjetas = Math.floor(Viajes.length/3);
  tarjetas++;
}
tarjetas--;


var cuenta = 0;
var eq = 0;

var padre = $("#myCarousel .carousel-inner");
var cont1  = '<div class="item carousel-item  vuelos "><div class="row" id="ContDeals"></div><div>';
$(tarjetas).each(function(index, el) {
  $(padre).append(cont1);
});
for (var i = 0; i < Viajes.length; i++) {
  if (cuenta==3) {
    eq++;
    $("ol.carousel-indicators").append('<li data-target="#myCarousel" data-slide-to="'+eq+'"></li>');
    cuenta=0;
  }
  var obj = '<div class="col-sm-4 "><div class="thumb-wrapper" style="padding-top:10px;"><div class="img-box"><img src="'+Viajes[i]["foto"]+'" class="img-responsive img-fluid" alt></div><div class="thumb-content"><h4 id="">'+Viajes[i]["destino"]+'</h4><p id="" style="height:35%;">'+Viajes[i]["descripcion"]+'<p><a href="'+"deal.php?deal="+Viajes[i]["id"]+'" class="btn btn-primary" class="verMas2">More <i class="fa fa-angle-right"></i></a></div></div></div>';
  $(".vuelos:eq("+eq+") #ContDeals").append(obj);

    cuenta++;
}
// Viajes[i]["price"]

});
function precios(){
  if (!login) {
    $(".precios1").hide();
    $(".precios2").html('<i class="fa fa-question"></i>');
    $(".precios2").show();


  }else {
    $(".precios1").show();
    $(".precios2").hide();

  }
}
