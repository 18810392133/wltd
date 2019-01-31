function login(){
    $.ajax({
        url:"user/login",
        type:"GET",
        data:$("#loginForm").serialize(),
        success:function(data){
            if(data.isSuccess){
                location = 'http://localhost/' + data.servicename + '/home.html';
            }else{
                $("#msg").html(data.msg);
            }
        }
    });
}