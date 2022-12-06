let cate;
let cates = '';
let rtJson;
var areaChart;
$(document).ready(function(){
	$('#areaDataSet').click(function(){
		cate = 'input[name="areaData"]:checked';
		let selectCate = document.querySelectorAll(cate);
		selectCate.forEach((e) => {
			cates += e.value + ';';
		});
		console.log(cates);
		alert(cates+"(으)로 설정되었습니다. 원하는 위치를 더블 클릭 해주세요.");
	});
	$('#selDel').click(function(){
		console.log('체크삭제');
		$('input:checkbox[name="areaData"]').prop("checked",false);
	})
	
});



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
			  const RTloc = [
			    { label: "A", name: "광화문·덕수궁", lat: 37.5701758269873949, lng: 126.9770290287743677 },
			    { label: "A", name: "가산디지털단지", lat: 37.481631531266494, lng: 126.8828464716437 },
			    { label: "A", name: "경복궁·서촌마을", lat: 37.57984291352679, lng: 126.97328946157951 },
			    { label: "A", name: "창덕궁·종묘", lat: 37.577594922983714, lng: 126.99421904681404 },
			    { label: "A", name: "강남 MICE 관광특구", lat: 37.51139584858334, lng: 127.0598901748247 },
			    { label: "A", name: "동대문 관광특구", lat: 37.56553339479549, lng: 127.01335269486151 },
			    { label: "A", name: "명동 관광특구", lat: 37.56430824310635, lng: 126.98213839226364 },
			    { label: "A", name: "이태원 관광특구", lat: 37.534182850940134, lng: 126.99585715035037 },
			    { label: "A", name: "잠실 관광특구", lat: 37.51572998546949, lng: 127.1106208455404 },
			    { label: "A", name: "종로·청계 관광특구", lat: 37.56860711844535, lng: 126.99699476920193 },
			    { label: "A", name: "홍대 관광특구", lat: 37.554186763087046, lng: 126.92167853659397 },
			    { label: "A", name: "국립중앙박물관·용산가족공원", lat: 37.52307335452393, lng: 126.98017529033454 },
			    { label: "A", name: "남산공원", lat: 37.55086687995742, lng: 126.99364284291867 },
			    { label: "A", name: "뚝섬한강공원", lat: 37.52980299850679, lng: 127.06848459110635 },
			    { label: "A", name: "망원한강공원", lat: 37.55191301250163, lng: 126.90009993326127 },
			    { label: "A", name: "반포한강공원", lat: 37.509495233313906, lng: 126.99492420715372 },
			    { label: "A", name: "북서울꿈의숲", lat: 37.620952809775886, lng: 127.03985178773338 },
			    { label: "A", name: "서울대공원", lat: 37.430417970238516, lng: 127.01439126516586 },
			    { label: "A", name: "서울숲공원", lat: 37.54423023812191, lng: 127.03748645613268 },
			    { label: "A", name: "월드컵공원", lat: 37.56982369211536, lng: 126.88183162321674 },
			    { label: "A", name: "이촌한강공원", lat: 37.5194868738881, lng: 126.96585010921682 },
			    { label: "A", name: "잠실종합운동장", lat: 37.515275045462595, lng: 127.07281175382138 },
			    { label: "A", name: "잠실한강공원", lat: 37.51748123459748, lng: 127.0866465879202 },
			    { label: "A", name: "가로수길", lat: 37.521124302486854, lng: 127.02285723293289 },
			    { label: "A", name: "낙산공원·이화마을", lat: 37.58078608289144, lng: 127.00655121224148 },
			    { label: "A", name: "노량진", lat: 37.51383133465401, lng: 126.94295359838094 },
			    { label: "A", name: "북촌한옥마을", lat: 37.58142391139889, lng: 126.98491147830116 },
			    { label: "A", name: "성수카페거리", lat: 37.54582965180822, lng: 127.05025675818062 },
			    { label: "A", name: "수유리 먹자골목", lat: 37.64127855656912, lng: 127.0256567437706 },
			    { label: "A", name: "쌍문동 맛집거리", lat: 37.64753484172107, lng: 127.03390452341957 },
			    { label: "A", name: "압구정로데오거리", lat: 37.52544097597958, lng: 127.0377796867246 },
			    { label: "A", name: "여의도", lat: 37.52520148760658, lng: 126.9244489204027 },
			    { label: "A", name: "영등포 타임스퀘어", lat: 37.51626472241912, lng: 126.90618385009164 },
			    { label: "A", name: "인사동·익선동", lat: 37.57332252132529, lng: 126.98714846139971 },
			    { label: "A", name: "창동 신경제 중심지", lat: 37.65496321017065, lng: 127.05488994001286 },
			    { label: "A", name: "DMC(디지털미디어시티)", lat: 37.579641164297875, lng: 126.89208165788469 },
			    { label: "A", name: "구로디지털단지역", lat: 37.484258374128444, lng: 126.89580387984323 },
			    { label: "A", name: "강남역", lat: 37.49798861990043, lng: 127.02808697044497 },
			    { label: "A", name: "건대입구역", lat: 37.54031233151287, lng: 127.0683448155881 },
			    { label: "A", name: "고속터미널역", lat: 37.506094699822086, lng: 127.00535540254258 },
			    { label: "A", name: "교대역", lat: 37.49278069302649, lng: 127.02144987992703 },
			    { label: "A", name: "서울역", lat: 37.55565506357903, lng: 126.97247604835474 },
			    { label: "A", name: "선릉역", lat: 37.5059635136923, lng: 127.04966460076305 },
			    { label: "A", name: "신도림역", lat: 37.50926798061878, lng: 126.88868912534052 },
			    { label: "A", name: "신림역", lat: 37.48381783560379, lng: 126.92978416890433 },
			    { label: "A", name: "신촌·이대역", lat: 37.55753940807936, lng: 126.93836099710354 },
			    { label: "A", name: "왕십리역", lat: 37.56084354547574, lng: 127.03574095121763 },
			    { label: "A", name: "역삼역", lat: 37.50081036749941, lng: 127.03607031279644 },
			    { label: "A", name: "연신내역", lat: 37.619133355197896, lng: 126.92073783266778 },
			    { label: "A", name: "용산역", lat: 37.52953539910786, lng: 126.9636943682725 },
			  ];



			  RTloc.forEach(({ label, name, lat, lng }) => {
				  let RTmarker = new google.maps.Marker({
									  position: { lat, lng },
								      label,
								      map: map
					});
				  let infoRT = new google.maps.InfoWindow(); 	
			 	  RTmarker.addListener("click", () => { //지도 정보 
			 	  
				  const modal = document.getElementById("modal");
			 	  modal.style.display = "flex";
			 	  const closeBtn = modal.querySelector('.close-area');
			 	  var ctx = document.getElementById("bar-chart-horizontal");
			 	  var config = {};
				  var areaChart = new Chart(ctx,config);
				  closeBtn.addEventListener("click", e => {
					   var dataset = config.data.datasets;
					   for(var i=0; i<dataset.length; i++){
						   var data = dataset[i].data;
						   for(var j=0; j<data.length; j++){
							   data[j] = 0;
						   }
					   };
					   
						areaChart.update();
						modal.style.display="none";
				  });
				  modal.addEventListener("click", e => {
				  const evTarget = e.target
			      if(evTarget.classList.contains("modal-overlay")) {
						var dataset = config.data.datasets;
					    for(var i=0; i<dataset.length; i++){
					 	    var data = dataset[i].data;
				 		    for(var j=0; j<data.length; j++){
							    data[j] = 0;
						    }
					    };
						areaChart.update();
				  		modal.style.display = "none"
					 }
				  })
			 	  			
			 	  					  selLoc = name;
								      map.panTo(RTmarker.position); //마커 위치로 중심 이동
								      infoRT.setContent(name);
								      infoRT.open({
								        anchor: RTmarker,
								        map
								      });
								     var xhr = new XMLHttpRequest(); 
									  var url = 'http://openapi.seoul.go.kr:8088/6b797a4d7a677573373961756c5169/xml/citydata/1/5/'+selLoc; /*URL*/ 
									  xhr.open('GET', url);
									  xhr.onreadystatechange = function () { 
										  if (this.readyState == xhr.DONE) {  // <== 정상적으로 준비되었을때 
										  if(xhr.status == 200||xhr.status == 201){ // <== 호출 상태가 정상적일때 
										  var RTxml = new DOMParser().parseFromString(this.responseText, 'text/xml');
										  rtJson = xmlToJson(RTxml); 
										  console.log(rtJson);
										  
										  config = {
													type: 'bar',
													data: {
													labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
													datasets:[
																{
																	label: "Population (millions)",
																	backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
																	data: [2478,5267,2734,3784,1433]
																}
															  ]
															},
													options: {
													indexAxis: 'y',
													legend: { display: false },
													title: {
															 display: true,
															 text: 'Predicted world population (millions) in 2050'
														   }
														}
										   };
										  
									    };
									  areaChart.update();
									  
									    
							}};xhr.send('');
					 });	
			  });
			  
			  
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
						  
						  var category = cates;
						  // 목욕탕,숙박,쇼핑,관공서,주요시설물,은행,ATM,편의점,미용실,이발소,대형마트,화장실,공원,커피,음식,레저,호텔,마트,
						  // 식음료, TV맛집, 카페, 한식, 중식, 일식, 패밀리레스토랑, 전문음식점, 
						  // 피자,치킨, 디저트, 제과점, 베스킨라빈스, 하겐다즈, 나뚜루, 콜드스톤, 패스트푸드,
						  // 교통, 버스, 버스정류장, 지하철, 주유소, 충전소, 주차장, 정비소, EV충전소, EV/가스충전소
						  // 병원, 약국, 내과, 소아과, 외과, 치과, 안과, 의원, 보건소, 한의원
						  // 놀거리, 영화관, 노래방, PC방, 공연장, 문화시설, 스크린골프장
						  if(!cates){
							  alert('상권을 입력해주세요');
						  }else{
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
										cates = '';
										$('input:checkbox[name="areaData"]').prop("checked",false);
										
									    searchMark.forEach(() =>{
											marker.setMap(null);
										})
								    
								 });
								 
							   })
							  }
							  
							})
							.catch(
								err => console.error(err)
							);
						}
					  }else{
						  console.log('주소 없음')
					  }
					  
				  })
				  //const markerClusterer = new markerClusterer.MarkerClusterer;
				  //markerClusterer({ map, marker });
			  });
};

// xml을 json으로 변환해주는 xmlToJson함수 선언
function xmlToJson(xml) {
    // Create the return object
    var obj = {};
  
    if (xml.nodeType == 1) {
      // element
      // do attributes
      if (xml.attributes.length > 0) {
        obj["@attributes"] = {};
        for (var j = 0; j < xml.attributes.length; j++) {
          var attribute = xml.attributes.item(j);
          obj["@attributes"][attribute.nodeName] = attribute.nodeValue;
        }
      }
    } else if (xml.nodeType == 3) {
      // text
      obj = xml.nodeValue;
    }
  
    // do children
    // If all text nodes inside, get concatenated text from them.
    var textNodes = [].slice.call(xml.childNodes).filter(function(node) {
      return node.nodeType === 3;
    });
    if (xml.hasChildNodes() && xml.childNodes.length === textNodes.length) {
      obj = [].slice.call(xml.childNodes).reduce(function(text, node) {
        return text + node.nodeValue;
      }, "");
    } else if (xml.hasChildNodes()) {
      for (var i = 0; i < xml.childNodes.length; i++) {
        var item = xml.childNodes.item(i);
        var nodeName = item.nodeName;
        if (typeof obj[nodeName] == "undefined") {
          obj[nodeName] = xmlToJson(item);
        } else {
          if (typeof obj[nodeName].push == "undefined") {
            var old = obj[nodeName];
            obj[nodeName] = [];
            obj[nodeName].push(old);
          }
          obj[nodeName].push(xmlToJson(item));
        }
      }
    }
    return obj;
  }
