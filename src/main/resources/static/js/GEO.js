 window.initMap = function () {
			  const map = new google.maps.Map(document.getElementById("map"), {
			    center: { lat: 37.5400456, lng: 126.9921017 },
			    zoom: 10,
			    mapId: 'findGeo'
			  });
			 
			  map.addListener('click',function(e){
				 console.log(e); 
				  var geocoder = new google.maps.Geocoder;
				  var latlng = {
						  lat : e.latLng.lat(),
						  lng : e.latLng.lng()
				  };
				  console.log(latlng);
				  geocoder.geocode({'location':latlng}, function(results, status){
					  if(status === "OK"){
						  console.log(results);
					  }else{
						  console.log('주소 없음')
					  }
				  })
				  
			  });
			  
			  	var xhr = new XMLHttpRequest(); 
				var url = 'http://openapi.seoul.go.kr:8088/6b797a4d7a677573373961756c5169/xml/citydata/1/5/여의도'; /*URL*/ 
				xhr.open('GET', url); 
				xhr.onreadystatechange = function () { 
				if (this.readyState == xhr.DONE) {  // <== 정상적으로 준비되었을때 
				if(xhr.status == 200||xhr.status == 201){ // <== 호출 상태가 정상적일때 
				console.log('Status: '+this.status+ 
				'\nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+ 
				'\nBody: '+this.responseText);
				}
				}};xhr.send('');

			  
			  const options = {
					  method: 'GET',
					  headers: {Accept: 'application/json', appKey: 'l7xx2d78afef8d7647288413de25f6dc43e5'}
					};

					fetch('https://apis.openapi.sk.com/tmap/pois?version=1&searchKeyword=SK%20T%ED%83%80%EC%9B%8C&searchType=all&searchtypCd=A&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&page=1&count=20&multiPoint=N&poiGroupYn=N', options)
					  .then(response => response.json())
					  .then(response => console.log(response))
					  .catch(err => console.error(err));
			  
			 const malls = [
				    { label: "C", name: "코엑스몰", lat: 37.5115557, lng: 127.0595261 },
				    { label: "G", name: "고투몰", lat: 37.5062379, lng: 127.0050378 },
				    { label: "D", name: "동대문시장", lat: 37.566596, lng: 127.007702 },
				    { label: "I", name: "IFC몰", lat: 37.5251644, lng: 126.9255491 },
				    { label: "L", name: "롯데월드타워몰", lat: 37.5125585, lng: 127.1025353 },
				    { label: "M", name: "명동지하상가", lat: 37.563692, lng: 126.9822107 },
				    { label: "T", name: "타임스퀘어", lat: 37.5173108, lng: 126.9033793 }
				  ];

				  const bounds = new google.maps.LatLngBounds(); // 지도 경계 보여주기
				  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기

				  malls.forEach(({ label, name, lat, lng }) => {
				    const marker = new google.maps.Marker({
				      position: { lat, lng },
				      label,
				      map: map
				    });
				    bounds.extend(marker.position); // 마커 정보 표시

				    marker.addListener("click", () => { //지도 정보 
				      map.panTo(marker.position); //마커 위치로 중심 이동
				      infowindow.setContent(name);
				      infowindow.open({
				        anchor: marker,
				        map
				      });
				    });
				  });
					
				  map.fitBounds(bounds);
				};