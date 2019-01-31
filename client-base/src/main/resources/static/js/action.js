//user start
function userProjectFormatter(value, row, index){
	if(row.project != null) 
		return row.project.item;
}

//plat start
function platProjectFormatter(value, row, index){
	if(row.project != null) 
		return row.project.item;
}

//bim start
function bimProjectFormatter(value, row, index){
    if(row.plat != null && row.plat.project != null)
        return row.plat.project.item;
}

function bimPlatFormatter(value,row,index){
    if(row.plat != null)
        return row.plat.item;
}

function onBimProjectSelect(data){
    var row = $('#bimList').datagrid('getSelected');
    var index = $('#bimList').datagrid('getRowIndex',row);
    $('#bimList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('reload', 'plat/combobox?projectid=' + data.value);
}

function onBimPlatLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear)
        $(this).combobox('clear');
}

function onBimFilterProjectSelect(data){
    $('#bimList').edatagrid('getFilterComponent', 'platid').combobox('reload', 'plat/combobox?projectid=' + data.value);
}

//sensor start
function sensorProjectFormatter(value, row, index){
    if(row.bim != null && row.bim.plat != null && row.bim.plat.project != null)
        return row.bim.plat.project.item;
}

function sensorPlatFormatter(value,row,index){
    if(row.bim != null && row.bim.plat != null)
        return row.bim.plat.item;
}

function sensorBimFormatter(value,row,index){
    if(row.bim != null)
        return row.bim.item;
}

function onSensorProjectSelect(data){
    var row = $('#sensorList').datagrid('getSelected');
    var index = $('#sensorList').datagrid('getRowIndex',row);
    $('#sensorList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('reload', 'sensor/platSelect?projectid=' + data.value);
}

function onSensorPlatLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        var row = $('#sensorList').datagrid('getSelected');
        var index = $('#sensorList').datagrid('getRowIndex',row);
        $('#sensorList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

function onSensorPlatSelect(data){
    var row = $('#sensorList').datagrid('getSelected');
    var index = $('#sensorList').datagrid('getRowIndex',row);
    $('#sensorList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('reload', 'sensor/bimSelect?platid=' + data.value);
}

function onSensorBimLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear)
        $(this).combobox('clear');
}

function onSensorFilterProjectSelect(data){
    $('#sensorList').edatagrid('getFilterComponent', 'platid').combobox('reload', 'sensor/platSelect?projectid=' + data.value);
}

function onSensorFilterPlatSelect(data){
    $('#sensorList').edatagrid('getFilterComponent', 'bimid').combobox('reload', 'sensor/bimSelect?platid=' + data.value);
}

function onSensorFilterPlatLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        $('#sensorList').edatagrid('getFilterComponent', 'bimid').combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

//attr start
function attrProjectFormatter(value, row, index){
    if(row.sensor != null && row.sensor.bim != null && row.sensor.bim.plat != null && row.sensor.bim.plat.project != null)
        return row.sensor.bim.plat.project.item;
}

function attrPlatFormatter(value,row,index){
    if(row.sensor != null && row.sensor.bim != null && row.sensor.bim.plat != null)
        return row.sensor.bim.plat.item;
}

function attrBimFormatter(value,row,index){
    if(row.sensor != null && row.sensor.bim != null)
        return row.sensor.bim.item;
}

function attrSensorFormatter(value,row,index){
    if(row.sensor != null)
        return row.sensor.item;
}

function onAttrProjectSelect(data){
    var row = $('#attrList').datagrid('getSelected');
    var index = $('#attrList').datagrid('getRowIndex',row);
    $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('reload', 'attr/platSelect?projectid=' + data.value);
}

function onAttrPlatLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        var row = $('#attrList').datagrid('getSelected');
        var index = $('#attrList').datagrid('getRowIndex',row);
        $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

function onAttrPlatSelect(data){
    var row = $('#attrList').datagrid('getSelected');
    var index = $('#attrList').datagrid('getRowIndex',row);
    $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('reload', 'attr/bimSelect?platid=' + data.value);
}

function onAttrBimLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        var row = $('#attrList').datagrid('getSelected');
        var index = $('#attrList').datagrid('getRowIndex',row);
        $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'sensorid'}).target.combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

function onAttrBimSelect(data){
    var row = $('#attrList').datagrid('getSelected');
    var index = $('#attrList').datagrid('getRowIndex',row);
    $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'sensorid'}).target.combobox('reload', 'attr/sensorSelect?bimid=' + data.value);
}

function onAttrSensorLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear)
        $(this).combobox('clear');
}

function onAttrFilterProjectSelect(data){
    $('#attrList').edatagrid('getFilterComponent', 'platid').combobox('reload', 'attr/platSelect?projectid=' + data.value);
}

function onAttrFilterPlatSelect(data){
    $('#attrList').edatagrid('getFilterComponent', 'bimid').combobox('reload', 'attr/bimSelect?platid=' + data.value);
}

function onAttrFilterPlatLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        $('#attrList').edatagrid('getFilterComponent', 'bimid').combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

function onAttrFilterBimSelect(data){
    $('#attrList').edatagrid('getFilterComponent', 'sensorid').combobox('reload', 'attr/sensorSelect?bimid=' + data.value);
}

function onAttrFilterBimLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        $('#attrList').edatagrid('getFilterComponent', 'sensorid').combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

//val start
function valProjectFormatter(value, row, index){
	if(row.attr != null && row.attr.sensor != null && row.attr.sensor.bim != null && row.attr.sensor.bim.plat != null && row.attr.sensor.bim.plat.project != null)
		return row.attr.sensor.bim.plat.project.item;
}

function valPlatFormatter(value,row,index){
	if(row.attr != null && row.attr.sensor != null && row.attr.sensor.bim != null && row.attr.sensor.bim.plat != null)
		return row.attr.sensor.bim.plat.item;
}

function valBimFormatter(value,row,index){
	if(row.attr != null && row.attr.sensor != null && row.attr.sensor.bim != null)
		return row.attr.sensor.bim.item;
}

function valSensorFormatter(value,row,index){
    if(row.attr != null && row.attr.sensor != null)
        return row.attr.sensor.item;
}

function valAttrFormatter(value,row,index){
	if(row.attr != null)
		return row.attr.item;
}

function onValProjectSelect(data){
	var row = $('#valList').datagrid('getSelected');
	var index = $('#valList').datagrid('getRowIndex',row);
	$('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('reload', 'val/platSelect?projectid=' + data.value);
}

function onValPlatLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		var row = $('#valList').datagrid('getSelected');
		var index = $('#valList').datagrid('getRowIndex',row);
		$('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onValPlatSelect(data){
	var row = $('#valList').datagrid('getSelected');  
	var index = $('#valList').datagrid('getRowIndex',row);
	$('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('reload', 'val/bimSelect?platid=' + data.value);
}

function onValBimLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		var row = $('#valList').datagrid('getSelected');
		var index = $('#valList').datagrid('getRowIndex',row);
		$('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'sensorid'}).target.combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onValBimSelect(data){
	var row = $('#valList').datagrid('getSelected');  
	var index = $('#valList').datagrid('getRowIndex',row);
	$('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'sensorid'}).target.combobox('reload', 'val/sensorSelect?bimid=' + data.value);
}

function onValSensorLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        var row = $('#valList').datagrid('getSelected');
        var index = $('#valList').datagrid('getRowIndex',row);
        $('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'attrid'}).target.combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

function onValSensorSelect(data){
    var row = $('#valList').datagrid('getSelected');
    var index = $('#valList').datagrid('getRowIndex',row);
    $('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'attrid'}).target.combobox('reload', 'val/attrSelect?sensorid=' + data.value);
}

function onValAttrLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear)
		$(this).combobox('clear');
}

function onValFilterProjectSelect(data){
	$('#valList').edatagrid('getFilterComponent', 'platid').combobox('reload', 'val/platSelect?projectid=' + data.value);
}

function onValFilterPlatSelect(data){
	$('#valList').edatagrid('getFilterComponent', 'bimid').combobox('reload', 'val/bimSelect?platid=' + data.value);
}

function onValFilterPlatLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		$('#valList').edatagrid('getFilterComponent', 'bimid').combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onValFilterBimSelect(data){
	$('#valList').edatagrid('getFilterComponent', 'sensorid').combobox('reload', 'val/sensorSelect?bimid=' + data.value);
}

function onValFilterBimLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		$('#valList').edatagrid('getFilterComponent', 'sensorid').combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onValFilterSensorSelect(data){
    $('#valList').edatagrid('getFilterComponent', 'attrid').combobox('reload', 'val/attrSelect?sensorid=' + data.value);
}

function onValFilterSensorLoad(){
    var val = $(this).combobox("getValue");
    var dataList = $(this).combobox("getData");
    var isClear = true;
    for(var i = 0; i < dataList.length; i++){
        if(val == dataList[i].value){
            isClear = false;
            break;
        }
    }
    if(isClear){
        $(this).combobox('clear');
        $('#valList').edatagrid('getFilterComponent', 'attrid').combobox('loadData', {});
    }else
        $(this).combobox('select', val);
}

//chart start
function onChartProjectSelect(data){
	$('#chartPlatid').combobox('reload', 'data/platSelect?projectid=' + data.value);
}

function onChartPlatLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		$('#chartBimid').combobox('loadData', {});
		$('#chartBimattrid').combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onChartPlatSelect(data){
	$('#chartBimid').combobox('reload', 'data/bimSelect?platid=' + data.value);
}

function onChartBimLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		$('#chartBimattrid').combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onChartBimSelect(data){
	$('#chartBimattrid').combobox('reload', 'data/bimattrSelect?bimid=' + data.value);
}

function onChartBimattrLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear)
		$(this).combobox('clear');
}

function chartList(){
	clearInterval(chartInt);
	var bimattrid = $('#chartBimattrid').combobox("getValue");
	var timestart = $('#chartTimeStart').datetimebox("getValue");
	var timeend = $('#chartTimeEnd').datetimebox("getValue");
	$.ajax({
		url:"data/valSelect",
		type:"POST",
		data:{"bimattrid":bimattrid, "timestart":timestart, "timeend":timeend},
		success:function(data){
			var chart = document.getElementById("chartPanel");
			var myChart = echarts.init(chart);
			var datas = [];
			for(var i = 0; i < data.vals.length; i++){
				datas.push({name:data.vals[i].time, value:[data.vals[i].time, data.vals[i].item]});
			}
			var lasttime = data.lasttime;
			var option = {
					title:{text:data.bimattr.bim.item + data.bimattr.attr.item},
					tooltip:{trigger:'axis', axisPointer:{animation:false}},
					xAxis:{type:'time', splitLine:{show:true}},
					yAxis:{type:'value', boundaryGap:[0, '100%'], splitLine:{show:true}},
					series:[{name:data.bimattr.attr.item, type:'line', areaStyle:{}, showSymbol:false, hoverAnimation:false, data:datas}]
			};
			myChart.setOption(option, true);
			if(timeend == ""){
				chartInt = setInterval(function(){
					$.ajax({
						url:"data/lastVal",
						type:"POST",
						data:{"bimattrid":bimattrid, "lasttime":lasttime},
						success:function(response){
							if(response.lasttime != lasttime){
								lasttime = response.lasttime;
								for(var i = 0; i < response.vals.length; i++){
									datas.shift();
									datas.push({name:response.vals[i].time, value:[response.vals[i].time, response.vals[i].item]});
								}
								myChart.setOption({series:[{data:datas}]});
							}
						}
					});
				}, data.bimattr.timer * 1000);
			}
		}
	});
}

//data start
function collectStart(){
	$.ajax({
		url:"data/timerSelect",
		type:"POST",
		data:{},
		success:function(data){
			for(var i = 0; i < data.bimattrs.length; i++){
				collectInterval(i, data.bimattrs[i].id, data.bimattrs[i].timer);
			}
		}
	});
	$('#collectstart').linkbutton({
	    disabled:true
	});
	$('#collectstop').linkbutton({
	    disabled:false
	});
}

function collectInterval(index, bimattrid, timer){
	dataInt[index] = setInterval(function(){
		$.ajax({
			url:"data/dataCollect",
			type:"POST",
			data:{"bimattrid":bimattrid},
			success:function(){
			}
		});
	}, timer * 1000);
}

function collectStop(){
	for(var i = 0; i < dataInt.length; i++){
		clearInterval(dataInt[i]);
	}
	dataInt = [];
	$('#collectstart').linkbutton({
	    disabled:false
	});
	$('#collectstop').linkbutton({
	    disabled:true
	});
}

//onmap
function onOnmapProjectSelect(data){
	$('#onmapPlatid').combobox('reload', 'data/platSelect?projectid=' + data.value);
}

function onOnmapPlatLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		$('#onmapBimid').combobox('loadData', {});
		$('#onmapBimattrid').combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onOnmapPlatSelect(data){
	$('#onmapBimid').combobox('reload', 'data/bimSelect?platid=' + data.value);
}

function onOnmapBimLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear){
		$(this).combobox('clear');
		$('#onmapBimattrid').combobox('loadData', {});
	}else
		$(this).combobox('select', val);
}

function onOnmapBimSelect(data){
	$('#onmapBimattrid').combobox('reload', 'data/bimattrSelect?bimid=' + data.value);
}

function onOnmapBimattrLoad(){
	var val = $(this).combobox("getValue");
	var dataList = $(this).combobox("getData");
	var isClear = true;
	for(var i = 0; i < dataList.length; i++){
		if(val == dataList[i].value){
			isClear = false;
			break;
		}
	}
	if(isClear)
		$(this).combobox('clear');
}

function onmapLoad(){
	var eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
	var eventer = window[eventMethod];
	var messageEvent = eventMethod === "attachEvent" ? "onmessage" : "message";
	eventer(messageEvent, function(e) {
		if (e.data.event_id === "om_onClick"){
//			document.getElementById('onmap').contentWindow.om_getProperty(e.data.location.X , e.data.location.Y);
			$.ajax({
				url:"data/showChart",
				type:"POST",
				data:{"platid":$('#onmapPlatid').combobox("getValue"), "longitude":e.data.location.X, "latitude":e.data.location.Y},
				success:function(data){
					if($('#index_tabs').tabs('exists', '实时数据')){
				        $('#index_tabs').tabs('select', '实时数据');
				    }else{
					    $('#index_tabs').tabs('add',{
					        title:'实时数据',
					        href:"admin/realChart",
					        closable:true,
					        onLoad:function(){
					        	realChartShow(data.id);
					        },
					        onLoadError:function(data){
					            var tab = $('#index_tabs').tabs('getSelected');
					            var body = tab.panel('body');
					            if(data.status == 401) body.html(data.responseText)
					            else body.html('<h1>加载出错</h1>');
					        }
					    });
				    }
				}
			});
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

function onmapLoad2D(){
	$.ajax({
		url:"data/onmapLoad2D",
		type:"POST",
		data:{"platid":$('#onmapPlatid').combobox("getValue")},
		success:function(data){
			var longitude = data.longitude;   //经度
			var latitude = data.latitude;    //纬度
			var zoomLevel = 12;  //比例尺
			var returnValue = document.getElementById('onmap').contentWindow.om_get2DMap(longitude, latitude, zoomLevel);
			console.log(returnValue);
		}
	});
}

function onmapLoad3D(){
	$.ajax({
		url:"data/onmapLoad3D",
		type:"POST",
		data:{"platid":$('#onmapPlatid').combobox("getValue")},
		success:function(data){
			var longitude = data.longitude;   //经度
			var latitude = data.latitude;    //纬度
			var height = 200;  //相机高度
			var heading = 5;  //相机向度
			var pitch = 30;  //相机俯仰角
			var roll = 360;  //相机卷度
			var duration = '';  //持续时间
			var returnValue = document.getElementById('onmap').contentWindow.om_get3DMap(longitude, latitude, height, heading, pitch, roll);
			console.log(returnValue);
		}
	});
}

function onmapAddPoint(){
	$.ajax({
		url:"data/onmapAddPoint",
		type:"POST",
		data:{"bimid":$('#onmapBimid').combobox("getValue")},
		success:function(data){
			console.log(data);
//			var layerName = data.plat.item;  //图层名
//			var coordinates = [data.longitude, data.latitude];  //经纬度
//			var attributes = {c_dist: 'test'};  //属性
			var layerName = "cell_towers";  //图层名
			var coordinates = [-95.39196, 29.81871];  //经纬度
			var attributes = {c_dist: 'test'};  //属性
			document.getElementById('onmap').contentWindow.om_addPoint(layerName, coordinates, attributes);
		}
	});
}

//realChart start

function realChartShow(bimid){
	$('#realBimattrid').combobox({
	    url:'data/bimattrSelect?bimid=' + bimid,
	    valueField:'value',
	    textField:'text',
	    editable:false, 
	    panelHeight:'auto', 
	    panelMaxHeight:'200'
	});
	$('#realChart').linkbutton({
	    iconCls:'icon-search'
	});
}

function realChart(){
	var bimattrid = $('#realtBimattrid').combobox("getValue");
	$.ajax({
		url:"data/realSelect",
		type:"POST",
		data:{"bimattrid":bimattrid},
		success:function(data){
			var rchart = document.getElementById("realPanel");
			var realChart = echarts.init(rchart);
			var reals = [];
			for(var i = 0; i < data.vals.length; i++){
				reals.push({name:data.vals[i].time, value:[data.vals[i].time, data.vals[i].item]});
			}
			var lasttime = data.lasttime;
			var option = {
					title:{text:data.bimattr.bim.item + data.bimattr.attr.item},
					tooltip:{trigger:'axis', axisPointer:{animation:false}},
					xAxis:{type:'time', splitLine:{show:true}},
					yAxis:{type:'value', boundaryGap:[0, '100%'], splitLine:{show:true}},
					series:[{name:data.bimattr.attr.item, type:'bar', areaStyle:{}, showSymbol:false, hoverAnimation:false, data:reals}]
			};
			realChart.setOption(option, true);
			realInt = setInterval(function(){
				$.ajax({
					url:"data/lastVal",
					type:"POST",
					data:{"bimattrid":bimattrid, "lasttime":data.lasttime},
					success:function(response){
						if(response.lasttime != lasttime){
							lasttime = response.lasttime;
							for(var i = 0; i < response.vals.length; i++){
								reals.shift();
								reals.push({name:response.vals[i].time, value:[response.vals[i].time, response.vals[i].item]});
							}
							realChart.setOption({series:[{data:reals}]});
						}
					}
				});
			}, data.bimattr.timer * 1000);
		}
	});
}