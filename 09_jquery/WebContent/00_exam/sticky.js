/**
 * 
 */
$.ajax({
	url: "/09_jquery/sticky/list.do",
	type: "POST",
	dataType: "json"
}).done(function (result) {
	
	$("#memo1").html(result[0].content);
	$("#memo1").css({
		"margin-left": result[0].posX,
		"margin-top": result[0].posY
	});
	
})

$("input[type=button]").click(function () {
	
	$("#divObj").html();
	$.ajax({
		url: "/09_jquery/sticky/save.do",
		type: "POST",
		data: {
			x:10,
			y:10,
			content: $("#memo1").html()
		}
	});
	
});

$("#memo1").keyup(function () {
	
	$.ajax({
		url: "/09_jquery/sticky/edit.do",
		type: "POST",
		data: {
			x:$("#memo1").clientX, 
			y:$("#memo1").clientY, 
			id:1,
			content:$("#memo1").html()
		}
	})
	
});
