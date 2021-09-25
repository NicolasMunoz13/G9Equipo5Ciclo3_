<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Tienda generica - ciclo 3</title>
	
	<!-- Boostrap -->
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

	<!--- estilos --->
	<link href="style.css" rel="stylesheet" type="text/css" />
	<!--- CDN FontAwesome--->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	 crossorigin="anonymous" referrerpolicy="no-referrer">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

	<!--- estructura del contenedor --->

	<div class="login-box">
		<!--- imagen del logo, el avatar --->
		<img src="https://cdn.pixabay.com/photo/2015/06/10/19/56/apples-805124_960_720.jpg" class="avatar" alt="Avatar Image">
      
      <!--- titulo de login here --->
      <a href="login.jsp"><h1>Iniciar Sesión</h1></a>

      <!--- Formulario de login --->
      <form>
        <!-- USERNAME INPUT, aparece toda la informacion de la etiqueta Username -->        
        <label for="username">Usuario</label>    
        <input type="text" placeholder="&#xf007; Ingrese el Usuario" id="inputuser" required>

        <!-- PASSWORD INPUT -->
        <label for="password">Contraseña</label>
        <input type="password" placeholder=" Ingrese la contraseña" id="inputpass" required>

        <!-- Button de submit que dice Log In -->
        <button class="btn-input" type="button" value="Iniciar Sesión" onclick="comparar()">Iniciar Sesión</button>

        <!-- Enlaces de olvido su contraseña y no tienes una cuenta-->
        <a href="#">¿No recuerdas la contraseña?</a><br>
        <a href="#">¡Crear una cuenta!</a>
        
        

      </form>
      <div id="error" class="alert alert-danger visually-hidden"
					role="alert">Usuario o contraseña incorrecta!</div>
    </div>
    
    <section></section>
    <!-- Footer de redes sociales -->
    <footer id="colophon" class="site-footer" role="contentinfo">

  
  <!--Indicacion de texto -->
  <nav class="footer-nav" role="navigation">
    


      <div class="social-wrapper">
    <!-- Lista contenedora de iconos -->
    <ul>
      <li>
        <a href="#">
          <img src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png" alt="Twitter Logo" class="twitter-icon"></a>
      </li>
      <li>
        <a href="#">
          <img src="https://www.mchenryvillage.com/images/instagram-icon.png" alt="Instagram Logo" class="instagram-icon"></a>
      </li>
      <li>
        <a href="#">
          <img src="http://www.iconarchive.com/download/i54037/danleech/simple/facebook.ico" alt="Facebook Logo" class="facebook-icon"></a>
      </li>
      <li>
        <a href="#">
          <img src="https://lh3.googleusercontent.com/j_RwVcM9d47aBDW5DS1VkdxUYCkDUCB6wZglv4x-9SmsxO0VaFs7Csh-FmKRCWz9r_Ef=w170" alt="Youtube Logo" class="youtube-icon"></a>
      </li>
      <li>
        <span class="copyright"><strong><span>SCRUMTEAM 5</span>MisionTIC Copyright &copy 2021</strong></span>
      </li>
      
    </ul>

    </div>
</div>

 
  </nav>
  
</footer>

	<script>
	function comparar(){
		//trayendo texto de input de username
		var x = document.getElementById("inputuser").value;
		//trayendo texto de input de password
		var y = document.getElementById("inputpass").value;
		//url de la api 
		var baseurl = "http://localhost:8080/listausuarios";
		//creando un objeto de manipulacion de solicitudes
		var xmlhttp = new XMLHttpRequest();
		//abriendo la api
		xmlhttp.open("GET", baseurl, true);
		//funcion interna que compara la información
		xmlhttp.onreadystatechange = function() {
			//si se obtiene un 200 (Conexion correcta)
			if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				//convirtiendo JSON en variable javascrip
				var usuarios = JSON.parse(xmlhttp.responseText);
				
				//verificando uno por uno si existe ese usuario
				for (i = 0; i < usuarios.length; i++) {
					
					//imprimiendo en la consola del navegador pata verificar
					console.log(usuarios);
					console.log(x);
					console.log(usuarios[i].usuario);
					console.log(y);
					console.log(usuarios[i].password);
					
					//si el nombre coincide
					if (usuarios[i].usuario === x) {
						//si la clave coincide
						if (usuarios[i].password === y) {
							console.log("si");
							var element = document.getElementById("error");
							element.classList.add("visually-hidden");
							document.getElementById("inputuser").value = "";
							document.getElementById("inputpass").value = "";
							window.location.href = "listausuarios.jsp";
							return;
						} else {
							//si la clave NO coincide
							console.log("error clave");
							var element = document.getElementById("error");
							element.classList.remove("visually-hidden");
							document.getElementById("inputuser").value = "";
							document.getElementById("inputpass").value = "";
							return;
						}
					}
				}
				//Si no existe el usuario
				console.log("no encontrado");
				
				//quitando la capacidad de ocultacion del error para mostrarlo
				var element = document.getElementById("error");
				element.classList.remove("visually-hidden");
				document.getElementById("inputuser").value = "";
				document.getElementById("inputpass").value = "";
				return;
			}
		};
		//ejecutando
		xmlhttp.send();
	}
	</script>

  </body>
</html>