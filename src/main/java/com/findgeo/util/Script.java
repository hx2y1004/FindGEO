package com.findgeo.util;

public class Script {
	// 성공했을 때 메서드 - alert 창을 띄우고 이동
	public static String href(String path, String msg) { // 함수 이름 같게 한다(오버로딩:개발자에게 기억하기 쉽게). 매개변수 바꾼다.
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert(' " + msg + " ');");
		sb.append("location.href='" + path + "';");
		sb.append("</script>");

		return sb.toString();
	}
}
