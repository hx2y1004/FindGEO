let cate;
let cates = '';
let rtJson;
var areaChart;
var traffic;
let mymark;
var selLats;
var selLngs;
// -----------------------------------------
var rate0;
var rate10;
var rate20;
var rate30;
var rate40;
var rate50;
var rate60; 
var rate70;
var male;
var female;
var resnt;
var nonResnt;
var congest;
var areaname;
var selectlat;
var selectlng;
//-----------------------------------------
var trafMark = [];
var fdMark = [];
var svMark = [];
var retaMark = [];
var arMark = [];


window.initMap = function () {
	 
			  const map = new google.maps.Map(document.getElementById("map"), {
			    center: { lat: 37.5400456, lng: 126.9921017 },
			    zoom: 11.8,
		
			    mapId: 'findGeo'
			  });
			  const options = {
				  method: 'GET',
				  headers: {accept: 'application/json', appKey: 'l7xx2d78afef8d7647288413de25f6dc43e5'}
			  };
			 var selLoc = "";
			  const RTloc = [
			    { label: "A", name: "광화문·덕수궁", lat: 37.5701758269873949, lng: 126.9770290287743677,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/광화문·덕수궁.jpg' },
			    { label: "A", name: "가산디지털단지역", lat: 37.481631531266494, lng: 126.8828464716437,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/가산디지털단지역.jpg' },
			    { label: "A", name: "경복궁·서촌마을", lat: 37.57984291352679, lng: 126.97328946157951,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/경복궁·서촌마을.jpg' },
			    { label: "A", name: "창덕궁·종묘", lat: 37.577594922983714, lng: 126.99421904681404,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/창덕궁·종묘.jpg'},
			    { label: "A", name: "강남 MICE 관광특구", lat: 37.51139584858334, lng: 127.0598901748247 ,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/강남 MICE 관광특구.jpg'},
			    { label: "A", name: "동대문 관광특구", lat: 37.56553339479549, lng: 127.01335269486151,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/동대문 관광특구.jpg'},
			    { label: "A", name: "명동 관광특구", lat: 37.56430824310635, lng: 126.98213839226364,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/명동 관광특구.jpg' },
			    { label: "A", name: "이태원 관광특구", lat: 37.534182850940134, lng: 126.99585715035037,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/이태원 관광특구.jpg' },
			    { label: "A", name: "잠실 관광특구", lat: 37.51572998546949, lng: 127.1106208455404,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/잠실 관광특구.jpg' },
			    { label: "A", name: "종로·청계 관광특구", lat: 37.56860711844535, lng: 126.99699476920193,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/종로·청계 관광특구.jpg' },
			    { label: "A", name: "홍대 관광특구", lat: 37.554186763087046, lng: 126.92167853659397,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/홍대 관광특구.jpg' },
			    { label: "A", name: "국립중앙박물관·용산가족공원", lat: 37.52307335452393, lng: 126.98017529033454,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/국립중앙박물관·용산가족공원.jpg' },
			    { label: "A", name: "남산공원", lat: 37.55086687995742, lng: 126.99364284291867,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/남산공원.jpg' },
			    { label: "A", name: "뚝섬한강공원", lat: 37.52980299850679, lng: 127.06848459110635,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/뚝섬한강공원.jpg' },
			    { label: "A", name: "망원한강공원", lat: 37.55191301250163, lng: 126.90009993326127,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/망원한강공원.jpg' },
			    { label: "A", name: "반포한강공원", lat: 37.509495233313906, lng: 126.99492420715372,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/반포한강공원.jpg' },
			    { label: "A", name: "북서울꿈의숲", lat: 37.620952809775886, lng: 127.03985178773338,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/북서울꿈의숲.jpg' },
			    { label: "A", name: "서울대공원", lat: 37.430417970238516, lng: 127.01439126516586,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/서울대공원.jpg' },
			    { label: "A", name: "서울숲공원", lat: 37.54423023812191, lng: 127.03748645613268,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/서울숲공원.jpg' },
			    { label: "A", name: "월드컵공원", lat: 37.56982369211536, lng: 126.88183162321674,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/월드컵공원.jpg' },
			    { label: "A", name: "이촌한강공원", lat: 37.5194868738881, lng: 126.96585010921682,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/이촌한강공원.jpg' },
			    { label: "A", name: "잠실종합운동장", lat: 37.515275045462595, lng: 127.07281175382138,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/잠실종합운동장.jpg' },
			    { label: "A", name: "잠실한강공원", lat: 37.51748123459748, lng: 127.0866465879202,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/잠실한강공원.jpg'},
			    { label: "A", name: "가로수길", lat: 37.521124302486854, lng: 127.02285723293289,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/가로수길.jpg' },
			    { label: "A", name: "낙산공원·이화마을", lat: 37.58078608289144, lng: 127.00655121224148,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/낙산공원·이화마을.jpg' },
			    { label: "A", name: "노량진", lat: 37.51383133465401, lng: 126.94295359838094,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/노량진.jpg' },
			    { label: "A", name: "북촌한옥마을", lat: 37.58142391139889, lng: 126.98491147830116,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/북촌한옥마을.jpg' },
			    { label: "A", name: "성수카페거리", lat: 37.54582965180822, lng: 127.05025675818062,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/성수카페거리.jpg' },
			    { label: "A", name: "수유리 먹자골목", lat: 37.64127855656912, lng: 127.0256567437706,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/수유리 먹자골목.jpg' },
			    { label: "A", name: "쌍문동 맛집거리", lat: 37.64753484172107, lng: 127.03390452341957,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/쌍문동 맛집거리.jpg' },
			    { label: "A", name: "압구정로데오거리", lat: 37.52544097597958, lng: 127.0377796867246,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/압구정로데오거리.jpg' },
			    { label: "A", name: "여의도", lat: 37.52520148760658, lng: 126.9244489204027,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/여의도.jpg' },
			    { label: "A", name: "영등포 타임스퀘어", lat: 37.51626472241912, lng: 126.90618385009164 ,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/영등포 타임스퀘어.jpg'},
			    { label: "A", name: "인사동·익선동", lat: 37.57332252132529, lng: 126.98714846139971,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/인사동·익선동.jpg' },
			    { label: "A", name: "창동 신경제 중심지", lat: 37.65496321017065, lng: 127.05488994001286,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/창동 신경제 중심지.jpg' },
			    { label: "A", name: "DMC(디지털미디어시티)", lat: 37.579641164297875, lng: 126.89208165788469,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/DMC(디지털미디어시티).jpg' },
			    { label: "A", name: "구로디지털단지역", lat: 37.484258374128444, lng: 126.89580387984323,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/구로디지털단지역.jpg' },
			    { label: "A", name: "강남역", lat: 37.49798861990043, lng: 127.02808697044497,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/강남역.jpg' },
			    { label: "A", name: "건대입구역", lat: 37.54031233151287, lng: 127.0683448155881,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/건대입구역.jpg' },
			    { label: "A", name: "고속터미널역", lat: 37.506094699822086, lng: 127.00535540254258,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/고속터미널역.jpg' },
			    { label: "A", name: "교대역", lat: 37.49278069302649, lng: 127.02144987992703,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/교대역.jpg' },
			    { label: "A", name: "서울역", lat: 37.55565506357903, lng: 126.97247604835474,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/서울역.jpg' },
			    { label: "A", name: "선릉역", lat: 37.5059635136923, lng: 127.04966460076305,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/선릉역.jpg' },
			    { label: "A", name: "신도림역", lat: 37.50926798061878, lng: 126.88868912534052,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/신도림역.jpg' },
			    { label: "A", name: "신림역", lat: 37.48381783560379, lng: 126.92978416890433,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/신림역.jpg' },
			    { label: "A", name: "신촌·이대역", lat: 37.55753940807936, lng: 126.93836099710354,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/신촌·이대역.jpg' },
			    { label: "A", name: "왕십리역", lat: 37.56084354547574, lng: 127.03574095121763,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/왕십리역.jpg' },
			    { label: "A", name: "역삼역", lat: 37.50081036749941, lng: 127.03607031279644,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/역삼역.jpg' },
			    { label: "A", name: "연신내역", lat: 37.619133355197896, lng: 126.92073783266778,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/연신내역.jpg' },
			    { label: "A", name: "용산역", lat: 37.52953539910786, lng: 126.9636943682725,img:'https://data.seoul.go.kr/SeoulRtd/images/hotspot/용산역.jpg' },
			  ];



			  RTloc.forEach(({ label, name, lat, lng ,img}) => {
				  let RTmarker = new google.maps.Marker({
									  position: { lat, lng },
								      label,
								      map: map
					});
				  let infoRT = new google.maps.InfoWindow(); 	
				  RTmarker.addListener("mouseover",()=>{
					  selLoc = name;
					  infoRT.setContent(
						  	'<div class="text-box">'+
						  		'<h4>'+selLoc+'</h4>'+
						  		'<div class="img-box">'+
						  			'<img src="'+img+'" style="width:250px; height:150px;">'+
						  		'</div>'
					  );
					  infoRT.open({
						anchor: RTmarker,
						map
					  });
				  });
				  RTmarker.addListener("mouseout", ()=>{
					  infoRT.close();
				  })
			 	  RTmarker.addListener("click", () => { //지도 정보 
			 	  					  const modal = document.getElementById("modal");
									  modal.style.display = "flex";
			 	  					  selLoc = name;
								      //map.panTo(RTmarker.position); //마커 위치로 중심 이동
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
										  //console.log(Object.keys(rtJson));
										  var rtcitydata = rtJson["SeoulRtd.citydata"];
										  var citydata = rtcitydata["CITYDATA"];
										  var liveStts = citydata["LIVE_PPLTN_STTS"];
										  var liveSt = liveStts["LIVE_PPLTN_STTS"];
										  var busStts = citydata["BUS_STN_STTS"];
										  var busSt = busStts["BUS_STN_STTS"];
										  console.log(liveSt);
										  //console.log(busSt);
										  var subStts = citydata["SUB_STTS"];
										  var subSt = subStts["SUB_STTS"];
										  //console.log(subSt);
										  var bikeStts = citydata["SBIKE_STTS"];
										  var bikeSt = bikeStts["SBIKE_STTS"];
										  //console.log(bikeSt);
										  areaname = citydata["AREA_NM"];
										  console.log(areaname);
										  rate0 = liveSt["PPLTN_RATE_0"];
										  rate10 = liveSt["PPLTN_RATE_10"];
										  rate20 = liveSt["PPLTN_RATE_20"];
										  rate30 = liveSt["PPLTN_RATE_30"];
										  rate40 = liveSt["PPLTN_RATE_40"];
										  rate50 = liveSt["PPLTN_RATE_50"];
										  rate60 = liveSt["PPLTN_RATE_60"];
										  rate70 = liveSt["PPLTN_RATE_70"];
										  
										  male = liveSt["MALE_PPLTN_RATE"];
										  female = liveSt["FEMALE_PPLTN_RATE"];
										  
										  resnt = liveSt["RESNT_PPLTN_RATE"];
										  nonResnt = liveSt["NON_RESNT_PPLTN_RATE"];
										  
										  congest = liveSt["AREA_CONGEST_LVL"];
										  var htmlCongest = document.getElementById("areaCongest");
										  htmlCongest.innerText = congest;
										  
										  var areaName = document.getElementById("areaName");
										  areaName.innerText = areaname;
										  
									  const map2 = new google.maps.Map(document.getElementById("map2"), {
										center: { lat: lat , lng: lng  },
										zoom: 14,
										gestureHandling: "cooperative",
										//zoomControl: false,
									  });
									function clear(){
										mymark.setMap(null);
									}
									var geocoder = new google.maps.Geocoder;
									function geocode(request){
										clear();
										geocoder.geocode(request)
												.then((result)=>{
													const{results}= result;
													
													map2.setCenter(results[0].geometry.location);
													mymark.setPosition(results[0].geometry.location);
													mymark.setMap(map2);
													return results;
											})
											.catch((e) => {
												alert("정확한 주소를 입력해주세요. : " + e);
											})
									}
									
									 map2.addListener("rightclick" , (e)=>{
										 var latlng = {
											 lat : e.latLng.lat(),
											 lng : e.latLng.lng()
										 }
										 selLats = latlng.lat;
									     selLngs = latlng.lng;
									     selectlat = selLats;
									     selectlng = selLngs;
										 clear();
										 mymark = new google.maps.Marker({
											position: { lat : latlng.lat, lng: latlng.lng },
   											animation: google.maps.Animation.DROP,
   											draggable: true,
											map : map2
										 });
									 })
									 const inputText = document.createElement("input");
									 inputText.type="text";
									 inputText.placeholder="위치를 검색하세요";
									 
									 const submitButton = document.createElement("input");
									 
									 submitButton.type="button";
									 submitButton.value = "Geocode";
									 submitButton.classList.add("button","button-primary");
									 
									 const clearButton = document.createElement("input");
									 
									 clearButton.type = "button";
								     clearButton.value = "Clear";
								     clearButton.classList.add("button", "button-secondary");
									
									 map2.controls[google.maps.ControlPosition.TOP_LEFT].push(inputText);
									 map2.controls[google.maps.ControlPosition.TOP_LEFT].push(submitButton);
									 map2.controls[google.maps.ControlPosition.TOP_LEFT].push(clearButton);
									 
									 mymark = new google.maps.Marker({
										 animation: google.maps.Animation.DROP,
										 draggable: true,
										 map2,
									 });
									 submitButton.addEventListener("click", ()=>{
										 geocode({address: inputText.value})
									 });
									 clearButton.addEventListener("click",()=>{
										 mymark.setMap(null);
									 })
										
									 $('#foodSelc').click(function(){
									    if(typeof selLats != "undefined" || typeof selLngs != "undefined"){
										 var foodsel = document.getElementById('foodData');
										 var selected = foodsel.options[foodsel.selectedIndex].value ;
									 	console.log(selected);
									 
											 fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+selLngs
										  		+'&centerLat='+selLats
										  		+'&categories='+selected
										  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										    .then(locCate => locCate.json())
										    .then(locCate => {
											  var poiInfo = locCate.searchPoiInfo.pois.poi;	
											  //console.log(locCate);
											  var icon;
											  switch(selected){
												  case "한식":
												   icon = new google.maps.MarkerImage("/images/korea_res_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "중식":
												   icon = new google.maps.MarkerImage("/images/ch_res_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "일식":
												   icon = new google.maps.MarkerImage("/images/jap_res_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "카페":
												   icon = new google.maps.MarkerImage("/images/cafe_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "패밀리레스토랑":
												   icon = new google.maps.MarkerImage("/images/family_res_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "전문음식점":
												   icon = new google.maps.MarkerImage("/images/restaurant_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "피자":
												   icon = new google.maps.MarkerImage("/images/pizza_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "치킨":
												   icon = new google.maps.MarkerImage("/images/chicken_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "디저트":
												   icon = new google.maps.MarkerImage("/images/dessert_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "제과점":
												   icon = new google.maps.MarkerImage("/images/bakery_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "패스트푸드":
												   icon = new google.maps.MarkerImage("/images/fastfood_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												   
												   
											  };
											  for(var i=0; i < poiInfo.length; i++){
												let searchMark = [
											    { icon: icon , name: poiInfo[i].name ,
											     lat: Number(poiInfo[i].frontLat),
											     lng: Number(poiInfo[i].frontLon) },
											  ];
											  //console.log(searchMark);
											  	  
												  fdMark.push(searchMark);
												  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
												
												  searchMark.forEach(({ icon, name, lat, lng }) => {
												      let marker = new google.maps.Marker({
												      position: { lat, lng },
												      icon,
   													  animation: google.maps.Animation.DROP,
												      map : map2
												    });
												   
												  
								
												    marker.addListener("mouseover",()=>{
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout",()=>{
														infowindow.close();
													})
												    marker.addListener("click", () => { //지도 정보 
												      map2.panTo(marker.position); //마커 위치로 중심 이동
												      infowindow.setContent(name);
												      
												    });	
												     $('#delMark2').click(function(){
														console.log("삭제");
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
											}else{
												alert("장소를 선택(검색) 해주세요");
											}
										
									});
								    
								    $('#serviceSelc').click(function(){
										 if(typeof selLats != "undefined" || typeof selLngs != "undefined"){
										 var servicesel = document.getElementById('serviceData');
										 var selected = servicesel.options[servicesel.selectedIndex].value ;
									 	console.log(selected);
									 
											 fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+selLngs
										  		+'&centerLat='+selLats
										  		+'&categories='+selected
										  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										    .then(locCate => locCate.json())
										    .then(locCate => {
											  var poiInfo = locCate.searchPoiInfo.pois.poi;	
											  //console.log(locCate);
											  var icon;
											  switch(selected){
												 
												   
											  };
											  for(var i=0; i < poiInfo.length; i++){
												let searchMark = [
											    { icon: icon , name: poiInfo[i].name ,
											     lat: Number(poiInfo[i].frontLat),
											     lng: Number(poiInfo[i].frontLon) },
											  ];
											  //console.log(searchMark);
											      svMark.push(searchMark);
												  
												  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
												
												  searchMark.forEach(({ icon, name, lat, lng }) => {
												      let marker = new google.maps.Marker({
												      position: { lat, lng },
												      icon,
   													  animation: google.maps.Animation.DROP,
												      map : map2
												    });
												   
								
												    marker.addListener("mouseover",()=>{
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout",()=>{
														infowindow.close();
													})
												    marker.addListener("click", () => { //지도 정보 
												      map2.panTo(marker.position); //마커 위치로 중심 이동
												      infowindow.setContent(name);
												      
												    });	
												     $('#delMark2').click(function(){
														console.log("삭제");
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
										}else{
											alert("장소를 선택(검색) 해주세요");
										}
									});
									$('#retailSelc').click(function(){
									    if(typeof selLats != "undefined" || typeof selLngs != "undefined"){
										 var retailsel = document.getElementById('retailData');
										 var selected = retailsel.options[retailsel.selectedIndex].value ;
									 	console.log(selected);
									 
											 fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+selLngs
										  		+'&centerLat='+selLats
										  		+'&categories='+selected
										  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										    .then(locCate => locCate.json())
										    .then(locCate => {
											  var poiInfo = locCate.searchPoiInfo.pois.poi;	
											  //console.log(locCate);
											  var icon;
											  switch(selected){
												 
												   
											  };
											  for(var i=0; i < poiInfo.length; i++){
												let searchMark = [
											    { icon: icon , name: poiInfo[i].name ,
											     lat: Number(poiInfo[i].frontLat),
											     lng: Number(poiInfo[i].frontLon) },
											  ];
											  //console.log(searchMark);
											     retaMark.push(searchMark);
												  
												  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
												
												  searchMark.forEach(({ icon, name, lat, lng }) => {
												      let marker = new google.maps.Marker({
												      position: { lat, lng },
												      icon,
   													  animation: google.maps.Animation.DROP,
												      map : map2
												    });
												   
								
												    marker.addListener("mouseover",()=>{
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout",()=>{
														infowindow.close();
													})
												    marker.addListener("click", () => { //지도 정보 
												      map2.panTo(marker.position); //마커 위치로 중심 이동
												      infowindow.setContent(name);
												      
												    });	
												     $('#delMark2').click(function(){
														console.log("삭제");
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
										}else{
											alert("장소를 선택(검색) 해주세요");
										}
									});
									
									$('#areaSelc').click(function(){
									    if(typeof selLats != "undefined" || typeof selLngs != "undefined"){
										 var areasel = document.getElementById('areaData');
										 var selected = areasel.options[areasel.selectedIndex].value ;
									 	console.log(selected);
									 
											 fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+selLngs
										  		+'&centerLat='+selLats
										  		+'&categories='+selected
										  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										    .then(locCate => locCate.json())
										    .then(locCate => {
											  var poiInfo = locCate.searchPoiInfo.pois.poi;	
											  //console.log(locCate);
											  var icon;
											  switch(selected){
												 
												   
											  };
											  for(var i=0; i < poiInfo.length; i++){
												let searchMark = [
											    { icon: icon , name: poiInfo[i].name ,
											     lat: Number(poiInfo[i].frontLat),
											     lng: Number(poiInfo[i].frontLon) },
											  ];
											  //console.log(searchMark);
											   arMark.push(searchMark);
												  
												  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
												
												  searchMark.forEach(({ icon, name, lat, lng }) => {
												      let marker = new google.maps.Marker({
												      position: { lat, lng },
												      icon,
   													  animation: google.maps.Animation.DROP,
												      map : map2
												    });
												   
								
												    marker.addListener("mouseover",()=>{
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout",()=>{
														infowindow.close();
													})
												    marker.addListener("click", () => { //지도 정보 
												      map2.panTo(marker.position); //마커 위치로 중심 이동
												      infowindow.setContent(name);
												      
												    });	
												     $('#delMark2').click(function(){
														console.log("삭제");
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
										}else{
											alert("장소를 선택(검색) 해주세요");
										}
									});
									

									 $('#trafficSelc').click(function(){
									    if(typeof selLats != "undefined" || typeof selLngs != "undefined"){	
										 var select = document.getElementById('trafficData');
										 var selected = select.options[select.selectedIndex].value;
									 	console.log(selected);
									 
											 fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon='+selLngs
										  		+'&centerLat='+selLats
										  		+'&categories='+selected
										  		+'&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										    .then(locCate => locCate.json())
										    .then(locCate => {
											  var poiInfo = locCate.searchPoiInfo.pois.poi;	
											  //console.log(locCate);
											  var icon;
											  switch(selected){
												  case "지하철":
												   icon = new google.maps.MarkerImage("/images/subway_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "버스정류장":
												   icon = new google.maps.MarkerImage("/images/bus_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "주차장":
												   icon = new google.maps.MarkerImage("/images/parking_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "주유소":
												   icon = new google.maps.MarkerImage("/images/gas_station_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "충전소":
												   icon = new google.maps.MarkerImage("/images/charge_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "EV충전소":
												   icon = new google.maps.MarkerImage("/images/ev_charger_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
												  case "EV충전소/가스충전소":
												  icon = new google.maps.MarkerImage("/images/ev_charger_icon.png", null, null, null, new google.maps.Size(35,35));
												   break;
											  }
											  for(var i=0; i < poiInfo.length; i++){
												let searchMark = [
											    { icon: icon , name: poiInfo[i].name ,
											     lat: Number(poiInfo[i].frontLat),
											     lng: Number(poiInfo[i].frontLon) },
											  ];
											  //console.log(searchMark);
											     
												  trafMark.push(searchMark);
												  const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기
												 
												  searchMark.forEach(({ icon, name, lat, lng }) => {
												      let marker = new google.maps.Marker({
												      position: { lat, lng },
												      icon,
   													  animation: google.maps.Animation.DROP,
												      map : map2
												    });
												   
													marker.addListener("mouseover",()=>{
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout",()=>{
														infowindow.close();
													})
												    marker.addListener("click", () => { //지도 정보 
												      map2.panTo(marker.position); //마커 위치로 중심 이동
												      infowindow.setContent(name);
												      
												    });	
												     $('#delMark2').click(function(){
														console.log("삭제");
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
											}else{
												alert("장소를 선택(검색) 해주세요");
											}
										});
									
							
								
									ctx1 = document.getElementById("bar-chart-horizontal");
									ctx2 = document.getElementById("pieChart");
									ctx3 = document.getElementById("resntChart");
									config1 = {
										type: 'bar',
										data: {
										labels: ["0~10세", "10대", "20대", "30대", "40대", "50대", "60대", "70대"],
										datasets:[
													{
														label: "나이별 인구 비율",
														backgroundColor: ["red","orange","yellow","green","blue","purple","white","black"],
														data: [rate0,rate10,rate20,rate30,rate40,rate50,rate60,rate70]
													}
												]
										},
										options: {
										indexAxis: 'y',
										legend: { display: false },
										title: {
												  display: true,
												  text: '유동인구별 나이 비율'
												}
											}
									};
									config2 = {
										type: 'pie',
										data: {
											labels: ['남성','여성'],
											datasets: [{
												data: [male,female],
												backgroundColor: ["skyblue","pink"]
											}]
										},
										options: {
											responsive : false
										}
										
									};
									config3 = {
										type: 'pie',
										data: {
											labels: ["거주","비거주"],
											datasets: [{
												data: [resnt, nonResnt],
												backgroundColor: ['white','black']
											}]
										},
										options:{
											responsive: false
										}
									}
									areaAgeChart = new Chart(ctx1,config1);
									genderChart = new Chart(ctx2,config2);
									resntChart = new Chart(ctx3,config3);
									
										const closeBtn = modal.querySelector('.close-area');
										closeBtn.addEventListener("click", e => {
											areaAgeChart.destroy();
											genderChart.destroy();
											resntChart.destroy();
											modal.style.display="none";											
											
										});
										modal.addEventListener("click", e => {
										const evTarget = e.target
										if(evTarget.classList.contains("modal-overlay")) {
											areaAgeChart.destroy();
											genderChart.destroy();
											resntChart.destroy();
											modal.style.display = "none"
											}
										})
										  
									  };
							}};xhr.send('');
					 });	
			  });
			  
};

function saveInfo(){
	var data = {
            email : $("#email").val(),
			areaname : areaname,
			rate0 : rate0,
			rate10 : rate10,
			rate20 : rate20,
			rate30 : rate30,
			rate40 : rate40,
			rate50 : rate50,
			rate60 : rate60,
			rate70 : rate70,
			male : male,
			female : female,
			nonResnt : nonResnt,
			congest : congest,
			selectlat : selectlat,
			selectlng : selectlng,
			areaData : {
				trafMark : trafMark,
				fdMark : fdMark,
				svMark : svMark,
				retaMark : retaMark,
				arMark : arMark,
			}
			
        };
    console.log(data);
    console.log(data.areaData);
    var email = $("#email").val();
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        beforeSend: function(xhr){
        xhr.setRequestHeader(header,token);
   		},
        type : 'POST',
        url : 'members/clipping/'+email,
        dataType : 'json',
        contentType : 'application/json; charset=utf-8',
        data : JSON.stringify(data)
    }).done(function(){
        alert('스크랩 완료');
        window.location.href = 'redirect:/'
    }).fail(function(error){
        alert(JSON.stringify(error));
    })
}

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
  function drop() {
  for (var i =0; i < markerArray.length; i++) {
    setTimeout(function() {
      addMarkerMethod();
    }, i * 200);
  }
}