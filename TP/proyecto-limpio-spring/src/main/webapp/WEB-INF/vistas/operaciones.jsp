<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<form:form action="validar-operacion" method="POST" modelAttribute="cadenaOperacion">
			    	<h3 class="form-signin-heading">TP WEB III</h3>
					<hr class="colorgraph"><br>
					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<h4 class="form-signin-heading">Ingresar cadena</h4>
					<form:input path="cadena" id="cadena" class="form-control" />
					<h4 class="form-signin-heading">Seleccionar operacion</h4>
					<!--<form:select path="operacionElegida" multiple="false" class="form-control" required="true">
 								<form:option id="pasarAMayuscula" value="pasarAMayuscula" />
 								<form:option id="pasarAMiniscula" value="pasarAMiniscula" />
 								<form:option id="invertirOrden" value="invertirOrden"  />
 								<form:option id="cantidadDeCaracteres" value="cantidadDeCaracteres" />
 						</form:select> 		  -->
					
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Ejecutar</button>
				</form:form>

				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
