<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous" />
</head>
<body>

	<div class="container-fluid">
		<div class="row">

			<div class="col-2"></div>
			<div class="col-8">

				<div class="card">
					<div class="card-header">Kullanıcı İşlemleri</div>
					<div class="card-body">
						<form class="form-group" method="post" action="useradd">
							<div class="container-fluid">
								<div  class="row" >
									<div class="col"  >
									<%
										String par = request.getParameter("do");
										if (par != null && par.equals("true")) {
									%>
									<div class="alert alert-success">İşlem Başarılı</div>
									<%
										}else if(par != null && par.equals("false")){
									%>
									<div class="alert alert-warning">İşlem Başarısız</div>
									
									<%
										}
									%>
									</div>
								
								</div>
								
								
								
								<div class="row">
							
									<div class="col ">

										<label for="ad">Ad:</label> <input class="form-control"
											type="text" id="ad" name="ad" value=""
											placeholder="İsim girin !" />

									</div>
									<div class="col ">

										<label for="soyad">Soyad:</label> <input class="form-control"
											type="text" id="soyad" name="soyad" value=""
											placeholder="Soyad girin !" />




									</div>
								</div>
								<div class="row" style="margin-top: 20px;">
									<div class="col-12  ">

										<input type="submit" class="btn btn-success float-right"
											value="Kaydet" />

									</div>
								</div>
							</div>

						</form>
					</div>
					<div class="card-footer">İşlem Tarihi: 01.12.2018</div>

				</div>
			</div>
			<div class="col-2"></div>


		</div>
	</div>

</body>
</html>