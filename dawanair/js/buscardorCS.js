$("document").ready(function(){
  var clases = "all";
  var precio1 = 0;
  var precio2 = 1000;
  isLoggin();

var stars = 0;

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
    comprovar();
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
        comprovar();
    }
  });


/////
$("#dp").datepicker({
  buttonImage: 'img/calendar.png',
  buttonImageOnly: true,
  showOn: 'both',
  minDate: 0

});

$("#dp").on("change", function() {
   fecha1 = new Date($(this).val());
   $(".mostraF1").text($(this).val() );
   comprovar();
});
$("#dp2").datepicker({
  buttonImage: 'img/calendar.png',
  buttonImageOnly: true,
  showOn: 'both',
  minDate: 0
});
$("#dp2").on("change", function() {
  $(".mostraF2").text( $(this).val() );
  fecha2 = new Date($(this).val());
  comprovar();
});
/////
$("#ida").on("change",function(){
  var isCheck = $(this).get(0).checked;
if (isCheck) {
  ida="true";
}else {
  ida="false";
}
comprovar();
});
$("#idaYvuelta").on("change",function(){
  var isCheck = $(this).get(0).checked;
if (isCheck) {
  idaYvuelta="true";
}else {
  idaYvuelta="false";
}
comprovar();
});
////
$("#SelecClase").on("change",function(){
  clases = $(this).val();
  comprovar();
});
////
$("#Nperso").on("input",function(){
  numP = $(this).val();
  comprovar();
});
$("#origen").autocomplete({
        select: function( event, ui ) {
          origen = ui.item.value;
          comprovar();
          return true;
        }
});
$("#origen").on("change",function(){
  origen = $(this).val();
  comprovar();
});
$("#destino").autocomplete({
        select: function( event, ui ) {
          destino = ui.item.value;
          comprovar();
          return true;
        }
});
$("#destino").on("change",function(){
  destino = $(this).val();
  comprovar();
});
$("#resetFilters").on("click",function(){
  window.location = "Busqueda.html?ida=false&idaYvuelta=false&origen=&destino=&fecha1=&fecha2=&NumP=1";
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
var fecha1 = new Date(getUrlParameter("fecha1"));
var fecha2 = new Date(getUrlParameter("fecha2"));
var numP = getUrlParameter("NumP");


console.log(ida,idaYvuelta,origen,destino,fecha1,fecha2,numP);
if (fecha1=="Invalid Date") {
  fecha1=false;
}else {
}
if (fecha2=="Invalid Date") {
  fecha2=false;
}else {
}

comprovar();

function comprovar(){
  var ViajesAmostrar;
  ViajesAmostrar = destinos(ViajesEnteros);
  ViajesAmostrar = idaYvueltas(ViajesAmostrar);
  ViajesAmostrar = comprovovarFechas(ViajesAmostrar);
  ViajesAmostrar = claseC(ViajesAmostrar,clases);
  ViajesAmostrar = comprovarPersonas(ViajesAmostrar);
  ViajesAmostrar = comprovarEstrellas(ViajesAmostrar);
  ViajesAmostrar = comprovarPrecios(ViajesAmostrar);
  mostar(ViajesAmostrar);
}


function destinos(pasado) {
  var arrayFuncion = [];
  if (destino ==" ") {
    destino="";
  }
  if (origen ==" ") {
    destino="";
  }
  $(pasado).each(function(index,element){
    if (element["city"]==destino && origen==element["origen"]) {
      arrayFuncion.push(element);
    }
  });
  if(destino =="" && origen =="") {
    arrayFuncion = pasado;
  }
  if (arrayFuncion.length < 1 && (destino =="" || origen =="") ){
    $(pasado).each(function(index,element){
      if (element["city"]==destino) {
        arrayFuncion.push(element);
      }
      if (element["origen"]==origen) {
        arrayFuncion.push(element);
      }
    });
  }
  return arrayFuncion;
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
function comprovovarFechas(pasado) {
  if (fecha1) {
    $(".mostraF1").text((fecha1.getMonth()+1)+"/"+fecha1.getDate()+"/"+fecha1.getFullYear());
  }else {
      $(".mostraF1").text("no selected");
  }
  if (fecha2) {
    $(".mostraF2").text((fecha2.getMonth()+1)+"/"+fecha2.getDate()+"/"+fecha2.getFullYear());
  }else {
      $(".mostraF2").text("no selected");
  }
  var arrayFuncion = [];
  $(pasado).each(function(index, el) {
    var dt1 = new Date(el["fecha"]);
    if (fecha1 && fecha2) {
      if (fecha1 <= fecha2) {
        if (fecha1) {
          if (dt1>=fecha1 && dt1 >= new Date() ) {
            arrayFuncion.push(el);
          }
        }
        if (fecha2) {
          if (dt1<=fecha2 ) {
            arrayFuncion.push(el);
          }
        }
      }
    }else {
      if (fecha1) {
        if (dt1>=fecha1 && dt1 >= new Date() ) {
          arrayFuncion.push(el);
        }
      }
      if (fecha2) {
        if (dt1<=fecha2 ) {
          arrayFuncion.push(el);
        }
      }
    }
    if (!fecha1 && !fecha2) {
      arrayFuncion=pasado;
    }
  });
  return arrayFuncion;
}
function comprovarPersonas(pasado) {
    var arrayFuncion = [];
    $("#Nperso").val(numP);
  $(pasado).each(function(index, el) {
    console.log(el["disponibles"],numP);
    console.log(parseInt(el["disponibles"])>=numP);
    console.log("-------");
    if (parseInt(el["disponibles"])>=numP ) {
        arrayFuncion.push(el);
    }
  });
  return arrayFuncion;
}
function comprovarPrecios(pasado) {
    var arrayFuncion = [];
  $(pasado).each(function(index, el) {
    var PrecioA = el["price"].split("€");

    if (PrecioA[0] >= precio1 && PrecioA[0] <= precio2 ) {
        arrayFuncion.push(el);
    }
  });
  return arrayFuncion;
}
function comprovarEstrellas(pasado) {
    var arrayFuncion = [];
    $("#Nperso").val(numP);
  $(pasado).each(function(index, el) {
    if (el["estrellas"] == stars ) {
        arrayFuncion.push(el);
    }
    if (stars==0) {
        arrayFuncion=pasado;
    }
  });
  return arrayFuncion;
}
function claseC(pasado,valor) {
    var arrayFuncion = [];
  $(pasado).each(function(index, el) {
    if (el["clase"] == valor ) {
      arrayFuncion.push(el);
    }
    if (valor=="all") {
        arrayFuncion=pasado;
    }
  });
  return arrayFuncion;
}
function mostar(pasado){

  $(".viaje").remove();
  $("#resultado").text("");
  var no = "<h1>Ningun elemento Encontrado</h1>"
   if (pasado.length < 1) {
     $("#resultado").append(no);
   }
    $(pasado).each(function(index,element){
      var imagesP = '';
      $(element["compa"]).each(function(index,element2){
          if (element2=="ana") {
            imagesP+='<img src="img/ANA.png" alt="">';
          }else if (element2=="ae") {
              imagesP+='<img src="img/aeg.jpg" alt="">';
          }else if (element2=="iberia") {
              imagesP+='<img src="img/ib.png" alt="">';
          }
      });

      var ViajeOb = '<div class="viaje"><div class="row"><div class="col col-md-12">'+
      '<div class="row "><div class="col col-md-3"><div ><h6>Companies</h6></div>'+imagesP+'</div>'+
      '<div class="col col-md-9 "><h2>'+element["origen"]+'--->'+element["city"]+'</h2></div></div></div><div class="col col-md-12"><div class="row">'+
      '<div class="col col-md-3 fecha"><p><i class="fa fa-calendar-o" aria-hidden="true">&nbsp;</i>'+element["fecha"]+'</p><h3>'+element["price"]+''+
      '</h3><p class="desc">(Rate and taxes included, prices in EUR.) Per Passenger.</p></div><div class="col col-md-6 hora">'+
      '<div class="tipo">Type: <strong>'+element["tipo"]+'</strong></div><h5> '+element["salida"]+' — '+element["llegada"]+' | <i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp; Duration: aprox  '+element["duracion"]+'</h5>'+
      '<div>Places available <strong>'+element["disponibles"]+'</strong> | Stars hotel<strong>'+element["estrellas"]+'</strong> | Class <strong>'+element["clase"]+'</strong> </div></div><div class="col col-md-3 verM"><button class="btn btn-primary" type="button" name="button"><a href="deal.html?deal='+element["id"]+' ">show more</a></button></div></div></div></div></div>';

      $("#resultado").append(ViajeOb);

    });
}


});
