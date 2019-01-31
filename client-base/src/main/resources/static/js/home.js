var chartInt = 0;
var dataInt = [];
var realInt = 0;

window.onload = function(){
    $.ajax({
        url:"user/info",
        type:"GET",
        success:function(data){
            if(!data.isSuccess) {
                location = 'http://localhost/base/index.html';
            }
        }
    });
}

function openTag(title, url, page){
    if($('#index_tabs').tabs('exists',title)){
        $('#index_tabs').tabs('select',title);
    }else{
        $('#index_tabs').tabs('add',{
            title:title,
            href:url,
            closable:true,
            onLoad:function(){
                dataList(page);
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

function openUrl(title, url){
    if($('#index_tabs').tabs('exists',title)){ // 处理已打开过的tab
        $('#index_tabs').tabs('select',title);
    }else{
        $('#index_tabs').tabs('add',{
            title:title,
            content:'<iframe scrolling="yes" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>',
            closable:true
        });
    }
}

function dataList(page){
    if(page == "project"){
        $('#projectList').edatagrid({
            url:'project/selectByPage',
            saveUrl:'project/insert',
            updateUrl:'project/update',
            destroyUrl:'project/delete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#projectList').edatagrid('unselectAll');
                $('#projectList').edatagrid('selectRow', index < 0 ? 0 : index);
            },
            onRowContextMenu:function(e, index, row){
                e.preventDefault();
                $('#projectMenu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
                $('#projectMenu').menu({
                    onClick:function(item){
                        window.open("http://localhost/" + row.servicename + "/index","");
                    }
                });
            }
        });
        $('#projectList').datagrid('enableFilter', [
            {field:'item', type:'text', op:'contains'},
            {field:'fileurl', type:'text', op:'contains'},
            {field:'servicename', type:'text', op:'contains'},
            {field:'dburl', type:'text', op:'contains'},
            {field:'detail', type:'text', op:'contains'}
        ]);
    }else if(page == "user"){
        $('#userList').edatagrid({
            url:'user/selectVByPage',
            saveUrl:'user/insert',
            updateUrl:'user/update',
            destroyUrl:'user/delete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#userList').edatagrid('unselectAll');
                $('#userList').edatagrid('selectRow', index < 0 ? 0 : index);
            }
        });
        $('#userList').datagrid('enableFilter', [
            {field:'item', type:'text', op:'contains'},
            {field:'password', type:'label'},
            {field:'projectid', type:'combobox', op:['same'], options:{url:'project/combobox', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'type', type:'combobox', op:['same'], options:{url:'user/typeCombobox', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'realname', type:'text', op:'contains'},
            {field:'age', type:'numberbox', op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'time', type:'datetimebox', op:['beginwith', 'endwith']},
            {field:'status', type:'combobox', op:['same'], options:{url:'user/statusCombobox', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}}
        ]);
    }else if(page == "plat"){
        $('#platList').edatagrid({
            url:'plat/selectVByPage',
            saveUrl:'plat/insert',
            updateUrl:'plat/update',
            destroyUrl:'plat/delete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#platList').edatagrid('unselectAll');
                $('#platList').edatagrid('selectRow', index < 0 ? 0 : index);
            }
        });
        $('#platList').datagrid('enableFilter', [
            {field:'item', type:'text', op:'contains'},
            {field:'projectid', type:'combobox', op:['same'], options:{url:'project/combobox', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'province', type:'combobox', op:['same'], options:{url:'plat/provinceCombobox', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'city', type:'text', op:'contains'},
            {field:'longitude', type:'numberbox', options:{precision:6}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'latitude', type:'numberbox', options:{precision:6}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'note', type:'text', op:'contains'}
        ]);
    }else if(page == "bim"){
        $('#bimList').edatagrid({
            url:'bim/selectVByPage',
            saveUrl:'bim/insert',
            updateUrl:'bim/update',
            destroyUrl:'bim/delete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#bimList').edatagrid('unselectAll');
                $('#bimList').edatagrid('selectRow', index < 0 ? 0 : index);
                $('#bimList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'projectid'}).target.combobox('select', row.plat.projectid);
            }
        });
        $('#bimList').datagrid('enableFilter', [
            {field:'item', type:'text', op:'contains'},
            {field:'projectid', type:'combobox', options:{url:'project/combobox', onSelect:onBimFilterProjectSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'platid', type:'combobox', op:['same'], options:{url:'plat/combobox', onLoadSuccess:onBimPlatLoad, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'longitude', type:'numberbox', options:{precision:6}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'latitude', type:'numberbox', options:{precision:6}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'status', type:'combobox', op:['same'], options:{url:'bim/statusCombobox', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'note', type:'text', op:'contains'}
        ]);
    }else if(page == "sensor"){
        $('#sensorList').edatagrid({
            url:'sensor/sensorSelect',
            saveUrl:'sensor/sensorInsert',
            updateUrl:'sensor/sensorUpdate',
            destroyUrl:'sensor/sensorDelete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#sensorList').edatagrid('unselectAll');
                $('#sensorList').edatagrid('selectRow', index < 0 ? 0 : index);
                $('#sensorList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('setValue', row.bim.platid);
                $('#sensorList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'projectid'}).target.combobox('select', row.bim.plat.projectid);
            }
        });
        $('#sensorList').datagrid('enableFilter', [
            {field:'item', type:'text', op:'contains'},
            {field:'projectid', type:'combobox', options:{url:'sensor/projectSelect', onSelect:onSensorFilterProjectSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'platid', type:'combobox', options:{url:'sensor/platSelect', onLoadSuccess:onSensorFilterPlatLoad, onSelect:onSensorFilterPlatSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'bimid', type:'combobox', op:['same'], options:{url:'sensor/bimSelect', onLoadSuccess:onSensorBimLoad, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'protocol', type:'text', op:'contains'},
            {field:'timer', type:'numberbox', op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'status', type:'combobox', op:['same'], options:{url:'sensor/statusSelect', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'note', type:'text', op:'contains'}
        ]);
    }else if(page == "attr"){
        $('#attrList').edatagrid({
            url:'attr/attrSelect',
            saveUrl:'attr/attrInsert',
            updateUrl:'attr/attrUpdate',
            destroyUrl:'attr/attrDelete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#attrList').edatagrid('unselectAll');
                $('#attrList').edatagrid('selectRow', index < 0 ? 0 : index);
                $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('setValue', row.sensor.bimid);
                $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('setValue', row.sensor.bim.platid);
                $('#attrList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'projectid'}).target.combobox('select', row.sensor.bim.plat.projectid);
            }
        });
        $('#attrList').datagrid('enableFilter', [
            {field:'projectid', type:'combobox', options:{url:'attr/projectSelect', onSelect:onAttrFilterProjectSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'platid', type:'combobox', options:{url:'attr/platSelect', onLoadSuccess:onAttrFilterPlatLoad, onSelect:onAttrFilterPlatSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'bimid', type:'combobox', options:{url:'attr/bimSelect', onLoadSuccess:onAttrFilterBimLoad, onSelect:onAttrFilterBimSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'sensorid', type:'combobox', op:['same'], options:{url:'attr/sensorSelect', onLoadSuccess:onAttrSensorLoad, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'protocol', type:'text', op:'contains'},
            {field:'type', type:'combobox', op:['same'], options:{url:'attr/typeSelect', valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'unit', type:'text', op:'contains'},
            {field:'thresholdl', type:'numberbox', options:{precision:2}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'thresholdm', type:'numberbox', options:{precision:2}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'thresholdh', type:'numberbox', options:{precision:2}, op:['equal', 'notequal', 'less', 'lessorequal', 'greater', 'greaterorequal']},
            {field:'note', type:'text', op:'contains'}
        ]);
    }else if(page == "val"){
        $('#valList').edatagrid({
            url:'val/valSelect',
            saveUrl:'val/valInsert',
            updateUrl:'val/valUpdate',
            destroyUrl:'val/valDelete',
            remoteFilter:true,
            destroyMsg:{norecord:{title:'警告', msg:'没有选中要删除的记录.'}, confirm:{title:'确认', msg:'确定删除选中的记录么?'}},
            onError:function(index, row){alert(row.msg);},
            onBeginEdit:function(index, row){
                $('#valList').edatagrid('unselectAll');
                $('#valList').edatagrid('selectRow', index < 0 ? 0 : index);
                $('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'sensorid'}).target.combobox('setValue', row.attr.sensorid);
                $('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'bimid'}).target.combobox('setValue', row.attr.sensor.bimid);
                $('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'platid'}).target.combobox('setValue', row.attr.sensor.bim.platid);
                $('#valList').edatagrid('getEditor', {'index':index < 0 ? 0 : index, 'field':'projectid'}).target.combobox('select', row.attr.sensor.bim.plat.projectid);
            }
        });
        $('#valList').datagrid('enableFilter', [
            {field:'item', type:'text', op:'contains'},
            {field:'projectid', type:'combobox', options:{url:'val/projectSelect', onSelect:onValFilterProjectSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'platid', type:'combobox', options:{url:'val/platSelect', onLoadSuccess:onValFilterPlatLoad, onSelect:onValFilterPlatSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'bimid', type:'combobox', options:{url:'val/bimSelect', onLoadSuccess:onValFilterBimLoad, onSelect:onValFilterBimSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'sensorid', type:'combobox', options:{url:'val/sensorSelect', onLoadSuccess:onValFilterSensorLoad, onSelect:onValFilterSensorSelect, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'attrid', type:'combobox', op:['same'], options:{url:'val/attrSelect', onLoadSuccess:onValAttrLoad, valueField:'value', textField:'text', editable:false, panelHeight:'auto', panelMaxHeight:'200'}},
            {field:'time', type:'datetimebox', op:['beginwith', 'endwith']},
            {field:'note', type:'text', op:'contains'}
        ]);
    }else if(page == "onmap"){
        $('#onmapProjectid').combobox({
            url:'data/projectSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onSelect:onOnmapProjectSelect
        });
        $('#onmapPlatid').combobox({
            url:'data/platSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onSelect:onOnmapPlatSelect,
            onLoadSuccess:onOnmapPlatLoad
        });
        $('#onmapBimid').combobox({
            url:'data/bimSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onSelect:onOnmapBimSelect,
            onLoadSuccess:onOnmapBimLoad
        });
        $('#onmapBimattrid').combobox({
            url:'data/bimattrSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onLoadSuccess:onOnmapBimattrLoad
        });
        $('#onmapLoad2D').linkbutton({
            iconCls:'icon-search'
        });
        $('#onmapLoad3D').linkbutton({
            iconCls:'icon-search'
        });
        $('#onmapAddPoint').linkbutton({
            iconCls:'icon-search'
        });
        $('#onmapGetData').linkbutton({
            iconCls:'icon-search'
        });
        $('#onmapShow').linkbutton({
            iconCls:'icon-search'
        });
        $('#databyattr').linkbutton({
            iconCls:'icon-search'
        });
        $('#propertybyid').linkbutton({
            iconCls:'icon-search'
        });
    }else if(page == "chart"){
        $('#chartProjectid').combobox({
            url:'data/projectSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onSelect:onChartProjectSelect
        });
        $('#chartPlatid').combobox({
            url:'data/platSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onSelect:onChartPlatSelect,
            onLoadSuccess:onChartPlatLoad
        });
        $('#chartBimid').combobox({
            url:'data/bimSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onSelect:onChartBimSelect,
            onLoadSuccess:onChartBimLoad
        });
        $('#chartBimattrid').combobox({
            url:'data/bimattrSelect',
            valueField:'value',
            textField:'text',
            editable:false,
            panelHeight:'auto',
            panelMaxHeight:'200',
            onLoadSuccess:onChartBimattrLoad
        });
        $('#chartTimeStart').datetimebox({
        });
        $('#chartTimeEnd').datetimebox({
        });
        $('#chartList').linkbutton({
            iconCls:'icon-search'
        });
    }else if(page == "data"){
        $('#collectstart').linkbutton({
            iconCls:'icon-search'
        });
        $('#collectstop').linkbutton({
            iconCls:'icon-search'
        });
        if(dataInt.length > 0){
            $('#collectstart').linkbutton({
                disabled:true
            });
        }else{
            $('#collectstop').linkbutton({
                disabled:true
            });
        }
    }
}