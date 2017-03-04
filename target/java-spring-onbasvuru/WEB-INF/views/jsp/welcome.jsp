<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
  <head>    
	<title>Spring MVC Başvuru Projesi</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<c:url var="home" value="/" scope="request" />
	
    <meta name="description" content="GRAPE App landing Page by Codepassenger">
    <meta name="author" content="CodePassenger">
	
	
	<!-- Doğum Tarihi Girişi -->
	<link href='assets/css/bootstrap-datetimepicker.css' rel='stylesheet' type='text/css'>
	
	<!-- Mobile Specific Meta -->	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

    <!-- Bootstrap -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Font awesome -->
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">

    <!-- Animate.css -->
    <link rel="stylesheet" href="assets/css/animate.css">

    <!-- Owl-carousel style -->
    <link rel="stylesheet" href="assets/css/owl.carousel.css">
    <link rel="stylesheet" href="assets/css/owl.theme.css">

    <!-- magnific style -->
    <link rel="stylesheet" href="assets/css/magnific-popup.css">

    <!-- Custom stylesheet-->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/responsive.css" media="screen">

    <!-- Added google font -->
    <link href='http://fonts.googleapis.com/css?family=Dosis:400,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>

	<!-- Telefon Girişi İçin -->
	<link href='assets/css/bootstrap-formhelpers.css' rel='stylesheet' type='text/css'>
	
	
    <!--Fav and touch icons-->
    <link rel="shortcut icon" href="assets/images/icons/favicon.ico">
    <link rel="apple-touch-icon" href="assets/images/icons/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="assets/images/icons/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="assets/images/icons/apple-touch-icon-114x114.png">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Preloader -->
      <div id="faceoff">
        <div id="preloader"></div>
        <div class="preloader-section"></div>
      </div>
    <!-- Preloader end -->
   
    <!-- header start -->
    <header id="home" class="navbar-fixed-top">
      <nav class="navbar navbar-default" role="navigation">
        <div class="container">
          <div class="row">
            <div class="col-sm-3">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <h1><a class="nav-brand" href="">GRAPE</a></h1>
              </div>
            </div>
            <div class="col-sm-7">
              <!-- Collect the nav toggling -->
              <div class="collapse navbar-collapse navbar-example" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                  <li><a href="#banner">Ana Sayfa</a></li>
          
                  <li><a href="#contact">Başvuru Formu</a></li>
                </ul>             
              </div><!-- /.navbar-collapse -->
            </div>
          
          </div>
        </div><!-- /.container -->
      </nav>
    </header>
    <!-- header end -->
   
    <!-- banner start -->
    <section id="banner" class="banner-carousel">
      <div class="trans-bg">
        <div id="background-carousel">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                <div class="item item-no1 active"></div>
                <div class="item item-no2"></div>
                <div class="item item-no3"></div>
              </div>
            </div>
        </div>
        <div class="content-wrapper">
          <div class="container">
            <div class="row">
              <div class="col-sm-12">
                  <h2><a href="" class="lg-logo">LOKUMCU BABA</a></h2> <!-- .lg-logo -->
                  <h1 class="banner-title">Bayilik mi İstiyorsunuz? <br>Hemen Ön Başvuru Formumuzu Doldurun!</h1>               
                  <div class="download-block text-center">
                    
                  </div>                              
              </div>
            </div>
          </div>
        </div>
      </div> <!-- /.trans-bg -->       
    </section>
   
    <!-- contact start -->
    <section id="contact" class="contact white tab-content">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs text-center" role="tablist">
            
              <li class="active wow rollIn animated" data-wow-duration="2s"><a href="#contact-form" role="tab" data-toggle="tab"><i class="fa fa-envelope"></i></a></li>
            </ul>            
          </div>
        </div>
      </div>
       <!-- Tab panes -->            
      <div class="tab-content">
        
        <div class="tab-pane active contact-info" id="basvuru-form">
          <div class="container">
            <div class="row">
              <div class="col-sm-12 text-center">            
                <span class="sub-head">BİRLİKTE BÜYEYELİM</span>
                <div class="title">
                  <h2>Ön Başvuru Formu</h2>
                </div>
              </div>
            </div>
            <div class="row">
          
              <div class="col-sm-12">
                <form method="POST" name="basvuruform" id="basvuruform" action="add/basvuruform" class="form-horizontal" role="form">
                  <div class="col-sm-6">
                    <div class="form-group">
                      <div class="span-form">
                        <input class="form-control" type="text" placeholder="İsim Soyisim" name="adsoyad" required="required">
                      </div>
                      <div class="span-form">
                        <input type="text" class="form-control input-large bfh-phone" name="tc" data-format="ddddddddddd" placeholder="TC Numarası" required="required">
                      </div>
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="Adres" name="adres" required="required">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control input-large bfh-phone" id="telefon" name="telefon" data-format="+90 (ddd) ddd-dddd" required>
                    </div>
					<div class="form-group">
                      <input type="email" class="form-control" placeholder="E-Mail Adresi" name="eposta" required="required">
                    </div>
					<div class="form-group">
						<input type='text' class="form-control" id='datetimepicker4' name="dtarih" placeholder="Doğum Tarihiniz" />
					</div>
					
					
					<div class="form-group">
                      Parakende Ticareti İle Uğraştınız mı?<input type="checkbox" class="form-control" name="is_parakende">
                    </div>
					
                  </div>
				  
                  <div class="col-sm-6">
				  <div class="form-group">
                      <textarea  class="form-control btn-block" rows="3" placeholder="LokumcuBaba'yı tercih etme nedeniniz" name="tercih_neden" required></textarea>
                    </div>
					
				  Hangi İl/İlçe/Semt İçin LokumcuBaba işletmeciliğini düşünüyorsunuz?
				  <div class="form-group">
                      <div class="span-form2">
                        <select class="form-control" name="tercih_il"  id="form_il" required>
							<option>İl Seçiniz</option>
						</select>
                      </div>
                      <div class="span-form2">
                       <select class="form-control" name="tercih_ilce"  id="form_ilce" required>
							<option>Önce İl Seçiniz</option>
						</select>
                      </div>
					  <div class="span-form2">
                        <input type="text" class="form-control" name="tercih_semt"  placeholder="Semt" required="required">
                      </div>
                    </div>
					 <div class="form-group">
                      <input type="text" class="form-control input-large bfh-phone" name="yatirim"  data-format="dddddddddddd"  placeholder="Yatırım Miktarınız" required>
                    </div>
                    <div class="form-group">
                      <textarea  class="form-control btn-block" name="ekstra"  placeholder="İletmek İstedikleriniz" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                   
                      <input type="submit" class="btn btn-block" value="Formu Gönder">
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

      </div>  
    </section>
    <!-- contact end -->
    
<!-- modaldialog kullanıcı için alert -->
<div id="modal_div">
<jsp:include page="returnbsmodal.jsp" />
</div>


    <!-- footer start -->
    <footer id="footer">
      <div class="trans-bg">
        <div class="container">
		<div class="row"> </div>
          <div class="row">
            <div class="col-sm-12 text-center">
              <div class="copyright">
                <p>&copy; <span>Lokumcu Baba</span>2017, Her hakkı Saklıdır</p>
              </div>
            </div>
          </div>
        </div>
        <div id="go-to-top">
            <a href="#banner"></a>
        </div>
        <!--/başa git-->
      </div> <!-- /.trans-bg -->
    </footer>
    <!-- footer end -->   
     


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <!-- <script src="https://code.jquery.com/jquery.js"></script> -->
    <script src="assets/js/jquery.min.js"></script>
    <!-- Gerekli Tüm kaynaklar aşağıda -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/smoothscroll.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.localScroll.min.js"></script>
    <script src="assets/js/jquery.nav.js"></script>
    <script src="assets/js/owl.carousel.js"></script>
    <script src="assets/js/jquery.magnific-popup.js"></script>
    <script src="assets/js/jquery.flexslider-min.js"></script>
    <script src="assets/js/jquery.parallax.js"></script>
    <script src="assets/js/jquery.ajaxchimp.min.js"></script>
    <script src="assets/js/matchMedia.js"></script>
    <script src="assets/js/script.js"></script>
    <script src="assets/js/wow.js"></script>
    <script src="assets/js/easing.js"></script>
	<script src="assets/js/bootstrap-formhelpers-phone.js"></script>
    <script src="assets/js/moment-with-locales.js"></script>
	<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
 <script>

 </script>
	
    <script>
    	$(document).ready(function() {
		//"use strict";
        $('#feature').parallax("50%", 0.5, true);
        $('#video').parallax("50%", 0.5, true);
        $('#subscription').parallax("50%", 0.5, true);
        $('#review').parallax("50%", 0.5, true);
        $('#download').parallax("50%", 0.5, true);
        $('#footer').parallax("50%", 0.5, true);
		
		
		//doğum tarihi bugünden büyük olamaz durumu
            $(function () {
                $('#datetimepicker4').datetimepicker({
                viewMode: 'years',
				format: 'YYYY-MM-DD',
				locale:"tr"
            }).data("DateTimePicker").maxDate(moment());
			
		
            });
    
			
          //il ve ilçe seçimi olayları
			var il_ilceler;
			//iller drek yüklenir
		$.getJSON("assets/il-ilce.json", function(json) {
			$('#form_il').empty();
		var myJSON = JSON.stringify(json);
    	    il_ilceler=json
			var temp_il="";
			$.each(il_ilceler, function(i, v) {
			if(temp_il!=v.il)
				$('#form_il').append($('<option></option>').val(v.il).html(v.il));
				temp_il=v.il;
			});
			$("#form_il").change();
    	});
		
		//il seçimine göre ilçe inputu sıfırlanır ve ilçeler eklenir.
		$("#form_il").change(function () {
		var drop_ilce=$('#form_ilce');
		 drop_ilce.empty();
		 
		 
		$.each(il_ilceler, function(i, v) {
			if(v.il==$('#form_il').val())
			drop_ilce.append($('<option></option>').val(v.ilce).html(v.ilce));
			});	//jsonda merkez seçimi olmadığı için manuel eklendi
			drop_ilce.append($('<option></option>').val("MERKEZ").html("MERKEZ"));
		
		 
			
			
			//formun ajax ile post edilmesi
			
			$("#basvuruform").submit(function(e) {

			    var form = $(this);

			    $.ajax({
			           type: "POST",
			           url: form.attr( 'action' ),
			           data: form.serialize(), 
			           success: function(data)
			           {
			        	   $("#modal_div").html(data); //gelen bsmodal DOMa gömülür
			        	   $("#modal_message").modal("toggle");//gösterilir.
			              
			           }
			         });

			    e.preventDefault(); 
			});
			
			
    });
		<c:if test="${modal_show != null}">
		$("#modal_message").modal("toggle");
		</c:if>
    	});

    	

    </script>     

  </body>
</html>