$("document",).ready(function(){
  // With JQuery
  var datemin = 0 ;
    $( "#checkbox-1,#checkbox-2" ).checkboxradio();
      // $( "#slider-range" ).slider({
      //   range: true,
      //   min: 0,
      //   max: 1000,
      //   values: [ 25, 800 ],
      //   create: function(  ) {
      //     var vals = $( "#slider-range" ).slider("values");
      //     $("#desde").text(vals[ 0 ]+"€");
      //     $("#hasta").text(vals[ 1 ]+"€");
      //   },
      //   slide: function( event, ui ) {
      //     $("#desde").text(ui.values[ 0 ]+"€");
      //     $("#hasta").text(ui.values[ 1 ]+"€");
      //   }
      // });
      $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
        " - $" + $( "#slider-range" ).slider( "values", 1 ) );
    var countries = ["Moscow","Hawai","Milan","France","Dubai","Giza","Sydney","Grecia"];
    var countries1 = ["Valencia(Spain)","Barcelona(Spain)","Madrid(Spain)"];
    var Ccities = CitiesR();
    var Cci = [];
    $(Ccities).each(function(index, el) {
        Cci.push(el.Nombre);
    });
    console.log(Cci);
    $( ".country1" ).autocomplete({
          source: Cci
      });
    $( ".country" ).autocomplete({
          source: Cci
      });
    $('#date1').datepicker( {
      minDate: 0
    });



    $('#date2').datepicker({
      minDate: datemin
    });

    var contBuscar = $("#contenedorBuscar");

    var ida = $(contBuscar).find("#checkbox-1");
    var idaYvuelta = $(contBuscar).find("#checkbox-2");
    var origen = $(contBuscar).find("#origen");
    var destino = $(contBuscar).find("#destino");
    var fecha1 = $(contBuscar).find("#date1");
    var fecha2 = $(contBuscar).find("#date2");
    var numP = $(contBuscar).find("#numeroP");


    $("#buscar").on("click",function(){
      console.log("Ida",ida.get(0).checked);
      console.log("idaYvuelta",idaYvuelta.get(0).checked);
      console.log("origen",origen.val());
      console.log("destino",destino.val());
      console.log("fecha1",fecha1.val());
      console.log("fecha2",fecha2.val());
      console.log("numP",numP.val());
      var fech1=fecha1.val();
      if (fech1=="") {
        fech1="";
      }else {
        fech1 = $.datepicker.formatDate('yy-mm-dd', new Date(fecha1.val()));
      }
      var fech2=fecha2.val();
      if (fech2=="") {
        fech2="";
      }else {
        fech2 = $.datepicker.formatDate('yy-mm-dd', new Date(fecha2.val()));
      }
       // window.location=Busqueda.html?+ida="+ida.get(0).checked+"&idaYvuelta="+idaYvuelta.get(0).checked+"&origen="+origen.val()+"&destino="+destino.val()+"&fecha1="+fecha1.val()+"&fecha2="+fecha2.val()+"&NumP="+numP.val();
        window.location="Busqueda.php?ida="+ida.get(0).checked+"&idaYvuelta="+idaYvuelta.get(0).checked+"&origen="+origen.val()+"&destino="+destino.val()+"&fecha1="+fech1+"&fecha2="+fech2+"&NumP="+numP.val();
    });



} );
