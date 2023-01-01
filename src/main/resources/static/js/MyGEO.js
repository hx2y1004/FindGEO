
window.initMap = function () {
	/*<![CDATA[*/
	 const mycliplist = /*[[${mycliplist}]]*/
	 console.log(/*[[${mycliplist}]]*/);
	 let mycliplat = Number(mycliplist[0].selectlat);
	 let mycliplng = Number(mycliplist[0].selectlng);
	 const map3 = new google.maps.Map(document.getElementById("map3"), {
		    center: { lat: mycliplat, lng: mycliplng },
		    zoom: 15,
	
		  });
	 
	 
	/*]]>*/
}