function validateQty(event) {
    var key = window.event ? event.keyCode : event.which;

if (event.keyCode == 8 || event.keyCode == 46
 || event.keyCode == 37 || event.keyCode == 39) {
    return true;
}
else if ( key < 48 || key > 57 ) {
    return false;
}
else
{
	return true;	
}

};
function insertString(oldString,value,index)
{
	return oldString.slice(0, index) + value + oldString.slice(index);	
}
$(document).ready(function () {
	 
	$.validator.addMethod("noSpace", function(value, element) { 
	 	for(var i = 0 ; i< value.length ; i ++)
	 	{
	 		if(value[i]!=" ")
	 			return true;
	 	}	 
	  	return false;
	}, "Không được để toàn ký tự trắng");
	
	 $.validator.addMethod("regx", function(value, element) {     		 
	 	var date_regex = /^(?:(?:(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec))(\/|-|\.)31)\1|(?:(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))(\/|-|\.)(?:29|30)\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:(?:0?2|(?:Feb))(\/|-|\.)(?:29)\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))(\/|-|\.)(?:0?[1-9]|1\d|2[0-8])\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;
    	return date_regex.test(value);
	}, "Ngày sai định dạng");	     	 
	 
	 $.validator.addMethod("validateTen", function(value, element) {
	        return this.optional(element) || /^[a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểếẾỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$/i.test(value);
	    }, "Vui lòng không nhập ký tự đặc biệt");
	 
    $('#updateForm').validate({ 
    	rules :{
    	   tenNhanVien : {
	            required : true,
	            validateTen:true,
	            noSpace: true
			    },
			ngaySinh : {
	            required : true,
	            regx:true,
	            noSpace: true
			    },
		    matKhau : {
	            required : true,
	            minlength:6,
	            noSpace: true
			    },
			sdt : {
	            maxlength: 11
			    }
		},      	
	    messages :{
			tenNhanVien : {
	            required : 'Họ tên không được để trống'
	        },
	        ngaySinh : {
	            required : 'Ngày sinh không được để trống'
			    },
			matKhau : {
	            required : 'Mật khẩu không được để trống',
	            minlength: 'Mật khẩu phải có ít nhất 6 ký tự'
			    },
			sdt : {
			    maxlength: 'Số điện thoại phải từ ít hơn 11 số'
			    }
	    }
    });
});