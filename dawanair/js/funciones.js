function copuntries(){
  var countr;
  $.ajax({
    url       : "php/country.php",
    async     : false,
    success   : function(data){
      countr = JSON.parse(data);
    },
    error: function(){
      alert("Error inesperado!");
    }
  });
  return countr;
}
function cities(a){
  var countr;
  $.ajax({
    url       : "php/cities.php",
    async     : false,
    data      : {"id":a},
    success   : function(data){
      countr = JSON.parse(data);
    },
    error: function(){
      alert("Error inesperado!");
    }
  });
  return countr;
}

function RellenarCountries(){
  var counT = $("#Country");
  counT.find("option").remove();
  var countries = copuntries();

  var option = '<option class="" value="" ></option>';
  counT.append(option);
  $(countries).each(function(index, el) {
    console.log(el);
    var option = '<option class="" value="'+el._id+'" >'+el.Name+'</option>';
    counT.append(option);
  });
}
function RellenarCities (a){
  var counT = $("#City");
  counT.find("option").remove();
  var countries = cities(a);
  console.log("el "+countries);
  $(countries).each(function(index, el) {
    console.log(el);
    var option = '<option class="" value="'+el._id+'" >'+el.Nombre+'</option>';
    counT.append(option);
  });
}
function CitiesR (){
  var countr;
  $.ajax({
    url       : "php/cities.php",
    async     : false,
    success   : function(data){
      countr = JSON.parse(data);
      console.log(countr);
    },
    error: function(){
      alert("Error inesperado!");
    }
  });
  return countr;
}
function compExiste (username){
  var countr;
  $.ajax({
    url       : "php/comprovarExiste.php",
    async     : false,
    data      : {"username":username},
    success   : function(data){
      console.log(data);
      if (data=="True") {
          countr=true;
      }else if (data=="False") {
        countr=false;
      }
    },
    error: function(){
      alert("Error inesperado!");
    }
  });
  return countr;
}

function mandar(Name,Surnames,Email,Phone,Sex,User,Pass,cod_ciudad,cod_google,no){
  if (no) {} else {
    var ex = compExiste(User);
  }

  if (ex) {
    alert("Existe usuario");
  }else {

  $.ajax({
    url       : "php/darAlta.php",
    type      : "POST",
    async     : false,
    data      : {
        "Name"        : Name,
        "Surnames"    : Surnames,
        "Email"       : Email,
        "Phone"       : Phone,
        "Sex"         : Sex,
        "User"        : User,
        "Pass"        : Pass,
        "cod_ciudad"  : cod_ciudad,
        "cod_google"  : cod_google
    },
    success : function(data){
      console.log(data);
    }
  });
}
}
function loggin(User,Pass,tipo){

  console.log(User,Pass,tipo);

  var log = false;
  if (tipo == "E") {
        console.log("EEE");
    $.ajax({
      url       : "php/loggin.php",
      type      : "POST",
      async     : false,
      data      : {
        "Email" : "YES",
        "username" : User,
        "password" : Pass
      },
      success   : function(data){
        console.log("data "+data);
        if (data == "True") {
          log = true;
        }
        if (data=="001") {
          alert("Error conexion");
        }
      }
    });
  }else if (tipo == "G") {
    $.ajax({
      url       : "php/loggin.php",
      type      : "POST",
      async     : false,
      data      : {
        "Google" : "YES",
        "id" : User
      },
      success   : function(data){
        console.log("data "+data);
        if (data == "True") {
          log = true;
        }
        if (data=="001") {
          alert("Error conexion");
        }
      }
    });
  }
  login = log;
  return log;
}


function isLoggin(admin,ruta){
  var ad = admin;
  console.log("LOG");
  var pregunta;
  if (admin=="Admin") {
    pregunta = $.ajax({
        url: 'php/isLoggin.php',
        type: "POST",
        async  : false,
        data : {"Admin":"SI"}
      });
  }else {
    pregunta = $.ajax({
        url: 'php/isLoggin.php',
        async:false
      });
  }
  pregunta.done(function(data) {
    console.log(data);


          if (data=="true") {
            login=true;
            $("#AdminPart").hide();

            ad="";
          }else  if (data=="trueAdmin"){
            $("#AdminPart").show();
            login=true;
            ad="Admin";
          }else{
            login=false;
            $("#AdminPart").hide();
            ad="";
}

    // comprovarRutas(ruta,login,ad);
  });
  pregunta.fail(function() {
    alert("error");
  });


  if (login) {
    $(".LOGIN").hide();
    $(".LOGOUT").show();
  }else {
    $(".LOGIN").show();
    $(".LOGOUT").hide();
  }
}
function logout() {
  $.ajax({
    url: 'php/logout.php',
    success: function(){
      location.reload();
    }
  })
  .done(function() {
    alert("logout succes");
    isLoggin();
  })
  .fail(function() {
    alert("Error inesperado");

  })
  .always(function() {
    console.log("complete");
  });
  FB.logout();
}
function logginGoole(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log(profile.getEmail());
  if (loggin(profile.getEmail(),"","G")) {
  }else {
    mandar(profile.ofa,profile.wea,profile.U3,"","","","","","",true);
    loggin(profile.getEmail(),"","G");
  }
      isLoggin();
}
function testAPI() {
  console.log("estamos aqui");

  FB.api('/me',{fields : 'first_name, last_name , email' }, function(response) {

if (loggin(response.email,"","G")) {  // Funciones mias
  console.log(response.email);

}else {
  mandar(response.first_name,response.last_name,response.email,"","","","","","",true); // Funciones mias
  loggin(profile.getEmail(),"","G"); // Funciones mias
}
isLoggin();  // Funciones mias
});


}
function onSignIn(googleUser) {
  logginGoole(googleUser);
}

function signOutGoolge() {
   var auth2 = gapi.auth2.getAuthInstance();
   auth2.signOut().then(function () {
     console.log('User signed out.');
   });
 }

 function Seasonal_offers(){
   var seasonViajes = "";
   $.ajax({
     url: 'php/simpleO.php',
     data: {"cinco": 'SI'}

   })
   .done(function(data) {
     seasonViajes = JSON.parse(data);
     Rellenar();
     console.log("success");

   })
   .fail(function() {
     console.log("error");
   })
   .always(function() {
     console.log("complete");
   });

function Rellenar(){

$(seasonViajes).each(function(index, el) {
  var i = index+1;

var obj="";
obj += '<div class="case-study study'+i+'">';
obj += '<h1>'+el.destino+'</h1>';
obj += '<div class="case-study__overlay">';
obj += '<h2 class="case-study__title">Travel to '+el.destino+' <br>';
obj += '<small>Deal :'+el.precio+'$ </small> |';

obj += '</h2>';
obj += '<a class="case-study__link" href="deal.php?deal='+el.id+'">show more info about it</a>';
obj += '</div>';
obj += '</div>';
var Obj = $(obj);

Obj.css("background-image","url("+el.foto+")");
$(".ContSeas").append(Obj);

});


}}
 function getOne(ide){
   var dev;
   $.ajax({
     url          : "php/getOne.php",
     async        : false,
     data         : { "id" : ide
   },
     success      : function(data){
       dev = JSON.parse(data);
     }
   });

   return dev;
 }
// function comprovarRutas(ruta,log,admin){
//   if (log) {
//       if (admin=="Admin") {
//       }else {
//     switch (ruta) {
//       case 'http://lugman.com.es/dawanair/myDeals.php':
//       window.location.href = "http://lugman.com.es/dawanair/index.php";
//       break;
//       default:
//     }
//     }
//   }else {
//     switch (ruta) {
//       case 'http://lugman.com.es/dawanair/AdminPart.php':
//       window.location.href = "http://lugman.com.es/dawanair/index.php";
//       break;
//       case 'http://lugman.com.es/dawanair/myDeals.php':
//       window.location.href = "http://lugman.com.es/dawanair/index.php";
//       break;
//       default:
//     }
//   }
// }
function BorrarVuelo(id){
  $.ajax({
    url: 'php/borrarVuelo.php',
    type: 'POST',
    data: {"id": id }
  })
  .done(function(data) {
    console.log(data);
  })
  .fail(function() {
    console.log("error");
  })
  .always(function() {
    console.log("complete");
  });
  console.log(id);
}
