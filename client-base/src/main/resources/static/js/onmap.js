function get2DMap(){
	var longitude = -95.36903118027323;   //经度
	var latitude = 29.691228678849864;    //纬度
	var zoomLevel = 12;  //比例尺
	var returnValue = document.getElementById('map').contentWindow.om_get2DMap(longitude, latitude, zoomLevel);
	console.log(returnValue);
}

function get3DMap(){
	var longitude = -95.36903118027323;   //经度
	var latitude = 29.691228678849864;    //纬度
	var height = 2951.2707962770232;  //相机高度
	var heading = 5.374418119024738;  //相机向度
	var pitch = 38.54655109422126;  //相机俯仰角
	var roll = 359.9999216617065;  //相机卷度
	var duration = '';  //持续时间
	var returnValue = document.getElementById('map').contentWindow.om_get3DMap(longitude, latitude, height, heading, pitch, roll);
	console.log(returnValue);
}

function getDataByAttributes(){
	var layerName = "cell_towers";  //图层名
	var andCondition = {company_ap: 'Houston Cellular', street_nam: 'Northwest'};  //条件
	document.getElementById('map').contentWindow.om_getDataByAttributes(layerName, andCondition);
}

function updatePropertybyId(){
	var layerName = "cell_towers";  //图层名
	var id = "cell_towers.315";  
	var attributes = {c_dist:"d"};  //属性
	document.getElementById('map').contentWindow.om_updatePropertybyId(layerName, id, attributes);
}

function addPoint(){
	var layerName = "cell_towers";  //图层名
	var coordinates = [-95.39196, 29.81871];  //经纬度
	var attributes = {c_dist: 'test'};  //属性
	document.getElementById('map').contentWindow.om_addPoint(layerName, coordinates, attributes);
}

function loadmap(){
	var eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
	var eventer = window[eventMethod];
	var messageEvent = eventMethod === "attachEvent" ? "onmessage" : "message";
	eventer(messageEvent, function(e) {
		if (e.data.event_id === "om_onClick"){
			document.getElementById('map').contentWindow.om_getProperty(e.data.location.X , e.data.location.Y);
		}else if (e.data.event_id == "om_onGetProperty") {
			console.log(e.data);
		}else if (e.data.event_id == "om_onGetDataByAttributes"){
			console.log(e.data);
		}else if (e.data.event_id == "om_onUpdatePropertybyId"){
			console.log(e.data);
		}else if (e.data.event_id == "om_onAddPoint"){
			console.log(e.data);
		}

	});
}