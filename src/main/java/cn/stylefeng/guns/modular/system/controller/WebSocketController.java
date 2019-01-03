package cn.stylefeng.guns.modular.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/websocket")
public class WebSocketController {

	private static String PREFIX = "/system/websocket/";

	@RequestMapping(value = "/toWebSocket")
	public String toWebSocket() { return PREFIX + "websocket.html";}

}
