var Sitios_elegidos="";
  var ide ="";
$("document").ready(function(){
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
  isLoggin();
  if (!login) {
    alert("You are log in before buy");
     history.back();
  }

   ide = getUrlParameter("ide");
  var Deal = getOne(ide);
  var precioPasar =  Deal["precio"];


$("#selectable li").on("click",function(){
  if (!$(this).hasClass("selected")) {
    $(this).toggleClass("seleccionada plaza");
    sitioAvion(precioPasar);
    if ($(this).hasClass("seleccionada")) {
      var localS = Sitios_elegidos;
      console.log(localS);
      Sitios_elegidos+=$(this).data("posicion")+",";
    }else {
      var localS = Sitios_elegidos;
      console.log(localS);
      localS = localS.replace($(this).data("posicion")+",","");
      console.log(localS);
      Sitios_elegidos=localS;
    }
  }else {
    console.log("no");
  }
});



var fila = $("#selectable li");

var but = localStorage.getItem("sillas"+ide);

var butArr = "";
$.ajax({
  url: 'php/asientos.php',
  async : false,
  data: {"id":ide }
})
.done(function(data) {
  butArr=JSON.parse(data);
  console.log(butArr);
})
.fail(function() {
  console.log("error");
})
.always(function() {
  console.log("complete");
});


fila.each(function (){
  var self = $(this);

  $(butArr).each(function(a,b,c){
    console.log(b+" "+$(self).data("posicion"));

    if (b==$(self).data("posicion")) {
        $(self).addClass("selected cogida");
    }
  });
});

});

var sitio = 0;

function sitioAvion(precio){
  console.log(precio);
  $(".elCarrito").find(".addss").remove();
  var precioBueno=precio;
  $(".plaza").each(function(index, el) {
    precio=precioBueno;
    if ($(el).data("posicion")=="Vip 1"||$(el).data("posicion")=="Vip 2"||$(el).data("posicion")=="Vip 3"||$(el).data("posicion")=="Vip 4") {
      var PrecioA = precio.split("€");
      console.log(PrecioA);
      PrecioA[0]= parseInt(PrecioA[0])+70;
      precio=PrecioA.join("")+"€";
    }else {
      precio=precioBueno;
    }

    var sillas_seleccionadas = '  <div class="col col-md-8 addss">place '+$(el).data("posicion")+' </div><div class="col col-md-4 addss"><span>'+precio+'$</span></div>';
    $(".elCarrito").append(sillas_seleccionadas);


  });
}
$("document").ready(function () {
  $(".compraFinalizada").hide();
  $("#confirm").on("click",function (){
    var localS = Sitios_elegidos;
    localS = localS.split(",");
    for (var i = 0; i < localS.length-1; i++) {

      $.ajax({
        url   :"php/comprar.php",
        async : false,
        data  : {
          "pos":localS[i],
          "vuelo":ide
        },
        success : function(data){

          console.log("data");
          console.log(data);

        }
      });
    }

        $(".compraFinalizada").show();
        $(".compraFinalizada").css("transform","translateY(-150px)");
        setTimeout(function(){
          window.location = "index.php";
        }, 3600);

    console.log(localS);
  });
});
