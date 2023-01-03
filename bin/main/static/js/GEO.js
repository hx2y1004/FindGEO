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
var nonresnt;
var congest;
var areaname;
var selectlat;
var selectlng;
var category;
var seloption;
var areacate = "";
var areaoption;
var trafcate = "";
var trafoption;
//-----------------------------------------
var trafMark = [];
var fdMark = [];
var svMark = [];
var retaMark = [];
var arMark = [];
//----------------------------------------
var traflat = [];
var traflng = [];
var fdlat = [];
var fdlng = [];
var svlat = [];
var svlng = [];
var retalat = [];
var retalng = [];
var arlat = [];
var arlng = [];
// ------------------------------------------
var areascore;
var fdlength;
var svlength;
var retalength;
var traflength;
var arlength;
var areagrade;


window.initMap = function() {
	const map = new google.maps.Map(document.getElementById("map"), {
		center: { lat: 37.5400456, lng: 126.9921017 },
		zoom: 11.8,

		mapId: 'findGeo'
	});
	const options = {
		method: 'GET',
		headers: { accept: 'application/json', appKey: 'l7xx2d78afef8d7647288413de25f6dc43e5' }
	};
	var selLoc = "";
	const RTloc = [
		{ label: "광", name: "광화문·덕수궁", lat: 37.5701758269873949, lng: 126.9770290287743677, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/광화문·덕수궁.jpg' },
		{ label: "가", name: "가산디지털단지역", lat: 37.481631531266494, lng: 126.8828464716437, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/가산디지털단지역.jpg' },
		{ label: "경", name: "경복궁·서촌마을", lat: 37.57984291352679, lng: 126.97328946157951, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/경복궁·서촌마을.jpg' },
		{ label: "창", name: "창덕궁·종묘", lat: 37.577594922983714, lng: 126.99421904681404, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/창덕궁·종묘.jpg' },
		{ label: "M", name: "강남 MICE 관광특구", lat: 37.51139584858334, lng: 127.0598901748247, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/강남 MICE 관광특구.jpg' },
		{ label: "동", name: "동대문 관광특구", lat: 37.56553339479549, lng: 127.01335269486151, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/동대문 관광특구.jpg' },
		{ label: "명", name: "명동 관광특구", lat: 37.56430824310635, lng: 126.98213839226364, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/명동 관광특구.jpg' },
		{ label: "이", name: "이태원 관광특구", lat: 37.534182850940134, lng: 126.99585715035037, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/이태원 관광특구.jpg' },
		{ label: "잠", name: "잠실 관광특구", lat: 37.51572998546949, lng: 127.1106208455404, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/잠실 관광특구.jpg' },
		{ label: "종", name: "종로·청계 관광특구", lat: 37.56860711844535, lng: 126.99699476920193, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/종로·청계 관광특구.jpg' },
		{ label: "홍", name: "홍대 관광특구", lat: 37.554186763087046, lng: 126.92167853659397, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/홍대 관광특구.jpg' },
		{ label: "국", name: "국립중앙박물관·용산가족공원", lat: 37.52307335452393, lng: 126.98017529033454, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/국립중앙박물관·용산가족공원.jpg' },
		{ label: "남", name: "남산공원", lat: 37.55086687995742, lng: 126.99364284291867, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/남산공원.jpg' },
		{ label: "뚝", name: "뚝섬한강공원", lat: 37.52980299850679, lng: 127.06848459110635, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/뚝섬한강공원.jpg' },
		{ label: "망", name: "망원한강공원", lat: 37.55191301250163, lng: 126.90009993326127, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/망원한강공원.jpg' },
		{ label: "반", name: "반포한강공원", lat: 37.509495233313906, lng: 126.99492420715372, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/반포한강공원.jpg' },
		{ label: "북", name: "북서울꿈의숲", lat: 37.620952809775886, lng: 127.03985178773338, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/북서울꿈의숲.jpg' },
		{ label: "서", name: "서울대공원", lat: 37.430417970238516, lng: 127.01439126516586, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/서울대공원.jpg' },
		{ label: "서", name: "서울숲공원", lat: 37.54423023812191, lng: 127.03748645613268, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/서울숲공원.jpg' },
		{ label: "월", name: "월드컵공원", lat: 37.56982369211536, lng: 126.88183162321674, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/월드컵공원.jpg' },
		{ label: "이", name: "이촌한강공원", lat: 37.5194868738881, lng: 126.96585010921682, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/이촌한강공원.jpg' },
		{ label: "잠", name: "잠실종합운동장", lat: 37.515275045462595, lng: 127.07281175382138, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/잠실종합운동장.jpg' },
		{ label: "잠", name: "잠실한강공원", lat: 37.51748123459748, lng: 127.0866465879202, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/잠실한강공원.jpg' },
		{ label: "가", name: "가로수길", lat: 37.521124302486854, lng: 127.02285723293289, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/가로수길.jpg' },
		{ label: "낙", name: "낙산공원·이화마을", lat: 37.58078608289144, lng: 127.00655121224148, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/낙산공원·이화마을.jpg' },
		{ label: "노", name: "노량진", lat: 37.51383133465401, lng: 126.94295359838094, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/노량진.jpg' },
		{ label: "북", name: "북촌한옥마을", lat: 37.58142391139889, lng: 126.98491147830116, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/북촌한옥마을.jpg' },
		{ label: "성", name: "성수카페거리", lat: 37.54582965180822, lng: 127.05025675818062, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/성수카페거리.jpg' },
		{ label: "수", name: "수유리 먹자골목", lat: 37.64127855656912, lng: 127.0256567437706, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/수유리 먹자골목.jpg' },
		{ label: "쌍", name: "쌍문동 맛집거리", lat: 37.64753484172107, lng: 127.03390452341957, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/쌍문동 맛집거리.jpg' },
		{ label: "압", name: "압구정로데오거리", lat: 37.52544097597958, lng: 127.0377796867246, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/압구정로데오거리.jpg' },
		{ label: "여", name: "여의도", lat: 37.52520148760658, lng: 126.9244489204027, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/여의도.jpg' },
		{ label: "영", name: "영등포 타임스퀘어", lat: 37.51626472241912, lng: 126.90618385009164, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/영등포 타임스퀘어.jpg' },
		{ label: "인", name: "인사동·익선동", lat: 37.57332252132529, lng: 126.98714846139971, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/인사동·익선동.jpg' },
		{ label: "창", name: "창동 신경제 중심지", lat: 37.65496321017065, lng: 127.05488994001286, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/창동 신경제 중심지.jpg' },
		{ label: "D", name: "DMC(디지털미디어시티)", lat: 37.579641164297875, lng: 126.89208165788469, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/DMC(디지털미디어시티).jpg' },
		{ label: "구", name: "구로디지털단지역", lat: 37.484258374128444, lng: 126.89580387984323, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/구로디지털단지역.jpg' },
		{ label: "강", name: "강남역", lat: 37.49798861990043, lng: 127.02808697044497, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/강남역.jpg' },
		{ label: "건", name: "건대입구역", lat: 37.54031233151287, lng: 127.0683448155881, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/건대입구역.jpg' },
		{ label: "고", name: "고속터미널역", lat: 37.506094699822086, lng: 127.00535540254258, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/고속터미널역.jpg' },
		{ label: "교", name: "교대역", lat: 37.49278069302649, lng: 127.02144987992703, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/교대역.jpg' },
		{ label: "서", name: "서울역", lat: 37.55565506357903, lng: 126.97247604835474, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/서울역.jpg' },
		{ label: "선", name: "선릉역", lat: 37.5059635136923, lng: 127.04966460076305, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/선릉역.jpg' },
		{ label: "신", name: "신도림역", lat: 37.50926798061878, lng: 126.88868912534052, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/신도림역.jpg' },
		{ label: "신", name: "신림역", lat: 37.48381783560379, lng: 126.92978416890433, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/신림역.jpg' },
		{ label: "신", name: "신촌·이대역", lat: 37.55753940807936, lng: 126.93836099710354, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/신촌·이대역.jpg' },
		{ label: "왕", name: "왕십리역", lat: 37.56084354547574, lng: 127.03574095121763, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/왕십리역.jpg' },
		{ label: "역", name: "역삼역", lat: 37.50081036749941, lng: 127.03607031279644, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/역삼역.jpg' },
		{ label: "연", name: "연신내역", lat: 37.619133355197896, lng: 126.92073783266778, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/연신내역.jpg' },
		{ label: "용", name: "용산역", lat: 37.52953539910786, lng: 126.9636943682725, img: 'https://data.seoul.go.kr/SeoulRtd/images/hotspot/용산역.jpg' },
	];



	RTloc.forEach(({ label, name, lat, lng, img }) => {
		let RTmarker = new google.maps.Marker({
			position: { lat, lng },
			label,
			map: map
		});
		let infoRT = new google.maps.InfoWindow();
		RTmarker.addListener("mouseover", () => {
			selLoc = name;
			infoRT.setContent(
				'<div class="text-box">' +
				'<h4>' + selLoc + '</h4>' +
				'<div class="img-box">' +
				'<img src="' + img + '" style="width:250px; height:150px;">' +
				'</div>'
			);
			infoRT.open({
				anchor: RTmarker,
				map
			});
		});
		RTmarker.addListener("mouseout", () => {
			infoRT.close();
		})
		RTmarker.addListener("click", () => { //지도 정보 
			const modal = document.getElementById("modal");
			modal.style.display = "flex";
			document.getElementById("modal1").style.display = "flex";
			document.getElementById("modal2").style.display = "none";

			document.getElementById("checkp").style.display = "none";
			document.getElementById("checkpp").style.display = "block";
			document.getElementById("checkppn").style.display = "block";
			selLoc = name;
			console.log(selLoc);
			//map.panTo(RTmarker.position); //마커 위치로 중심 이동
			infoRT.setContent(name);
			infoRT.open({
				anchor: RTmarker,
				map
			});
			var xhr = new XMLHttpRequest();
			var url = 'http://openapi.seoul.go.kr:8088/6b797a4d7a677573373961756c5169/xml/citydata/1/5/' + selLoc; /*URL*/
			xhr.open('GET', url);
			xhr.onreadystatechange = function() {
				document.getElementById("checkpp").style.display = "none";
				document.getElementById("checkppn").style.display = "none";
				document.getElementById("checkp").style.display = "block";
				if (this.readyState == xhr.DONE) {  // <== 정상적으로 준비되었을때 
					if (xhr.status == 200 || xhr.status == 201) { // <== 호출 상태가 정상적일때 


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
						nonresnt = liveSt["NON_RESNT_PPLTN_RATE"];

						congest = liveSt["AREA_CONGEST_LVL"];
						var htmlCongest = document.getElementById("areaCongest");
						htmlCongest.innerText = congest;
						if (congest === '붐빔') {
							htmlCongest.style.color = 'red';
						} else if (congest === '약간 붐빔') {
							htmlCongest.style.color = 'orange';
						} else if (congest === '보통') {
							htmlCongest.style.color = 'yellow';
						} else if (congest === '여유') {
							htmlCongest.style.color = 'green';
						}

						var areaName = document.getElementById("areaName");
						areaName.innerText = areaname;


						const map2 = new google.maps.Map(document.getElementById("map2"), {
							center: { lat: lat, lng: lng },
							zoom: 14,
							gestureHandling: "cooperative",
							//zoomControl: false,
						});
						function clear() {
							mymark.setMap(null);
						}
						var geocoder = new google.maps.Geocoder;
						function geocode(request) {
							clear();
							geocoder.geocode(request)
								.then((result) => {
									const { results } = result;

									map2.setCenter(results[0].geometry.location);
									mymark.setPosition(results[0].geometry.location);
									console.log(JSON.stringify(results[0].geometry) + "검색");
									var resLocation = JSON.stringify(results[0].geometry.location);
									mymark.setAnimation(google.maps.Animation.DROP);
									selLats = JSON.parse(resLocation).lat;
									selLngs = JSON.parse(resLocation).lng;
									mymark.setMap(map2);

									return results;
								})
								.catch((e) => {
									alert("정확한 주소를 입력해주세요. : " + e);
								})
						}

						map2.addListener("rightclick", (e) => {
							var latlng = {
								lat: e.latLng.lat(),
								lng: e.latLng.lng()
							}
							selLats = latlng.lat;
							selLngs = latlng.lng;
							selectlat = selLats;
							selectlng = selLngs;
							clear();
							mymark = new google.maps.Marker({
								position: { lat: latlng.lat, lng: latlng.lng },
								animation: google.maps.Animation.DROP,
								draggable: true,
								map: map2
							});
						})

						const inputText = document.createElement("input");
						inputText.type = "text";
						inputText.placeholder = "위치를 검색하세요";

						const submitButton = document.createElement("input");

						submitButton.type = "button";
						submitButton.value = "검색하기";
						submitButton.classList.add("button", "button-primary");

						const clearButton = document.createElement("input");

						clearButton.type = "button";
						clearButton.value = "삭제하기";
						clearButton.classList.add("button", "button-secondary");

						map2.controls[google.maps.ControlPosition.TOP_LEFT].push(inputText);
						map2.controls[google.maps.ControlPosition.TOP_LEFT].push(submitButton);
						map2.controls[google.maps.ControlPosition.TOP_LEFT].push(clearButton);

						mymark = new google.maps.Marker({
							animation: google.maps.Animation.DROP,
							draggable: true,
							map2,
						});
						submitButton.addEventListener("click", () => {
							geocode({ address: inputText.value })
						});
						clearButton.addEventListener("click", () => {
							mymark.setMap(null);
						})

						$('#foodSelc').click(function() {
							if (typeof selLats != "undefined" || typeof selLngs != "undefined") {
								var foodsel = document.getElementById('foodData');
								var selected = foodsel.options[foodsel.selectedIndex].value;
								console.log(selected);
								category = "food";
								seloption = selected;
								if (selLats === null || selLngs === null) {
									console.log("삭제");
									fdlength = 0;
									alert("찾으시는 지역을 우클릭 해주세요");
									none;
								} else {
									fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon=' + selLngs
										+ '&centerLat=' + selLats
										+ '&categories=' + selected
										+ '&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										.then(locCate => locCate.json())
										.then(locCate => {
											var poiInfo = locCate.searchPoiInfo.pois.poi;
											//console.log(locCate);
											var icon;
											switch (selected) {
												case "음식점":
													alert("카테고리를 선택해주세요");
													none;
													break;
												case "한식":
													icon = new google.maps.MarkerImage("/images/한식.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "중식":
													icon = new google.maps.MarkerImage("/images/중식.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "일식":
													icon = new google.maps.MarkerImage("/images/일식.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "카페":
													icon = new google.maps.MarkerImage("/images/카페.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "패밀리레스토랑":
													icon = new google.maps.MarkerImage("/images/패밀리레스토랑.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "전문음식점":
													icon = new google.maps.MarkerImage("/images/전문음식점.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "피자":
													icon = new google.maps.MarkerImage("/images/피자.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "치킨":
													icon = new google.maps.MarkerImage("/images/치킨.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "디저트":
													icon = new google.maps.MarkerImage("/images/디저트.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "제과점":
													icon = new google.maps.MarkerImage("/images/제과점.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "패스트푸드":
													icon = new google.maps.MarkerImage("/images/패스트푸드.png", null, null, null, new google.maps.Size(35, 35));
													break;


											};
											//let marker = []
											for (var i = 0; i < poiInfo.length; i++) {
												let searchMark = [
													{
														icon: icon, name: poiInfo[i].name,
														lat: Number(poiInfo[i].frontLat),
														lng: Number(poiInfo[i].frontLon)
													},
												];
												//console.log(searchMark);
												fdlength = poiInfo.length;
												console.log(poiInfo.length);

												fdlat.push(Number(poiInfo[i].frontLat));
												fdlng.push(Number(poiInfo[i].frontLon));

												const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기

												searchMark.forEach(({ icon, name, lat, lng }) => {
													let marker = new google.maps.Marker({
														position: { lat, lng },
														icon,
														animation: google.maps.Animation.DROP,
														map: map2
													});


													marker.addListener("mouseover", () => {
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout", () => {
														infowindow.close();
													})
													marker.addListener("click", () => { //지도 정보 
														map2.panTo(marker.position); //마커 위치로 중심 이동
														infowindow.setContent(name);

													});
													$('#delMark2').click(function() {
														console.log("삭제");
														fdlength = 0;
														searchMark.forEach(() => {
															fdlat.splice(0);
															fdlng.splice(0);
															marker.setMap(null);
														})

													});

												})
											}

										})
										.catch((err) => { alert("해당 장소가 없습니다."); }
										);
								}
							} else {
								alert("장소를 선택(검색) 해주세요");
							}

						});

						$('#serviceSelc').click(function() {
							if (typeof selLats != "undefined" || typeof selLngs != "undefined") {
								var servicesel = document.getElementById('serviceData');

								var selected = servicesel.options[servicesel.selectedIndex].value;
								if (selected === "병원") {
									selected = "병원;내과;안과;외과;의원";
								}
								console.log(selected);
								category = "service";
								seloption = selected;
								if (selLats === null || selLngs === null) {
									svlength = 0;
									console.log("삭제");

									alert("찾으시는 지역을 우클릭 해주세요");
									none;
								} else {
									fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon=' + selLngs
										+ '&centerLat=' + selLats
										+ '&categories=' + selected
										+ '&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										.then(locCate => locCate.json())
										.then(locCate => {
											var poiInfo = locCate.searchPoiInfo.pois.poi;
											//console.log(locCate);
											var icon;
											switch (selected) {
												case "서비스업":
													alert("카테고리를 선택해주세요");
													none;
													break;
												case "목욕탕":
													icon = new google.maps.MarkerImage("/images/목욕탕.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "미용실":
													icon = new google.maps.MarkerImage("/images/미용실.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "이발소":
													icon = new google.maps.MarkerImage("/images/이발소.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "호텔":
													icon = new google.maps.MarkerImage("/images/호텔.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "병원;내과;안과;외과;의원":
													icon = new google.maps.MarkerImage("/images/병원.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "치과":
													icon = new google.maps.MarkerImage("/images/치과.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "보건소":
													icon = new google.maps.MarkerImage("/images/보건소.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "한의원":
													icon = new google.maps.MarkerImage("/images/한의원.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "영화관":
													icon = new google.maps.MarkerImage("/images/영화관.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "약국":
													icon = new google.maps.MarkerImage("/images/약국.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "노래방":
													icon = new google.maps.MarkerImage("/images/노래방.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "PC방":
													icon = new google.maps.MarkerImage("/images/PC방.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "스크린골프장":
													icon = new google.maps.MarkerImage("/images/스크린골프장.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "은행":
													icon = new google.maps.MarkerImage("/images/BANK.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "정비소":
													icon = new google.maps.MarkerImage("/images/정비소.png", null, null, null, new google.maps.Size(35, 35));
													break;
											};
											for (var i = 0; i < poiInfo.length; i++) {
												let searchMark = [
													{
														icon: icon, name: poiInfo[i].name,
														lat: Number(poiInfo[i].frontLat),
														lng: Number(poiInfo[i].frontLon)
													},
												];
												//console.log(searchMark);
												svlength = poiInfo.length;
												svlat.push(Number(poiInfo[i].frontLat));
												svlng.push(Number(poiInfo[i].frontLon));

												const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기

												searchMark.forEach(({ icon, name, lat, lng }) => {
													let marker = new google.maps.Marker({
														position: { lat, lng },
														icon,
														animation: google.maps.Animation.DROP,
														map: map2
													});


													marker.addListener("mouseover", () => {
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout", () => {
														infowindow.close();
													})
													marker.addListener("click", () => { //지도 정보 
														map2.panTo(marker.position); //마커 위치로 중심 이동
														infowindow.setContent(name);

													});
													$('#delMark2').click(function() {
														svlength = 0;
														console.log("삭제");
														searchMark.forEach(() => {
															svlat.splice(0);
															svlng.splice(0);
															marker.setMap(null);
														})

													});
												})
											}

										})
										.catch(
											//err => console.error(err)
											alert("해당 장소가 없습니다.")
										);
								}
							} else {
								alert("장소를 선택(검색) 해주세요");
							}
						});

						$('#retailSelc').click(function() {
							if (typeof selLats != "undefined" || typeof selLngs != "undefined") {
								var retailsel = document.getElementById('retailData');
								var selected = retailsel.options[retailsel.selectedIndex].value;
								console.log(selected);
								category = "reta";
								seloption = selected;
								if (selLats === null || selLngs === null) {
									retalength = 0;
									console.log("삭제");

									alert("찾으시는 지역을 우클릭 해주세요");
									none;
								} else {
									fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon=' + selLngs
										+ '&centerLat=' + selLats
										+ '&categories=' + selected
										+ '&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										.then(locCate => locCate.json())
										.then(locCate => {
											var poiInfo = locCate.searchPoiInfo.pois.poi;
											//console.log(locCate);
											var icon;
											switch (selected) {
												case "도/소매업":
													alert("카테고리를 선택해주세요");
													none;
													break;
												case "쇼핑":
													icon = new google.maps.MarkerImage("/images/쇼핑.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "편의점":
													icon = new google.maps.MarkerImage("/images/편의점.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "대형마트":
													icon = new google.maps.MarkerImage("/images/대형마트.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "마트":
													icon = new google.maps.MarkerImage("/images/마트.png", null, null, null, new google.maps.Size(35, 35));
													break;
											};
											for (var i = 0; i < poiInfo.length; i++) {
												let searchMark = [
													{
														icon: icon, name: poiInfo[i].name,
														lat: Number(poiInfo[i].frontLat),
														lng: Number(poiInfo[i].frontLon)
													},
												];
												//console.log(searchMark);
												retalength = poiInfo.length;
												retalat.push(Number(poiInfo[i].frontLat));
												retalng.push(Number(poiInfo[i].frontLon));

												const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기

												searchMark.forEach(({ icon, name, lat, lng }) => {
													let marker = new google.maps.Marker({
														position: { lat, lng },
														icon,
														animation: google.maps.Animation.DROP,
														map: map2
													});


													marker.addListener("mouseover", () => {
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout", () => {
														infowindow.close();
													})
													marker.addListener("click", () => { //지도 정보 
														map2.panTo(marker.position); //마커 위치로 중심 이동
														infowindow.setContent(name);

													});
													$('#delMark2').click(function() {
														retalength = 0;
														console.log("삭제");
														searchMark.forEach(() => {
															retalat.splice(0);
															retalng.splice(0);
															marker.setMap(null);
														})

													});
												})
											}

										})
										.catch(
											//err => console.error(err)
											alert("해당 장소가 없습니다.")
										);
								}
							} else {
								alert("장소를 선택(검색) 해주세요");
							}
						});

						$('#areaSelc').click(function() {
							if (typeof selLats != "undefined" || typeof selLngs != "undefined") {
								var areasel = document.getElementById('areaData');
								var selected = areasel.options[areasel.selectedIndex].value;
								console.log(selected);

								areacate = "area";
								areaoption = selected;
								if (selLats === null || selLngs === null) {
									console.log("삭제");
									alert("찾으시는 지역을 우클릭 해주세요");
									none;
								} else {
									fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon=' + selLngs
										+ '&centerLat=' + selLats
										+ '&categories=' + selected
										+ '&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										.then(locCate => locCate.json())
										.then(locCate => {
											var poiInfo = locCate.searchPoiInfo.pois.poi;
											//console.log(locCate);
											var icon;
											switch (selected) {
												case "지역정보":
													alert("카테고리를 선택해주세요");
													none;
													break;
												case "관공서":
													icon = new google.maps.MarkerImage("/images/관공서.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "주요시설물":
													icon = new google.maps.MarkerImage("/images/주요시설물.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "ATM":
													icon = new google.maps.MarkerImage("/images/ATM.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "화장실":
													icon = new google.maps.MarkerImage("/images/화장실.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "공연장":
													icon = new google.maps.MarkerImage("/images/공연장.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "공원":
													icon = new google.maps.MarkerImage("/images/공원.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "문화시설":
													icon = new google.maps.MarkerImage("/images/지하철.png", null, null, null, new google.maps.Size(35, 35));
													break;
											};
											for (var i = 0; i < poiInfo.length; i++) {
												let searchMark = [
													{
														icon: icon, name: poiInfo[i].name,
														lat: Number(poiInfo[i].frontLat),
														lng: Number(poiInfo[i].frontLon)
													},
												];
												//console.log(searchMark);
												arlength = poiInfo.length;
												arlat.push(Number(poiInfo[i].frontLat));
												arlng.push(Number(poiInfo[i].frontLon));

												const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기

												searchMark.forEach(({ icon, name, lat, lng }) => {
													let marker = new google.maps.Marker({
														position: { lat, lng },
														icon,
														animation: google.maps.Animation.DROP,
														map: map2
													});


													marker.addListener("mouseover", () => {
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout", () => {
														infowindow.close();
													})
													marker.addListener("click", () => { //지도 정보 
														map2.panTo(marker.position); //마커 위치로 중심 이동
														infowindow.setContent(name);

													});
													$('#delMark2').click(function() {
														console.log("삭제");
														searchMark.forEach(() => {
															arlat.splice(0);
															arlng.splice(0);
															marker.setMap(null);
														})

													});
												})
											}

										})
										.catch(
											//err => console.error(err)
											alert("해당 장소가 없습니다.")
										);
								}
							} else {
								alert("장소를 선택(검색) 해주세요");
							}
						});


						$('#trafficSelc').click(function() {
							if (typeof selLats != "undefined" || typeof selLngs != "undefined") {
								var select = document.getElementById('trafficData');
								var selected = select.options[select.selectedIndex].value;
								console.log(selected);

								trafcate = "traf";
								trafoption = selected;
								if (selLats === null || selLngs === null) {
									console.log("삭제");
									alert("찾으시는 지역을 우클릭 해주세요");
									none;
								} else {
									fetch('https://apis.openapi.sk.com/tmap/pois/search/around?version=1&centerLon=' + selLngs
										+ '&centerLat=' + selLats
										+ '&categories=' + selected
										+ '&page=1&count=100&radius=1&reqCoordType=WGS84GEO&resCoordType=WGS84GEO&multiPoint=N', options)
										.then(locCate => locCate.json())
										.then(locCate => {
											var poiInfo = locCate.searchPoiInfo.pois.poi;
											//console.log(locCate);
											var icon;
											switch (selected) {
												case "교통정보":
													alert("카테고리를 선택해주세요");
													none;
													break;
												case "지하철":
													icon = new google.maps.MarkerImage("/images/지하철.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "버스정류장":
													icon = new google.maps.MarkerImage("/images/버스.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "주차장":
													icon = new google.maps.MarkerImage("/images/주차장.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "주유소":
													icon = new google.maps.MarkerImage("/images/주유소.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "EV충전소":
													icon = new google.maps.MarkerImage("/images/EV 충전소.png", null, null, null, new google.maps.Size(35, 35));
													break;
												case "EV충전소/가스충전소":
													icon = new google.maps.MarkerImage("/images/가스충전소.png", null, null, null, new google.maps.Size(35, 35));
													break;
											}
											for (var i = 0; i < poiInfo.length; i++) {
												let searchMark = [
													{
														icon: icon, name: poiInfo[i].name,
														lat: Number(poiInfo[i].frontLat),
														lng: Number(poiInfo[i].frontLon)
													},
												];
												//console.log(searchMark);
												traflat.push(Number(poiInfo[i].frontLat));
												traflng.push(Number(poiInfo[i].frontLon));
												traflength = poiInfo.length;
												console.log(poiInfo.length);
												const infowindow = new google.maps.InfoWindow(); //클릭시 정보 보여주기

												searchMark.forEach(({ icon, name, lat, lng }) => {
													let marker = new google.maps.Marker({
														position: { lat, lng },
														icon,
														animation: google.maps.Animation.DROP,
														map: map2
													});

													marker.addListener("mouseover", () => {
														infowindow.setContent(name);
														infowindow.open({
															anchor: marker,
															map2
														});
													});
													marker.addListener("mouseout", () => {
														infowindow.close();
													})
													marker.addListener("click", () => { //지도 정보 
														map2.panTo(marker.position); //마커 위치로 중심 이동
														infowindow.setContent(name);

													});
													$('#delMark2').click(function() {
														console.log("삭제");
														searchMark.forEach(() => {
															traflat.splice(0);
															traflng.splice(0);
															marker.setMap(null);
														})

													});
												})
											}


										})
										.catch(
											//err => console.error(err)
											alert("해당 장소가 없습니다.")
										);
								}
							} else {
								alert("장소를 선택(검색) 해주세요");
							}
						});
						$('#scorebutton').click(function() {
							if (isNaN(selLats) == true || isNaN(selLngs) == true) {
								alert("장소를 선택 해주세요")
								none;
							} else {
								document.getElementById('areaScore1').style.display = "inline-block";
								document.getElementById('areaScore').style.display = "inline-block";

								document.getElementById("grade").style.display = "inline-block";
								console.log("fd 갯수" + fdlength + "//" + "sv 갯수" + svlength + "//" + "reta 갯수" + retalength);

								console.log((fdlength === null || fdlength === "" || typeof fdlength === "undefined" || fdlength === 0) &&
									(svlength === null || svlength === "" || typeof svlength === "undefined" || svlength === 0) &&
									(retalength === null || retalength === "" || typeof retalength === "undefined" || retalength === 0) + "chk");


								if ((fdlength === null || fdlength === "" || typeof fdlength === "undefined" || fdlength === 0) &&
									(svlength === null || svlength === "" || typeof svlength === "undefined" || svlength === 0) &&
									(retalength === null || retalength === "" || typeof retalength === "undefined" || retalength === 0)) {
									alert("업종 마커 한종류를 추가해주세요.")
								} else if ((svlength === null || svlength === "" || typeof svlength === "undefined" || svlength === 0) &&
									(retalength === null || retalength === "" || typeof retalength === "undefined" || retalength === 0)) {
									var areaScore = document.getElementById("areaScore");
									areascore = baseLog(((male * 4 + female * 6) *
										(rate0 * 5 + rate10 * 6 + rate20 * 8 + rate30 * 10 + rate40 * 12 + rate50 * 10 + rate60 * 9 + rate70 * 8) *
										(resnt * 3 + nonresnt * 7) / (fdlength + 1)), 5000) * (100 / baseLog(504000000, 3000));

								} else if ((fdlength === null || fdlength === "" || typeof fdlength === "undefined" || fdlength === 0) &&
									(retalength === null || retalength === "" || typeof retalength === "undefined" || retalength === 0)) {
									var areaScore = document.getElementById("areaScore");
									areascore = baseLog(((male * 4 + female * 6) *
										(rate0 * 5 + rate10 * 6 + rate20 * 8 + rate30 * 10 + rate40 * 12 + rate50 * 10 + rate60 * 9 + rate70 * 8) *
										(resnt * 3 + nonresnt * 7) / (svlength + 1)), 5000) * (100 / baseLog(504000000, 3000));
								} else if ((fdlength === null || fdlength === "" || typeof fdlength === "undefined" || fdlength === 0) &&
									(svlength === null || svlength === "" || typeof svlength === "undefined" || svlength === 0)) {
									var areaScore = document.getElementById("areaScore");
									areascore = baseLog(((male * 4 + female * 6) *
										(rate0 * 5 + rate10 * 6 + rate20 * 8 + rate30 * 10 + rate40 * 12 + rate50 * 10 + rate60 * 9 + rate70 * 8) *
										(resnt * 3 + nonresnt * 7) / (retalength + 1)), 5000) * (100 / baseLog(504000000, 3000));
								} else {
									alert("마커를 삭제후 업종을 한개만 선택하여 계산해주세요");
									category = null;
									none;
								}
								if (areascore == null || typeof areascore === "undefined") {
									var areaScore = document.getElementById("areaScore");
									areaScore.innerText = "다시 선택후 계산해주세요.";
								} else {
									if (areascore > 60 && areascore < 70) {
										var scorechk = "주의";
										areaScore.innerText = scorechk;
										areagrade = scorechk;
										areaScore.style.color = 'orange';
									} else if (areascore > 70 && areascore < 80) {
										var scorechk = "보통";
										areaScore.innerText = scorechk;
										areagrade = scorechk;
										areaScore.style.color = 'gray';
									} else if (areascore > 80 && areascore < 90) {
										var scorechk = "양호";
										areaScore.innerText = scorechk;
										areagrade = scorechk;
										areaScore.style.color = 'green';
									} else if (areascore > 90 && areascore < 100) {
										var scorechk = "완벽"
										areaScore.innerText = scorechk;
										areagrade = scorechk;
										areaScore.style.color = 'blue';
									} else {
										var scorechk = "위험"
										areaScore.innerText = scorechk;
										areagrade = scorechk;
										areaScore.style.color = 'red';
									}
								}
							}

							console.log(areascore);
						});
						ctx1 = document.getElementById("bar-chart-horizontal");
						ctx2 = document.getElementById("pieChart");
						ctx3 = document.getElementById("resntChart");
						config1 = {
							type: 'bar',
							data: {
								labels: ["0~10세", "10대", "20대", "30대", "40대", "50대", "60대", "70대"],
								datasets: [
									{
										label: "나이별 인구 비율",
										backgroundColor: ["#FFE45C", "#FD7B49", "#E8395C", "#B137A3", "#6957CB", "#43ABAF", "#6cd6ff", "#3d474a"],
										data: [rate0, rate10, rate20, rate30, rate40, rate50, rate60, rate70]
									}
								]
							},
							options: {
								indexAxis: 'y',
								legend: { display: false },
								title: {
									display: true,
									text: '유동인구별 나이 비율'
								},
								plugins: { legend: { display: false } }
							}
						};
						config2 = {
							type: 'pie',
							data: {
								labels: ['남성', '여성'],
								datasets: [{
									data: [male, female],
									backgroundColor: ["skyblue", "pink"]
								}]
							},
							options: {
								responsive: false
							}

						};
						config3 = {
							type: 'pie',
							data: {
								labels: ["거주", "비거주"],
								datasets: [{
									data: [resnt, nonresnt],
									backgroundColor: ['#bd8cff', 'lightgray']
								}]
							},
							options: {
								responsive: false
							}
						}
						areaAgeChart = new Chart(ctx1, config1);
						genderChart = new Chart(ctx2, config2);
						resntChart = new Chart(ctx3, config3);

						const closeBtn = modal.querySelector('.close-area');
						closeBtn.addEventListener("click", e => {
							areaAgeChart.destroy();
							genderChart.destroy();
							resntChart.destroy();
							mymark.setMap(null);
							selLats = null;
							selLngs = null;
							fdlength = 0;
							areagrade = null;
							category = null;
							$("#foodData").find("option:eq(0)").prop("selected", true);
							$("#serviceData").find("option:eq(0)").prop("selected", true);
							$("#retailData").find("option:eq(0)").prop("selected", true);
							$("#trafficData").find("option:eq(0)").prop("selected", true);
							$("#areaData").find("option:eq(0)").prop("selected", true);
							document.getElementById("grade").style.display = "none";
							modal.style.display = "none";

						});
						modal.addEventListener("click", e => {
							const evTarget = e.target
							if (evTarget.classList.contains("modal-overlay")) {
								areaAgeChart.destroy();
								genderChart.destroy();
								resntChart.destroy();
								mymark.setMap(null);
								selLats = null;
								selLngs = null;
								fdlength = 0;
								areagrade = null;
								category = null;
								$("#foodData").find("option:eq(0)").prop("selected", true);
								$("#serviceData").find("option:eq(0)").prop("selected", true);
								$("#retailData").find("option:eq(0)").prop("selected", true);
								$("#trafficData").find("option:eq(0)").prop("selected", true);
								$("#areaData").find("option:eq(0)").prop("selected", true);
								document.getElementById("grade").style.display = "none";
								modal.style.display = "none"
							}
						})

					}
				} else {
					document.getElementById("checkp").style.display = "none";
					document.getElementById("checkpp").style.display = "block";
					document.getElementById("checkppn").style.display = "block";
					console.log("null chek");

				}

			}

			xhr.send('');
		});
	});

	const firstvisit = document.createElement("input");
	firstvisit.type = "button";
	firstvisit.value = "사용방법";
	firstvisit.id = "help";
	firstvisit.style.width = "90px";
	firstvisit.style.border = "3px solid #77af9c";
	firstvisit.style.borderRadius = "7px";
	firstvisit.style.boxShadow = "0 2px 6px rgba(0,0,0,.3)";
	firstvisit.style.color = "rgb(25,25,25)";
	firstvisit.style.cursor = "pointer";
	firstvisit.style.fontFamily = "Roboto,Arial,sans-serif";
	firstvisit.style.fontSize = "16px";
	firstvisit.style.lineHeight = "38px";
	firstvisit.style.margin = "8px 0 22px";
	firstvisit.style.padding = "0 5px";
	firstvisit.style.textAlign = "center";

	map.controls[google.maps.ControlPosition.TOP_LEFT].push(firstvisit);

	firstvisit.addEventListener("click", () => {
		const modal = document.getElementById("modal");
		modal.style.display = "flex";
		document.getElementById("modal1").style.display = 'none';
		const modal2 = document.getElementById('modal2');
		modal2.style.display = 'block';

		const closeBtn = modal2.querySelector('.close-area');
		closeBtn.addEventListener("click", e => {
			modal.style.display = "none";
		});
		modal.addEventListener("click", e => {
			const evTarget = e.target
			if (evTarget.classList.contains("modal-overlay")) {
				modal.style.display = "none"
			}
		})
	});
	return firstvisit;
}


function saveInfo() {
	var data = {
		email: $("#email").val(),
		areaname: areaname,
		rate0: rate0,
		rate10: rate10,
		rate20: rate20,
		rate30: rate30,
		rate40: rate40,
		rate50: rate50,
		rate60: rate60,
		rate70: rate70,
		male: male,
		female: female,
		resnt: resnt,
		nonresnt: nonresnt,
		congest: congest,
		selectlat: selectlat,
		selectlng: selectlng,
		areagrade: areagrade,
		category: category,
		seloption: seloption,
		areacate: areacate,
		areaoption: areaoption,
		trafcate: trafcate,
		trafoption: trafoption
	};
	console.log(data);
	var email = $("#email").val();
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	if (isNaN(selLats) == true || isNaN(selLngs) == true) {
		alert("장소를 선택해주세요")
	} else {
		if (areagrade == null) {
			alert("점수를 계산해주세요");
		} else {
			$.ajax({
				beforeSend: function(xhr) {
					xhr.setRequestHeader(header, token);
				},
				type: 'POST',
				url: 'clipping/' + email,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function() {
				var tomypage = confirm("스크랩이 완료되었습니다. 확인하시겠습니까?");
				if (tomypage) {
					location.href = '/members/mypage';
				}
			}).fail(function(error) {
				alert(JSON.stringify(error));
			})
		}
	}
}

/* 테이블 연결 저장 
 if(traflat !== null || traflat != "" || typeof traflat != "undefined"){
		for(var i =0 ; i < traflat.length ; i++){
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			var trafdata = {
				traflat : traflat[i],
				traflng : traflng[i],
			}
			console.log(trafdata);
			$.ajax({
			   beforeSend: function(xhr){
			   xhr.setRequestHeader(header,token);
			   },
			   type : 'POST',
			   url : 'clipping/traf',
			   dataType : 'json',
			   contentType : 'application/json; charset=utf-8',
			   data : JSON.stringify(trafdata)
			})
		}
	    
	   }
	   if(fdlat !== null || fdlat != "" || typeof fdkat != "undefined"){
		for(var i = 0; i < fdlat.length; i++){
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			var fddata = {
				fdlat : fdlat[i],
				fdlng : fdlng[i]
			};
			
				$.ajax({
					beforeSend: function(xhr){
					xhr.setRequestHeader(header,token);
							},
					type : 'POST',
					url : 'clipping/fd',
					dataType : 'json',
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(fddata)
				})
			}
		
		}
		if(svlat !== null || svlat != "" || typeof svkat != "undefined"){
		for(var i = 0; i < svlat.length; i++){
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			var svdata = {
				svlat : svlat[i],
				svlng : svlng[i]
			};
			
				$.ajax({
					beforeSend: function(xhr){
					xhr.setRequestHeader(header,token);
							},
					type : 'POST',
					url : 'clipping/sv',
					dataType : 'json',
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(svdata)
				})
			}
		
		}
		if(retalat !== null || retalat != "" || typeof retakat != "undefined"){
		for(var i = 0; i < retalat.length; i++){
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			var retadata = {
				retalat : retalat[i],
				retalng : retalng[i]
			};
			
				$.ajax({
					beforeSend: function(xhr){
					xhr.setRequestHeader(header,token);
							},
					type : 'POST',
					url : 'clipping/reta',
					dataType : 'json',
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(retadata)
				})
			}
		
		}
		if(arlat !== null || arlat != "" || typeof arkat != "undefined"){
		for(var i = 0; i < arlat.length; i++){
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			var ardata = {
				arlat : arlat[i],
				arlng : arlng[i]
			};
			
				$.ajax({
					beforeSend: function(xhr){
					xhr.setRequestHeader(header,token);
							},
					type : 'POST',
					url : 'clipping/ar',
					dataType : 'json',
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(ardata)
				})
			}
		
		}
		*/
//--------------------------------------------------


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
	for (var i = 0; i < markerArray.length; i++) {
		setTimeout(function() {
			addMarkerMethod();
		}, i * 200);
	}
}

function baseLog(x, base) {
	return Math.log(x) / Math.log(base);
}