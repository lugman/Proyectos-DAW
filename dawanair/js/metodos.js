$(function(){
  // $(".modalCrear").modal("hide");

  isLoggin("Admin",window.location.href);
  $("#Sillas").modal("hide");
  // $(".LOGOUT").hide();

  Seasonal_offers();

  $(cities()).each(function(index, el) {
    $("#orrigen,#orrigen2").append('<option value="'+el._id+'" >'+el.Nombre+'</option>');
    $("#desstino,#desstino2").append('<option value="'+el._id+'" >'+el.Nombre+'</option>');
  });


});

$('#myForm').validator({
  custom: {
    equals: function($el) {
      var matchValue = $("#passw1").val(); // foo
      if ($el.val() !== matchValue) {
        return "Hey, the password not are equals" + matchValue
      }
    }
  }
});
