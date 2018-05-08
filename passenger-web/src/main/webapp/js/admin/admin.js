//JavaScript代码区域
var $;
layui.use(['table'], function () {
    var table = layui.table;
    $ = layui.$;
    var laytpl = layui.laytpl;
    var element = layui.element;
    var tableTitle = {
        account: '账号',
        password: '密码',
        userName: '用户名',
        email: '邮箱',
        phoneNum: '手机号',
        idCard: '身份证号'
    };
    var userInfo;
    //获取用户信息
    ServerUtil.api('user/', 'getUserInfo', {}, function (data) {
        userInfo = data;
        $('#userLoginAccount').text(data.account);
        $('#userLogin').show();
    });
    $('#changeUserInfo').on('click', function () {
        var userList = [];
        for (var attr in userInfo) {
            if (tableTitle[attr]) {
                var dataObj = {};
                dataObj.title = tableTitle[attr];
                dataObj.val = userInfo[attr] || '';
                dataObj.field = attr;
                dataObj.className = 'table-edit-input';
                userList.push(dataObj);
            }
        }
        var getTpl = tableEdit.innerHTML,
            view = document.getElementById('tableBox');
        laytpl(getTpl).render(userList, function (html) {
            view.innerHTML = html;
        });
        layer.open({
            title: '修改信息',
            type: 1,
            skin: 'layui-layer-molv layer-btn-class',
            resize: false,
            btn: ['确定', '取消'],
            yes: function (index, layero) {
                //按钮【按钮一】的回调
                $('.table-edit-input').each(function (index, val) {
                    userInfo[val.dataset.type] = $(val).val();
                });
                ServerUtil.api('change-web/user/', 'save', userInfo, function () {
                    layer.close(index);
                });
            },
            btn2: function (index, layero) {
                //按钮【按钮二】的回调
                layer.close(index);
            },
            content: $('#tableBox')
        });
    });
    $('#logout').on('click', function () {
        window.location.href = window.location.origin + '/' + pageConfig.urlPrex + 'login/logout';
    });
    //第一个实例
    table.render({
        elem: '#datalist',
        // height: 315,
        url: window.location.origin + '/' + pageConfig.urlPrex + 'user/getUserList',
        method: 'post',
        response: {
            statusCode: 1,
            dataName: 'datalist'
        },
        request: {
            pageName: 'pageNum', //页码的参数名称，默认：page
            limitName: 'pageSize', //每页数据量的参数名，默认：limit
            page: 0,
            limit: 10
        },
        where: {
            userType: 1
        },
        page: {
            limits: [5, 10, 20, 50, 100]
        },
        id: 'poemUsers',
        done: function (res) {

        },
        cols: [
            [ //表头
                {
                    type: 'checkbox'
                },
                {
                    field: 'account',
                    title: '账号',
                    // width: 150
                }, {
                    field: 'password',
                    title: '密码',
                    width: 80
                }, {
                    field: 'userName',
                    title: '用户名',
                    // width: 150
                }, {
                    field: 'email',
                    title: '邮箱',
                    // width: 200
                }, {
                    field: 'phoneNum',
                    title: '手机号',
                    sort: true,
                    // width: 200
                }, {
                    field: 'idCard',
                    title: '身份证号',
                    sort: true,
                    // width: 200
                }, {
                    fixed: 'right',
                    title: '操作',
                    minWidth: 163,
                    // width: 178,
                    align: 'center',
                    toolbar: '#tableBtn'
                }
            ]
        ]
    });
    //表格重载函数
    function tableReload(conditions) {
        var obj = {
            page: {
                curr: 1 //重新从第 1 页开始
            }
        };
        if (conditions) {
            obj.where = conditions;
        }
        table.reload('poemUsers', obj);
    }
    //查看按钮功能
    table.on('tool(tableBtn)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            var userList = [];
            for (var attr in data) {
                if (tableTitle[attr]) {
                    var dataObj = {};
                    dataObj.title = tableTitle[attr];
                    dataObj.val = data[attr] || '';
                    userList.push(dataObj);
                }
            }
            var getTpl = tableDetail.innerHTML,
                view = document.getElementById('tableBox');
            laytpl(getTpl).render(userList, function (html) {
                view.innerHTML = html;
            });
            layer.open({
                title: '用户详情',
                type: 1,
                skin: 'layui-layer-molv',
                shadeClose: true,
                resize: false,
                // area: ['500px', '300px'],
                content: $('#tableBox')
            });
        }
    });

    //按条件搜索
    $('#searchBtn').on('click', function () {
        // var type = $(this).data('type');
        var obj = {};
        var account = $('#accountReload').val();
        var userName = $('#userNameReload').val();
        var age = $('#ageReload').val();
        obj.account = account;
        obj.userName = userName;
        obj.age = age;
        obj.userType = 1;
        tableReload(obj);
    });

    //菜单跳转
    $('#station').on('click', function () {
        window.location.href = window.location.origin + '/passenger-web/user/view?userType=2';
    });
    $('#carTrip').on('click', function () {
        window.location.href = window.location.origin + '/passenger-web/user/view?userType=3';
    });
});