$(document).ready(function()
{
	 $('.modal').modal();
     $('.slider').slider();
     $('select').material_select();
     $('#textarea1').val('New Text');
  	 $('#textarea1').trigger('autoresize');
});

function showToast(message, duration)
{
    Materialize.toast(message, duration, 'rounded');
}
function registrar()
{

  	$.ajax({
	    type: "POST",
	    data: $("#form_registro").serialize(),
	    url: "usuarios.php",
	    success: function(result)
		{
			if (result==1)
			{
				showToast('Registrado', 3000);
			}
			else
			{
				showToast('No Registrado', 3000);
			}
    	}
	});
}

 function ingreso()
 {

	$.ajax({
		type: "POST",
		data: $("#form_autenticacion").serialize(),
		url: "autenticacion.php",
		success: function(result)
		{
			if (result==true)
			{
				showToast('Ingreso', 2000);
				location.href= 'index.php'
			}
			else
			{
				$('#modal1').modal('open');
			}
		}
	});
}

 function confirmar()
 {
	$('#modal2').modal('open');
}

function salir()
{
	location.href= 'login.php'
}


function agregar_Place()
{
	$('#contenedor').empty();
	$('#contenedor').load('formulario.html');
}

function insertPlace()
{
	$.ajax({
	    type: "POST",
	    data: $("#form_lugares").serialize(),
	    url: "lugares.php",
	    success: function(result)
		{
			if (result==1)
			{
				 showToast('Registrado', 2000);
			}
			else
			{
				showToast('No Registrado', 2000);
			}
    	}
	});
}

function updatePl(place)
{
	//$("#place_edit").val(place);
	//$('#contenedorEdit').empty();
	//$('#contenedorEdit').load('formularioEdit.php?lugar:'place);
	$('#modal4').modal('open');
}



function confirmDelete(place)
{
	$('#modal3').modal('open');
	$("#place_delete").val(place);
}

function sesion()
{
	$('#modal5').modal('open');
}


function deletePlace()
{
    $.ajax({
        url: './eliminar.php',
        type: 'POST',
        data: {lugar:$('#place_delete').val()},
        success: function(result)
		{
			if (result==1)
			{
				 showToast('eliminado', 2000);
				 $("#"+$("#place_delete").val()).html('');

			}
			else
			{
				showToast('No eliminado', 2000);

			}
    	}
	});
}
