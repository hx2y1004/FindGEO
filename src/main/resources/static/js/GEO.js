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
						  
						  var category = '편의점';
						  fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+latlng.lng
						  		+'&centerLat='+latlng.lat
						  		+'&categories='+category
						  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
						    .then(locCate => locCate.json())
						    .then(locCate => {
							  var poiInfo = locCate.searchPoiInfo.pois.poi;	
								
							  for(var i=0; i < poiInfo.length; i++){
								const searchMark = [
							    { label: "O", name: poiInfo[i].name ,
							     lat: Number(poiInfo[i].frontLat),
							     lng: Number(poiInfo[i].frontLon) },
							  ];
							  //console.log(searchMark);
							  
								  
								  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
				
								  searchMark.forEach(({ label, name, lat, lng }) => {
								    const marker = new google.maps.Marker({
								      position: { lat, lng },
								      label,
								      map: map
								    });
								   
				
								    marker.addListener("click", () => { //지도 정보 
								      map.panTo(marker.position); //마커 위치로 중심 이동
								      infowindow.setContent(name);
								      infowindow.open({
								        anchor: marker,
								        map
								      });
								    });		
								 });
							  }
							}).catch(err => console.error(err));

					  }else{
						  console.log('주소 없음')
					  }
				  })
				  
			  });
};
