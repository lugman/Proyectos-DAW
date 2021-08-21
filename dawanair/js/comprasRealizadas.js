$("document").ready(function(){
  var Compras;
  isLoggin();
  if (!login) {
    alert("You are log in");
     history.back();
  }
  $.ajax({
    url: 'php/comprasRealizadas.php',
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
    // console.log(element.fecha);
    var fecha_Recogida = element.fecha.split(" ");
    var fecha_Date =  new Date(fecha_Recogida[0]);
    console.log(fecha_Date);
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
var n = month[fecha_Date.getMonth()];
var dealHtml="";
dealHtml+=      '<li>';
dealHtml+=      '  <time>';
dealHtml+=      '    <span class="day">'+fecha_Date.getUTCDate()+'</span>';
dealHtml+=      '    <span class="month">'+n.substring(0, 3)+'</span>';
dealHtml+=      '    <span class="year"></span>';
dealHtml+=      '    <span class="time"></span>';
dealHtml+=      '  </time>';
dealHtml+=      ' <img alt="My 24th Birthday!" src="'+element.foto+'" />';
dealHtml+=      '  <div class="info">';
dealHtml+=      '    <h2 class="title"><a href="deal.php?deal='+element.id_vuelo+'">'+element.nombre+'</a></h2>';
dealHtml+=      '    <p class="desc">Fecha comp:'+fecha_Recogida[0]+"<br>hora:"+fecha_Recogida[1]+'</p>';
dealHtml+=      '    <ul>';
dealHtml+=      '      <li style="width:50%;"><a><img style="width:15px;" src="https://cdn3.iconfinder.com/data/icons/glyph/227/Chair_1-128.png"/>'+element.posicion+'</a></li>';
dealHtml+=      '      <li style="width:50%;"><span class="fa fa-money"></span>'+element.precio+'$</li>';
dealHtml+=      '    </ul>';
dealHtml+=      '  </div>';
dealHtml+=      '</li>';
dealHtml = $(dealHtml);
$(".ContDeals").append(dealHtml);

  });
});
