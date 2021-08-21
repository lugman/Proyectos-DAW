
// Ready function
$("document").ready(function() {
  $("#confirm").on('click',function() {
    if ($('.addss').length > 0) {

  }else {
    if($('.noT').length == 0)
    $('<p class="red noT">No tiene nada</p>').insertAfter(this);
  }
  });

  $("#CrearVuelo").on('click', function(event) {
    event.preventDefault();
    $(".modalCrear").modal("show");
  });
  $(".CrearDeal").on('click', function(event) {
    event.preventDefault();
    /* Act on the event */

    $.ajax({
      url: 'php/vueloNuevo.php',
      type: 'POST',
      data: $(".formCre").serialize(),
    })
    .done(function(data) {
      console.log(data);
      $(".modalCrear").modal("hide");
    })
    .fail(function() {
      console.log("error");
    })
    .always(function() {
      console.log("complete");
    });


  });    //Click Registarse via Email
  $(".EditarDeal").on('click', function(event) {
    event.preventDefault();
    /* Act on the event */

    $.ajax({
      url: 'php/modificarVuelo.php',
      type: 'POST',
      data: $(".formMod").serialize(),
    })
    .done(function(data) {
      console.log(data);
      $(".modalCrear").modal("hide");
    })
    .fail(function() {
      console.log("error");
    })
    .always(function() {
      console.log("complete");
    });


  });
  $("#singIn").on('click',  function(event) {
    event.preventDefault();
    $(".modal2").modal("show");
    RellenarCountries();
  });

  $("#Country").on('change',function(event) {
    event.preventDefault();
    RellenarCities($(this).val());
  });

  $("#logout").on('click', function(event) {
    event.preventDefault();
      logout();

  });

  $("#login").on('click', function(event) {
    event.preventDefault();
    isLoggin();
    $(".errorLogin").addClass("desaparecer");
    var Name = $("#inputUser").val();
    var Pass = $("#inputPassword").val();

    loggin(Name,Pass,"E");

    if (login==false) {
      $(".errorLogin").removeClass("desaparecer");
    }
    if (Name=="Admin") {
        isLoggin("Admin");

    }else{

    isLoggin();
  }
  });



$("#crear").on("click",function(event){
  event.preventDefault();
  var formulario = $("#myForm");
  if (!$("#crear").hasClass("disabled")){
    var Name=$(formulario).find("#Nombre").val(),
    Surnames=$(formulario).find("#Surnames").val(),
    Email=$(formulario).find("#inputEmail").val(),
    Phone=$(formulario).find("#Phone").val(),
    Sex=$(formulario).find("#Sex").val(),
    User=$(formulario).find("#User").val(),
    Pass=$(formulario).find("#passw1").val(),
    cod_ciudad=$(formulario).find("#City").val();
    mandar(Name,Surnames,Email,Phone,Sex,User,Pass,cod_ciudad);
    $(".modal2").modal("hide");
  }
});
$('#MyBotton').on("click",function(){
  $("#myModal").modal('show');
});

});
