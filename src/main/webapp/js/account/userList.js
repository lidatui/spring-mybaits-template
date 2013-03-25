$(document).ready(function(){

    var dataFormat = function(val){
        return new Date(val).toString('yyyy-MM-dd');
    }

    var cols = [
        { title:'用户名', name:'realName', sortName:'REAL_NAME' ,width:100, sortable: true, align:'center' ,lockDisplay: true },
        { title:'登录名', name:'name', sortName:'USER_NAME' ,width:100, sortable: true, align:'center' },
        { title:'EMAIL', name:'email', sortName:'EMAIL' ,width:150, sortable: true, align:'center' },
        { title:'建立时间', name:'createDate', sortName:'CREATE_DATE' ,width:100, sortable: true, align:'center', renderer: dataFormat},
        { title:'账户持有人', name:'state', sortName:'ACC_NAME' ,width:100, sortable: true, align:'center' },
        { title:'用户类型', name:'type', sortName:'USER_TYPE' ,width:100, sortable: true, align:'center' }

    ];


    var mmg = $('.mmg').mmGrid({
        height: '100%'
        , cols: cols
        , url: 'user/list.json'
        , method: 'get'
        , remoteSort:true
        , sortName: 'REAL_NAME'
        , sortStatus: 'asc'
        , fullWidthRows: true
        , indexCol: true
        , plugins: [
            $('#pg').mmPaginator({
                limit: 30
            })
        ]
    });
})
