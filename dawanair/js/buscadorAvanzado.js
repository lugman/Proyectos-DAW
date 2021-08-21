$("document").ready(function(){
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
      $("#precio2").text(ui.values[ 1 ]);
    }
  });
  $(".cal2").datepicker();
  $(".cal1").datepicker();






  $(ViajesEnteros).each(function(index,element){
    var imagesP = '';
    $(element["compa"]).each(function(index,element2){
        if (element2=="ana") {
          imagesP+='<img src="img/ANA.jpg" alt="">';
        }else if (element2=="ae") {
            imagesP+='<img src="img/aeg.jpg" alt="">';
        }else if (element2=="iberia") {
            imagesP+='<img src="img/ib.png" alt="">';
        }
    });

    var ViajeOb = '<div class="viaje"><div class="row"><div class="col col-md-12">'+
    '<div class="row "><div class="col col-md-3"><div ><h6>Compañias</h6></div>'+imagesP+'</div>'+
    '<div class="col col-md-9 "><h2>'+element["origen"]+'--->'+element["city"]+'</h2></div></div></div><div class="col col-md-12"><div class="row">'+
    '<div class="col col-md-3 fecha"><p><i class="fa fa-calendar-o" aria-hidden="true">&nbsp;</i>'+element["fecha"]+'</p><h3>300€'+
    '</h3><p class="desc">(Tarifa e impuestos incluidos. Precios en EUR.) Por Pasajero</p></div><div class="col col-md-6 hora">'+
    '<div class="tipo">Tipo: <strong>'+element["tipo"]+'</strong></div><h5> '+element["salida"]+' — '+element["llegada"]+' | <i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp; Duración: aprox  '+element["duracion"]+'</h5>'+
    '<div>Plazas disponibles <strong>'+element["disponibles"]+'</strong></div></div><div class="col col-md-3 verM"><button class="btn btn-primary" type="button" name="button"><a href="deal.html?deal='+element["id"]+' ">Ver mas</a></button></div></div></div></div></div>';
    $("#resultado").append(ViajeOb);

  });





});
