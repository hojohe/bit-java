/**
 * 
 */
function isEmpty(obj, msg) {
	
	if(obj.value == "") {
		alert(msg);
		obj.focus();
		return true;
	}
	return false;
	
}

function validLengChk(obj, msg) {
	
	
	switch(obj) {
		case id : 
			if(obj.value.length <4 || obj.value.length > 8) {
				alert("ID는 4자 이상 8자 이하이어야 합니다");
				return true;
			}
			return false;
	
	}
	
}