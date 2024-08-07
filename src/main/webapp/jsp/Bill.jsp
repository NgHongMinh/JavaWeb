<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div class="row py-5 p-4 bg-white rounded shadow-sm">
	<div class="col-lg-6">
    	<div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
        	<div class="p-4">
        		<div class="input-group mb-4 border rounded-pill p-2">
        			<input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
        				<div class="input-group-append border-0">
        					<button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Sử dụng</button>
        				</div>
        			</div>
        		</div>
       	 	</div>
    		<div class="col-lg-6">
        		<div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
        			<div class="p-4">
        				<ul class="list-unstyled mb-4">
        					<li class="d-flex justify-content-between py-3 border-bottom">
        						<strong class="text-muted">Tổng tiền hàng</strong>
        						<strong>${totalAmount} $</strong>
        					</li>
       						<li class="d-flex justify-content-between py-3 border-bottom">
        						<strong class="text-muted">Phí vận chuyển</strong>
        						<strong>Free ship</strong>
       						</li>
	        				<li class="d-flex justify-content-between py-3 border-bottom">
	        					<strong class="text-muted">VAT</strong>
        						<strong>${vat} $</strong>
        					</li>
        					<li class="d-flex justify-content-between py-3 border-bottom">
        						<strong class="text-muted">Tổng thanh toán</strong>
        						<strong>${totalPayment} $</strong>
        					</li>
        					</ul><a href="clearCart" class="btn btn-dark rounded-pill py-2 btn-block">Thanh Toán</a>
        			</div>
        	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>