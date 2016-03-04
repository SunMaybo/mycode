/*基于bootstrap3实现的输入校验状态显示
demo:*/
//输入框状态显示通过输入框id+"_input"绑定
//输入组颜色变化通过输入框id+"_form"绑定
/*	<div id="warn">//错误提示信息
</div>
<form class="form-horizontal">
  <div id="username_form" class="form-group has-feedback">
    <label style="text-align: right;" class="control-label col-sm-3" for="username">用户名:</label>
    <div class="col-sm-4" id="username_input">
      <input type="text" class="form-control" id="username" aria-describedby="usernameStatus" onblur="usernameValidation('username')">
    </div>

  </div>
</form>*/
/*var validation=new Validation();
	   function usernameValidation(id){
		var username=$('#'+id).val();
	
		if(username==null||username.length<=0){
			validation.errorText(id,"用户名字不能为空");
		}else{
			
			validation.successText(id);
		}
		
	   }*/
function Validation(){
	   	var state=new Array();
	   	this.errorText=function(id,errorText){
	   			  $("#"+id+"_form").attr("class","form-group has-error has-feedback");
	   			  $('#'+id+"_span").remove();
	   	$("#"+id+"_input").append('<span id="'+id+"_span"+'"  class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		$('#'+id+"_error").remove();
		$("#warn").append('<div '+"id="+id+"_error"+' class="alert alert-warning">'
			 + ' <a href="#" class="close" data-dismiss="alert">'
     		 +'&times;'
 			  +'</a>'
  				+'<strong >'+errorText+'</strong>'
		+'</div>');
		if(null==state){
			var obj=new Object();
			obj.name=id;
			obj.state=false;
			state[0]=obj;
		}else{
			var flag=0;
			for(var i=0;i<state.length;i++){
				if(state[i].name==id){
					state[i].state=false;
					flag=1;
					break;
				}
			}
			if(flag==0){
				var obj=new Object();
				obj.name=id;
				obj.state=false;
				state[state.length]=obj;
			}
		}
	   	}
	   	this.successText=function(id){
	   		 $("#"+id+"_form").attr("class","form-group has-error has-feedback");
	   		  $('#'+id+"_span").remove();
	   	$("#"+id+"_input").append('<span id="'+id+"_span"+'" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		$('#'+id+"_error").remove();
		if(null==state){
			var obj=new Object();
			obj.name=id;
			obj.state=true;
			state[0]=obj;
		}else{
			var flag=0;
			for(var i=0;i<state.length;i++){
				if(state[i].name==id){
					state[i].state=true;
					flag=1;
					break;
				}
			}
			if(flag==0){
				var obj=new Object();
				obj.name=id;
				obj.state=true;
				state[state.length]=obj;
			}
		}
	   	}
	   	this.isValid=function(){
	   		if(null==state){
	   			return false;
	   		}
	   		for(var i=0;i<state.length;i++){
	   			if(!state[i].state){
	   				return false;
	   			}
	   		}
	   		return true;
	   	}
	   }