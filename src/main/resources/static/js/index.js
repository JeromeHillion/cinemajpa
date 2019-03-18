let formInscription = document.getElementById('formInscription');
let formConnection = document.getElementById('formConnection');
formInscription.style.display = "none";
formConnection.style.display = "none";

$(function () {

$('#inscription').click(function () {
    $('#body').css('opacity', '0.3');
   $('#formInscription').show('slow');
});

$("#annuler").click(function() {
    $('#body').css('opacity', '1');
    $('#formInscription').hide(1000);
    });
});

$(function (){
    $('#identification').click(function(){
    $('#body').css('opacity', '0.3');
    $('#formConnection').show('slow');
});
    $("#annuler2").click(function() {
        $('#body').css('opacity', '1');
        $('#formConnection').hide(1000);
    });
});