<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">  
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="resources/css/html5style.css">
	<script src="resources/js/jquery-1.9.0.js" type="text/javascript"></script>
	<script src="resources///code.jquery.com/jquery-1.11.3.min.js"></script>	
<script>
	$(document).ready(function(){
		/* $('li.color')
			.bind('mouseover' , function () {$(this).addClass('gray');})
			.bind('mouseout' , function () {$(this).removeClass('gray');})
		$('div.file')
			.bind('mouseover' , function () {$(this).addClass('gray');})
			.bind('mouseout' , function () {$(this).removeClass('gray');})
			
		$('div.file').mouseup(function(e){
			if(e.which=='3'){
				$(this).find('ul.menu').stop().slideDown(200);
			}else if(e.which=='1'){
				$(this).find('ul.menu').stop().slideUp(200);
			}
		});
		
		$('img.homemenu').mouseup(function(e){
			alert(e.which); 
		}); */
		
		$('#pf').on('change', function(){
	         readURL(this);
	    });
		
		function readURL(input){
	    //선택된 파일 있다면
	    if(input.files && input.files[0]){
	    //선택된 파일 이름 가져오기
	    var fileName=
	    input.files[0].name;
	    //파일 이름에서 뒤의 3글자 가져오기
	    var ext=fileName.substr(
	    fileName.length-3, fileName.length);
	         
	    //확장자를 확인해서 jpg, gif, png가 아니면
	    //함수를 빠져나감
	     var isCheck=false; 
	     if(ext.toLowerCase()=='jpg' || ext.toLowerCase()=='gif' || ext.toLowerCase()=='png'){
	         isCheck=true;
	      }
	     if(isCheck==false){
	      	 alert(".jpg .png .gif 파일만 등록 가능합니다.");
	         return;
	      }
			// 파일의 내용을 읽어 올 수 있는 파일 객체
	        var reader = new FileReader();
	        //읽을 파일을 설정
	        reader.readAsDataURL(input.files[0]);          
	        //파일의 내용이 메모리에 전부 로드되면
	        //img 태그에 출력
	        reader.onload=function(e){
	        $('#pfimg').attr('src', e.target.result);
	        }          
	        } //end if
		} //end readURL
	});
	
	function layoutChoice(num){  //makeBlog2 layout 변경
 		document.getElementById('layout'+num).checked = true;
	
		for(var i=1; i<=6; i++){
			$('.layout'+i).attr("src",
			         "resources/images/layout/layout"+i+".jpg");
			$('.layoutedit'+i).slideUp(200);
		}
 		 $('.layout'+num).attr("src",
         "resources/images/layout/layout"+num+"on.jpg");
 		 
 		$('.layoutedit'+num).slideDown(200);
 	}
	
	
	
 	function changeArea(){
 		var area1 = ['문학·책','영화','미술·디자인','공연·전시','음악','드라마','스타·연예인','만화·애니','방송']; //9개
 		var area2 = ['일상·생각','육아·결혼','애완·반려동물','좋은글·이미지','패션·미용','인테리어·DIY','상품리뷰','원예·재배']; //8개
 		var area3 = ['게임','스포츠','사진','자동차','취미','국내여행','세계여행','맛집']; //8개
 		var area4 = ['IT·컴퓨터','사회·정치','건강·의학','비즈니스·경제','어학·외국어','교육·학문']; //6개
 		var formName = document.makeblog;
 		var area = formName.area;
 		var i=0;
		switch($('#bigarea').val()){
		case 'art':
			for(i=0; i<area1.length; i++){
				area.options[i] = new Option(area1[i],i)
			}
			break;
		case 'life':
			for(i=0; i<area2.length; i++){
				area.options[i] = new Option(area2[i],i+9)
			}
			break;
		case 'hobby':
			for(var i=0; i<area3.length; i++){
				area.options[i] = new Option(area3[i],i+17)
			}
			break;
		case 'int':
			for(var i=0; i<area4.length; i++){
				area.options[i] = new Option(area4[i],i+25)
			}
			break;
		default :
				i=0;
				area.options[0] = new Option('==선택하세요==',31)
		} 
	}
 	
 	
</script>
</head>
<body onContextmenu="return false">
    <header>   
	    <img src="resources/images/TechFarmdotBlog.jpg" onclick="location.href='http://52.79.140.54/TechFarm/'" style="cursor:pointer;" 

width="400" height="100" />
		<img src="resources/images/menu.png" onclick="location.href='login.do'" style="cursor:pointer;" width="30" height="30" 

class="homemenu" align="right"/>
	</header>