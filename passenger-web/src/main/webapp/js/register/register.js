$('#register').registerPanel({
    logo: {
        // logoImgSrc: './images/login/logo.png',
        textImgSrc: '欢迎注册',
        rightText: '已有账号？请登录',
        rightTextSrc: './login.html'
    },
    user: [
        {
            label: '账号',
            placeholder: '您的账号和登录名',
            tip: '支持中文、字母、数字、"-"、"_"的组合，4-20个字符',
            isShow: true,
            inputId: 'account',
            type: 'text'
        },
        {
            label: '用户名',
            placeholder: '您的用户名',
            tip: '支持中文、字母、数字、"-"、"_"的组合，4-20个字符',
            isShow: true,
            inputId: 'userName',
            type: 'text'
        },
        {
            label: '设置密码',
            placeholder: '请输入密码',
            tip: '建议使用字母、数字和符号两种及以上的组合，6-20个字符',
            isShow: true,
            inputId: 'password',
            type: 'password'
        },
        {
            label: '确认密码',
            placeholder: '请再次输入密码',
            tip: '请再次输入密码',
            isShow: true,
            inputId: 'ackPassword',
            type: 'password'              
        },
        {
            label: '手机号',
            placeholder: '您的手机号',
            tip: '请输入手机号',
            isShow: true,
            inputId: 'phoneNum',
            type: 'text',
            reg: /^1[3|4|5|7|8][0-9]{9}$/,
            errorText: '请输入正确的手机号'          
        },
        {
            label: '余额',
            placeholder: '您的账户余额',
            tip: '请输入账户余额',
            isShow: true,
            inputId: 'userBalance',
            type: 'number'                 
        },
    ],
    submitBtnText: '立即注册',
    submitFuc: function (data) {
        if (data.password == data.ackPassword && data.isTrue) {
            delete data.ackPassword;
            data.userType = '1';
            data.userBalance = parseFloat(data.userBalance).toFixed(2);
            ServerUtil.api('user/', 'save', data, function (data) {
                window.location.href = window.location.origin + '/' + pageConfig.urlPrex + 'login.html';
            });
        }
    }
});