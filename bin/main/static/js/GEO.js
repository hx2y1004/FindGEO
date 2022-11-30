 window.initMap = function () {
			  const map = new google.maps.Map(document.getElementById("map"), {
			    center: { lat: 37.5400456, lng: 126.9921017 },
			    zoom: 12,
			    mapId: 'findGeo'
			  });
			  const options = {
				  method: 'GET',
				  headers: {accept: 'application/json', appKey: 'l7xx2d78afef8d7647288413de25f6dc43e5'}
			  };
			 var selLoc = "";
			  map.addListener('dblclick',function(e){
				 console.log(e); 
				  var geocoder = new google.maps.Geocoder;
				  var latlng = {
						  lat : e.latLng.lat(),
						  lng : e.latLng.lng()
				  };
				  console.log(latlng);
				  geocoder.geocode({'location':latlng}, function(results, status){
					  if(status === "OK"){
						  
						  for(var i = 0 ; i < results.length ; i++){
							  if(results[i].types[2] === 'sublocality_level_4'){
								   selLoc = results[i].formatted_address;
							  }
						  }
						  console.log(selLoc);
						  console.log(results);
						  
						  
						  
						  var xhr = new XMLHttpRequest(); 
						  var url = 'http://openapi.seoul.go.kr:8088/6b797a4d7a677573373961756c5169/xml/citydata/1/5/'+selLoc; /*URL*/ 
						  xhr.open('GET', url); 
						  xhr.onreadystatechange = function () { 
							  if (this.readyState == xhr.DONE) {  // <== 정상적으로 준비되었을때 
							  if(xhr.status == 200||xhr.status == 201){ // <== 호출 상태가 정상적일때 
							  console.log('Status: '+this.status+ 
							  '\nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+ 
							  '\nBody: '+this.responseText);
						      }
						  }};xhr.send('');
						  
						  var category = '편의점;';
						  // 목욕탕,숙박,쇼핑,관공서,주요시설물,은행,ATM,편의점,미용실,이발소,대형마트,화장실,공원,커피,음식,레저,호텔,마트,
						  // 식음료, TV맛집, 카페, 한식, 중식, 일식, 패밀리레스토랑, 전문음식점, 
						  // 피자,치킨, 디저트, 제과점, 베스킨라빈스, 하겐다즈, 나뚜루, 콜드스톤, 패스트푸드,
						  // 교통, 버스, 버스정류장, 지하철, 주유소, 충전소, 주차장, 정비소, EV충전소, EV/가스충전소
						  // 병원, 약국, 내과, 소아과, 외과, 치과, 안과, 의원, 보건소, 한의원
						  // 놀거리, 영화관, 노래방, PC방, 공연장, 문화시설, 스크린골프장

						  fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+latlng.lng
						  		+'&centerLat='+latlng.lat
						  		+'&categories='+category
						  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
						    .then(locCate => locCate.json())
						    .then(locCate => {
							  var poiInfo = locCate.searchPoiInfo.pois.poi;	
								
							  //console.log(locCate);
							  for(var i=0; i < poiInfo.length; i++){
								let searchMark = [
							    { label: "O", name: poiInfo[i].name ,
							     lat: Number(poiInfo[i].frontLat),
							     lng: Number(poiInfo[i].frontLon) },
							  ];
							  //console.log(searchMark);
							  
								  
								  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
				
								  searchMark.forEach(({ label, name, lat, lng }) => {
								    let marker = new google.maps.Marker({
								      position: { lat, lng },
								      label,
								      map : map
								    });
								   
								   
								  // let Infomarker = new google.maps.MArker({
									//   position : {  },
									 //  label : "A",
									 //  map: map 
								   //})
				
								    marker.addListener("click", () => { //지도 정보 
								      map.panTo(marker.position); //마커 위치로 중심 이동
								      infowindow.setContent(name);
								      infowindow.open({
								        anchor: marker,
								        map
								      });
								    });		

								    
								    $('#delMark').click(function(){
										console.log("삭제");
									    searchMark.forEach(() =>{
											marker.setMap(null);
										})
								    
								 });
							   })
							  }
							}).catch(err => console.error(err));

					  }else{
						  console.log('주소 없음')
					  }
				  })
				  
			  });
};
