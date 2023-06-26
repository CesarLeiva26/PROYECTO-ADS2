<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	max-width: 500px;
	width: 100%;
	padding: 20px;
	text-align: left;
}

.form-container .form-group {
	display: flex;
	flex-direction: row;
	align-items: center;
	margin-bottom: 10px;
}

.form-container label {
	width: 40%;
	margin-right: 10px;
	text-align: right;
}

.form-container input, .form-container textarea {
	width: 60%;
	padding: 10px;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2 class="fw-bold p-4 text-center d-flex">Registrar Incidente
			Tecnológico</h2>

		<form action="ServletInforme?tipo=registrar" id="frmregistro"
			method="post">


			<div class="form-group">
				<label class="w-100 fw-bold d-flex">Solicitante:</label>
				<select class="form-control fw-bold" type="text" id="demo"
					name="txt_solicitante" class="w-100 fw-bold"
					onChange="combo(this, demo)" required>
					<option value="1">Maria Querevalu</option>
					<option value="2">Emanuel Leiva</option>
					<option value="3">Alexandra Vilchez</option>
					<option value="4">Gabriela Rojas</option>
					<option value="5">Victor Borja</option>
				</select>
			</div>
			
			<div class="form-group">
				<label class="w-100 fw-bold d-flex">Ubicación:</label>
				<select class="form-control fw-bold" type="text" id="demo"
					name="txt_ubicacion" class="w-100 fw-bold"
					onChange="combo(this, demo)" required>
					<option value="1">Callao</option>
					<option value="2">Miraflores</option>
					<option value="3">Los Olivos</option>
				</select>
			</div>
			<div class="form-group">

				<label class="w-100 fw-bold d-flex" for="fechaHora">Fecha y
					Hora:</label> <input type="date" id="fechaHora" class="w-100 fw-bold"
					name="txt_fecha" required>

			</div>
			<div class="form-group">
				<label class="w-100 fw-bold d-flex">Numero de Solicitud:</label> <input
					type="text" class="w-100 fw-bold" name="txt_numero" required>

			</div>

			<div class="form-group">
				<label class="w-100 fw-bold d-flex">Incidente:</label> <select
					class="form-control fw-bold" type="text" id="demo"
					name="txt_incidente" class="w-100 fw-bold"
					onChange="combo(this, demo)" required>
					<option class="fw-bold" value="1">Caída del servidor</option>
					<option value="2">Robo de datos confidenciales</option>
					<option value="3">Virus en la red corporativa</option>
					<option value="4">Interrupción del servicio de correo
						electrónico</option>
					<option value="5">Ataque de denegación de servicio (DDoS)</option>
				</select>
			</div>
			<div class="form-group">
				<label class="w-100 fw-bold d-flex">Recomendacion: </label>
				<textarea class="w-100 fw-bold" name="txt_recomendacion" cols="30"
					rows="4"></textarea>

			</div>

			<div class="text-center">
				<button type="button" class="btn btn-secondary fw-bold"
					onclick="window.location.href='menuPrincipal.jsp'">
					<i class="fas fa-backspace"></i> Regresar
				</button>
				<button type="submit" class="btn btn-danger fw-bold">
					<i class="fas fa-save"></i> Registrar
				</button>
			</div>
			<br> <br>

			<%
				if (request.getAttribute("mensaje") != null) {
			%>
			<div class="alert alert-success text-center" role="alert">
				<%=request.getAttribute("mensaje")%>
			</div>
			<%
				}
			%>
		</form>
	</div>
	
	<script src="https://kit.fontawesome.com/f16b543c6e.js"
		crossorigin="anonymous"></script>
</body>
</html>