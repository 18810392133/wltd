function login(){
    var param = {"username": "leader1301", "password": "leader1301", "servicename": "security"};
    $.getJSON("http://app.iotspace.net/user/login?jsoncallback=",param, function(data){
        if(data.isSuccess){
            console.log(data);
        }else{
            $("#msg").html(data.msg);
        }
    });
    // $.ajax({
    //     url:"http://app.iotspace.net/user/login",
    //     type:"GET",
    //     data:{"username": "leader1301", "password": "leader1301", "servicename": "security"},
    //     success:function(data){
    //         if(data.isSuccess){
    //             console.log(data);
    //         }else{
    //             $("#msg").html(data.msg);
    //         }
    //     }
    // });
}