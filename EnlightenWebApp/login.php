<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    	<title>Login</title>
        <link rel="stylesheet" type="text/css" href="style/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/funcion.js"></script>

    </head>
    <body background="img/fondo.png">
        <div class="row">
            <div class="col s4 offset-s4">
                <div class="card-panel teal lighten-5 padding">
    	            <form id="form_autenticacion" action="" >
    	                <div class="row">
    	                    <div class="card-title col s12 center">
                                <img src="img/logo.png" alt="image" height="40%" width="40%">
    	                        <h4>
    	                            Ingreso a la Plataforma
    	                        </h4>
    	                    </div>
    	                </div>
    	                <div class="row margin">
    	                    <div class="input-field col s12">
    	                        <i class="fa fa-user  fa-2x prefix"></i>
    							<input placeholder="Usuario" id="username" type="text" class="validate" name="username">
    							<label for="username">Usuario</label>
    	                    </div>
    	                </div>
    	                <div class="row margin">
    	                    <div class="input-field col s12">
                                <i class="fa fa-unlock-alt fa-2x prefix"></i>
    							<input id="password" type="password" class="validate" name="password">
    							<label for="password">Contraseña</label>
    	                    </div>
    	                </div>
    					<div class="col s12" align="center">
    						<input class="btn btn-lg indigo" type="button" value="Ingresar" onclick="ingreso();">
    					</div>
    	            </form>
                    <div class="col s12" align="center" id="feedBackLogin">
                        <p class="indigo-text text-ligthen-1"> No estas registrado ?
                            <a id="ac" href="f_registro.php" > Registrate Aquí </a>
                        </p>
                    </div>
                    <br> <br> <br>
    	        </div>
            </div>
        </div>

        <div id="modal1" class="modal">
            <div class="modal-content cyan lighten-4" align="center">
                <h5> Error de Inicio de Sesión </h5>
                <img src="img/error.png" width="160" height="180">
                <div  class="col s8"  >
                    <p id="msj"> Usuario o Contraseña Incorrecto </p>
                </div>
            </div>
            <div class="modal-footer cyan lighten-4">
                <a  class="modal-close waves-effect waves-green btn-flat">Aceptar</a>
            </div>
        </div>
    </body>
</html>
