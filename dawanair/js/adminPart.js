$("document").ready(function(){

  var Compras;
  $.ajax({
    url: 'php/comprasRealizadasT.php',
    async : false
  })
  .done(function(data) {
    Compras=JSON.parse(data);
    console.log(Compras);
  })
  .fail(function() {
    console.log("error");
  })
  .always(function() {
    console.log("complete");
  });
  $(Compras).each(function(index,element){


    // var fecha_Recogida2 = element.fecha1.split(" ");
    // console.log("Fecha1 "+);
    // console.log("Fecha2 "+fecha_Recogida2);
    var fecha_Date =  new Date(element.fecha1.substring(0, 10));
    console.log(element.fecha1.substring(0, 10));
    var month = new Array();
month[0] = "January";
month[1] = "February";
month[2] = "March";
month[3] = "April";
month[4] = "May";
month[5] = "June";
month[6] = "July";
month[7] = "August";
month[8] = "September";
month[9] = "October";
month[10] = "November";
month[11] = "December";
var indice = fecha_Date.getMonth();
console.log(indice);
var n = month[indice];
if (n == undefined) {
  n="  ";
}
var dealHtml="";
console.log(n);
dealHtml+=      '<li>';
dealHtml+=      '  <time>';
dealHtml+=      '    <span class="day">'+fecha_Date.getDay()+'</span>';
dealHtml+=      '    <span class="month">'+n.substring(0,3)+'</span>';
dealHtml+=      '    <span class="year"></span>';
dealHtml+=      '    <span class="time"></span>';
dealHtml+=      '  </time>';
dealHtml+=      ' <img alt="My 24th Birthday!" src="'+element.foto+'" />';
dealHtml+=      '  <div class="info">';
dealHtml+=      '    <h2 class="title"><a href="deal.php?deal='+element.id+'">'+element.nombre+'</a></h2>';
dealHtml+=      '    <p class="desc">'+element.fecha1.substring(10,element.fecha1.length)+" ---> "+element.fecha2.substring(10,element.fecha2.length)+'</p>';
dealHtml+=      '    <ul>';
dealHtml+=      '      <li style="width:50%;"><a><span class="fa fa-key"></span>'+element.id+'</a></li>';
dealHtml+=      '      <li style="width:50%;"><span class="fa fa-money"></span>'+element.precio+'$</li>';
dealHtml+=      '  <a class="btn btn-danger BorrarVuelo" data-id="'+element.id+'">Delete</a>';
dealHtml+=      '  <a class="btn btn-warning ModVuelo" data-id="'+element.id+'">Modify</a>';
dealHtml+=      '    </ul>';
dealHtml+=      '  </div>';
dealHtml+=      '</li>';
dealHtml = $(dealHtml);
$(dealHtml).on('click',".BorrarVuelo", function(event) {
  event.preventDefault();
  var confirmar = confirm("Seguro que desea eliminarlo");
  if (confirmar) {
    BorrarVuelo($(this).data("id"));
  }
});
$(dealHtml).on('click',".ModVuelo", function(event) {
  event.preventDefault();
  var Vuelotraido = getOne($(this).data("id"));
  console.log(Vuelotraido);
  $("#orrigen2").find('option[value="'+Vuelotraido.cod_origen+'"]').attr('selected', 'true');
  $("#desstino2").find('option[value="'+Vuelotraido.cod_destino+'"]').attr('selected', 'true');
  $("#plazasss").attr("value",Vuelotraido.plazas);

  $("#fechaMod").val(Vuelotraido.fecha1.split(" ")[0]);
  $("#horaMod").val(Vuelotraido.fecha1.split(" ")[1]);

  $("#state").find('option[value="'+Vuelotraido.clase+'"]').attr('selected', 'true');
  $("#precioTt").val(Vuelotraido.precio);
  $("#compa").find('option[value="'+Vuelotraido.cod_origen+'"]').attr('selected', 'true');
  $("#Startt").val(Vuelotraido.estrellas);
  $("#textArr").val(Vuelotraido.Descripcion);
  $(".Identficicador").val(Vuelotraido.id);
  $("#imagennn").val(Vuelotraido.foto);

  $(".modalMod").modal("show");

});
$(".ContDealsA").append(dealHtml);

  });
});
