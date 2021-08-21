
$("document").ready(function(){clases
  var precio1 = 0;
  var precio2 = 1000;
  var ida = "false";
  var idaYvuelta = "false";
  var origen = "";
  var destino = "";
  var fecha1 = "";
  var fecha2 = "";
  var numP = 0;
  var stars = 0;
  var clases  = "all";


  isLoggin();


  $(".checkbox").click(function(){

    if ($(this).attr('src')=="./img/starI.gif") {
      $(this).attr('src',"./img/starNo.png");
      if (stars>=1) {

        stars-=1
      }
    }else if ($(this).attr('src')=="./img/starNo.png") {
      $(this).attr('src',"./img/starI.gif");
        stars+=1;

    }
    filtar();
  });
  //
  $( ".idas input" ).checkboxradio();
  $( "#slid2" ).slider({
    range: true,
    min: 0,
    max: 1000,
    values: [ 25, 800 ],
    create: function(  ) {
      var vals = $( "#slid2" ).slider("values");
      $("#precio1").text(vals[ 0 ]);
      $("#precio2").text(vals[ 1 ]);
    },
    slide: function( event, ui ) {
      $("#precio1").text(ui.values[ 0 ]);
      precio1=ui.values[ 0 ];
      precio2=ui.values[ 1 ];
      $("#precio2").text(ui.values[ 1 ]);
      filtar();

    }
  });


/////
$("#dp").datepicker({
  buttonImage: 'img/calendar.png',
  altFormat: "yy-mm-dd",
  buttonImageOnly: true,
  showOn: 'both',
  minDate: 0

});

$("#dp").on("change", function() {
  console.log("");
   fecha1 = $.datepicker.formatDate('yy-mm-dd', new Date($(this).val()));
   // fecha1 = fecha1.getYear()+"-"+fecha1.getMonth()+"-"+fecha1.getDay();
   console.log(fecha1);
   $(".mostraF1").text(fecha1);
   filtar();
});
$("#dp2").datepicker({
  buttonImage: 'img/calendar.png',
  buttonImageOnly: true,
  showOn: 'both',
  minDate: 0
});
$("#dp2").on("change", function() {
fecha2 = $.datepicker.formatDate('yy-mm-dd', new Date($(this).val()));
$(".mostraF2").text(fecha2);
   filtar();
});
/////
$("#ida").on("change",function(){
  var isCheck = $(this).get(0).checked;
if (isCheck) {
  ida="true";
}else {
  ida="false";
}
filtar();
});
$("#idaYvuelta").on("change",function(){
  var isCheck = $(this).get(0).checked;
if (isCheck) {
  idaYvuelta="true";
}else {
  idaYvuelta="false";
}
filtar();
});
////
$("#SelecClase").on("change",function(){
  clases = $(this).val();
  filtar();
});
////
$("#Nperso").on("input",function(){
  numP = $(this).val();
  filtar();
});
$("#origen").autocomplete({
        select: function( event, ui ) {
          origen = ui.item.value;
          filtar();
          return true;
        }
});
$("#origen").on("change",function(){
  origen = $(this).val();
  filtar();
});
$("#destino").autocomplete({
        select: function( event, ui ) {
          destino = ui.item.value;
          console.log(ui);
          filtar();
          return true;
        }
});
$("#destino").on("change",function(){
  destino = $(this).val();

filtar();
});

$("#resetFilters").on("click",function(){
  window.location = "Busqueda.php?ida=false&idaYvuelta=false&origen=&destino=&fecha1=&fecha2=&NumP=1";
});

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

var ida = getUrlParameter("ida");
var idaYvuelta = getUrlParameter("idaYvuelta");
var origen = getUrlParameter("origen");
var destino = getUrlParameter("destino");
var fecha1 = getUrlParameter("fecha1");
var fecha2 = getUrlParameter("fecha2");
var numP = getUrlParameter("NumP");
$(function(){
  $("#Nperso").val(numP);
});
console.log("TAG",ida,idaYvuelta,origen,destino,fecha1,numP);




$.ajax({
  url  : 'php/busquedaS.php',
  data : {
  "idaYvuelta": idaYvuelta,
  "origen": origen,
  "destino": destino,
  "fecha1": fecha1,
  "fecha2": fecha2,
  "numP": numP,
  "ida": ida
}
})
.done(function(data) {
  console.log(data);
  comprovar(JSON.parse(data));
  console.log(JSON.parse(data));

})
.fail(function(e) {
  console.log(e);
})
.always(function() {
  if (fecha1=="Invalid Date") {
    fecha1=false;
  }else {
  }
  if (fecha2=="Invalid Date") {
    fecha2=false;
  }else {
  }
  console.log("complete");
});
// console.log(precio1,
// precio2,
// ida,
// idaYvuelta,
// origen,
// destino,
// fecha1,
// fecha2,
// numP,
// stars,
// clases);
function filtar(){
$.ajax({
  url  : 'php/filtrar.php',
  data : {
  "precio1": precio1,
  "precio2": precio2,
  "ida": ida,
  "idaYvuelta": idaYvuelta,
  "origen": origen,
  "destino": destino,
  "fecha1": fecha1,
  "fecha2": fecha2,
  "numP": numP,
  "stars": stars,
  "clases"  : clases
}

})
.done(function(data) {
  console.log(data);
  comprovar(JSON.parse(data));
  console.log(JSON.parse(data));

})
.fail(function(e) {
  console.log(e);
})
.always(function() {
  if (fecha1=="Invalid Date") {
    fecha1=false;
  }else {
  }
  if (fecha2=="Invalid Date") {
    fecha2=false;
  }else {
  }
  console.log("complete");
});
}
function comprovar(aaa){
  mostar(aaa);
}




  function idaYvueltas(pasado) {
    var arrayFuncion = [];
  $(pasado).each(function(index,element){
    if (ida=="true" ) {
        $("#ida").get(0).setAttribute("checked","");
        $("#ida").checkboxradio( "refresh" );
      if (element["tipo"]=="One way") {
        arrayFuncion.push(element);
      }
    }
    if (idaYvuelta=="true" ) {
      $("#idaYvuelta").get(0).setAttribute("checked","");
      $("#idaYvuelta").checkboxradio( "refresh" );
      if (element["tipo"]=="round trip") {
        arrayFuncion.push(element);
      }
    }
    if (ida=="false" && idaYvuelta=="false") {
        arrayFuncion.push(element);
    }
  });
  return arrayFuncion;
}








function mostar(pasado){
  console.log(pasado);
  $(".viaje").remove();
  $("#resultado").text("");
  var no = "<h1>Ningun elemento Encontrado</h1>"
   if (pasado.length < 1) {
     $("#resultado").append(no);
   }
    $(pasado).each(function(index,element){
      var imagesP = '';
      $(element["compa"].split(",")).each(function(index,element2){
          if (element2=="ana") {
            imagesP+='<img src="img/ANA.png" alt="">';
          }else if (element2=="ae") {
              imagesP+='<img src="img/aeg.jpg" alt="">';
          }else if (element2=="iberia") {
              imagesP+='<img src="img/ib.png" alt="">';
          }
      });

      var Dur = new Date(element["fecha2"]) - new Date(element["fecha1"]);
      Dur = Dur/1000/60/60;
      Dur = Math.round(Dur, -1);

      var Tip = element["idaYvuelta"];
      if (Tip=="0") {
        Tip="One way";
      }else {
        Tip="Round and trip";
      }
      var ViajeOb = '<div class="viaje"><div class="row"><div class="col col-md-12">'+
      '<div class="row "><div class="col col-md-3"><div ><h6>Companies</h6></div>'+imagesP+'</div>'+
      '<div class="col col-md-9 "><h2>'+element["origen"]+'--->'+element["destino"]+'</h2></div></div></div><div class="col col-md-12"><div class="row">'+
      '<div class="col col-md-3 fecha"><p><i class="fa fa-calendar-o" aria-hidden="true">&nbsp;</i>'+element["fecha1"]+'</p><h3>'+element["precio"]+'$'+
      '</h3><p class="desc">(Rate and taxes included, prices in EUR.) Per Passenger.</p></div><div class="col col-md-6 hora">'+
      '<div class="tipo">Type: <strong>'+Tip+'</strong></div><h5> '+element["fecha1"]+' — '+element["fecha2"]+' | <i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp; Duration: aprox  '+Dur+'hours</h5>'+
      '<div>Places available <strong>'+element["plazas"]+'</strong> | Stars hotel<strong>'+element["estrellas"]+'</strong> | Class <strong>'+element["clase"]+'</strong> </div></div><div class="col col-md-3 verM"><button class="btn btn-primary" type="button" name="button"><a href="deal.php?deal='+element["id"]+' ">show more</a></button></div></div></div></div></div>';

      $("#resultado").append(ViajeOb);
    });
}

});
