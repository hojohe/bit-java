package org.springframework.mvc;

import java.util.HashMap;
import java.util.Map;

import kr.co.mlec.board.controller.CommentDeleteController;
import kr.co.mlec.board.controller.CommentListController;
import kr.co.mlec.board.controller.CommentRegistController;
import kr.co.mlec.board.controller.CommentUpdateController;
import kr.co.mlec.board.controller.DeleteController;
import kr.co.mlec.board.controller.DetailController;
import kr.co.mlec.board.controller.ListController;
import kr.co.mlec.board.controller.UpdateController;
import kr.co.mlec.board.controller.UpdateFormController;
import kr.co.mlec.board.controller.WriteController;
import kr.co.mlec.board.controller.WriteFormController;
import kr.co.mlec.login.LoginController;
import kr.co.mlec.login.LoginFormController;
import kr.co.mlec.login.LogoutController;
import kr.co.mlec.main.MainController;

public class URLHandlerMapping {

	private Map<String, Controller> mappings = new HashMap<>();

	public URLHandlerMapping(String ctrlNames) throws Exception {
		String[] arr = ctrlNames.split(";");
		for (String ctrlInfo: arr) {
			String[] ctrlArr = ctrlInfo.trim().split("=");
			mappings.put(ctrlArr[0], (Controller)Class.forName(ctrlArr[1]).newInstance());
		}
	}
	
	public Controller getController(String url) {
		return mappings.get(url);
	}
}