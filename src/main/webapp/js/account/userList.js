$(document).ready(function(){

    var dataFormat = function(val){
        return new Date(val).toString('yyyy-MM-dd')
    }

    var cols = [
        { title:'用户名', name:'REAL_NAME' ,width:100, sortable: true, align:'center' ,lockDisplay: true },
        { title:'登录名', name:'USER_NAME' ,width:100, sortable: true, align:'center' },
        { title:'EMAIL', name:'EMAIL' ,width:150, sortable: true, align:'center' },
        { title:'登陆次数', name:'LOGIN_COUNT' ,width:50, sortable: true, align:'center' },
        { title:'部门编号', name:'BRANCH_ID' ,width:100, sortable: true, align:'center' },
        { title:'建立时间', name:'CREATE_DATE' ,width:100, sortable: true, align:'center', renderer: dataFormat},
        { title:'账户持有人', name:'ACC_NAME' ,width:100, sortable: true, align:'center' },
        { title:'用户类型', name:'USER_TYPE' ,width:100, sortable: true, align:'center' }

    ];


    var mmg = $('.mmg').mmGrid({
        height: 400
        , cols: cols
        , url: 'user/list.json'
        , method: 'get'
        , remoteSort:true
        , sortName: 'REAL_NAME'
        , sortStatus: 'asc'
        , fullWidthRows: true
    });
})
