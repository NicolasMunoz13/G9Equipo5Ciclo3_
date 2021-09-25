<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Infomacion de Cliente</title>
	
  <!-- Estilos Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	 crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	 crossorigin="anonymous">
	</script>
	

	<!--- estilos --->
	<link href="insertarstyle.css" rel="stylesheet" type="text/css" />
	<!--- CDN --->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	 crossorigin="anonymous" referrerpolicy="no-referrer">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  

  
</head>

<body>
	
	<!-- Titulo -->
	<h2>
		<div class="sticky-lg-top">Tienda de Prodcutos</div>
	</h2>

	<!-- Barra de Navegacion -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<span class="navbar-brand" href="#">
				<h3>Módulos</h3>
			</span>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="listausuarios.jsp"><h3>Usuarios</h3></a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="listaclientes.jsp"><h3>Clientes</h3></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><h3>Proveedores</h3></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><h3>Productos</h3></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><h3>Ventas</h3></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><h3>Reportes</h3></a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Zona de ingreso de ingreso de informacio -->
<div class="full-form">
  <center>
  <div id="error" class="alert alert-danger visually-hidden"
					role="alert">Error al crear el cliente, verifique que no exista un usuario con la cedula y usuario dados</div>
					
			<div id="correcto" class="alert alert-success visually-hidden"
				role="alert">Cliente creado con exito</div>
				
  <form class="row g-3" id="flex-parent-element" type="" method="">
    <div class="row">
       <div class="column">
       <div id="flex-child-element1">
    
      <div id="user-pass-info">
        <div class="form-floating">      
        <input type="text" class="form-control" class="input-field" id="cedula_cliente" id="form-floating " placeholder=" Cedula" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" required>
        <label for="form-floating">&nbsp&nbsp<i class="fas fa-id-card"></i>&nbsp&nbspCedula</label>
      </div>

      <div class="form-floating">
        <input type="text" class="form-control"  id="nombre_cliente" id="form-floating " placeholder="Nombre Cliente" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="Nombre Cliente" required>
        <label for="form-floating">&nbsp&nbsp<i class="fas fa-user"></i>&nbsp&nbspNombre Cliente</label>
      </div>

    </div>   

    <div class="col-12" >
      <div class="form-floating">
        <input type="text" class="form-control" id="direccion_cliente" id="form-floating " placeholder="Dirección de Cliente" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="Dirección de Cliente" required>
        <label for="form-floating">&nbsp&nbsp<i class="fas fa-house-user"></i>&nbsp&nbspDirección de Cliente</label>
      </div>
    </div>

    <div class="col-12" >
      <div class="form-floating">
        <input type="text" class="form-control" id="telefono_cliente" id="form-floating " placeholder="Telefono Cliente" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="Telefono Cliente" required >
        <label for="form-floating">&nbsp&nbsp<i class="fas fa-mobile-alt"></i>&nbsp&nbspTelefono Cliente</label>
      </div>
    </div>

    <div class="col-12" >
      <div class="form-floating">
        <input type="email" class="form-control" id="email_cliente" id="form-floating " placeholder="Correo Electronico" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" name="correo" required >
        <label for="form-floating">&nbsp&nbsp<i class="fas fa-at"></i>&nbsp&nbspCorreo Electronico</label>
      </div>
    </div>
    </div>
  </div>
  <div class="column">
     <div id="flex-child-element">
      <button type="button" class="btn btn-primary btn-lg" onclick="enviar()">Crear Nuevo Cliente</button>
      <button type="button" class="btn btn-info btn-lg">Consultar Cliente</button>
      <button type="button" class="btn btn-warning btn-lg">Actualizar Cliente</button>
      <button type="button" class="btn btn-danger btn-lg">Borrar Cliente</button>
      <button type="button" class="btn btn-info btn-lg" onclick="window.location.href='/listaclientes.jsp'">Lista de Clientes</button>
    </div>
  </div>
</div>


  </form>
</center>

</div>

<script>
function enviar() {
	var y = document.getElementById("cedula_cliente").value;
	var req = new XMLHttpRequest();
	var coincidencia = false;
	req.open('GET', 'http://localhost:8080/listaclientes', false);
	req.send(null);
	var clientes=null;
	if (req.status == 200)
		clientes=JSON.parse(req.responseText);
	  	console.log(JSON.parse(req.responseText));
	  	
	for (i = 0; i < clientes.length; i++) {
		console.log(clientes[i].cedula_cliente);
		
		if (clientes[i].cedula_cliente ==y ) {
			console.log(clientes[i].cedula_cliente +" "+y);	
			coincidencia =true
			break;
		}
	}
	console.log(coincidencia);	
	
	if (coincidencia==false){
		var formData = new FormData();
			formData.append("cedula_cliente", document.getElementById("cedula_cliente").value);
			formData.append("nombre_cliente", document.getElementById("nombre_cliente").value);
			formData.append("direccion_cliente", document.getElementById("direccion_cliente").value);
			formData.append("telefono_cliente",document.getElementById("telefono_cliente").value);
			formData.append("email_cliente",document.getElementById("email_cliente").value);
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "http://localhost:8080/registrarcliente");
			
		var element = document.getElementById("error");
		element.classList.add("visually-hidden");
		var element2 = document.getElementById("correcto");
		element2.classList.remove("visually-hidden");
		
		document.getElementById("cedula_cliente").value = "";
		document.getElementById("nombre_cliente").value = "";
		document.getElementById("direccion_cliente").value = "";
		document.getElementById("telefono_cliente").value = "";
		document.getElementById("email_cliente").value = "";
			xhr.send(formData);

	}else{
		var element = document.getElementById("error");
		element.classList.remove("visually-hidden");
		var element2 = document.getElementById("correcto");
		element2.classList.add("visually-hidden");
		document.getElementById("cedula_cliente").value = "";
		document.getElementById("nombre_cliente").value = "";
		document.getElementById("direccion_cliente").value = "";
		document.getElementById("telefono_cliente").value = "";
		document.getElementById("email_cliente").value = "";
	}	
}
	</script>  
</body>

</html>