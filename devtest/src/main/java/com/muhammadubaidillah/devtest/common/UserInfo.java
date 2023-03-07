package com.muhammadubaidillah.devtest.common;

import java.util.Optional;

import javax.json.JsonString;

import io.vertx.core.json.JsonObject;

public final class UserInfo {
	
	public static String getUserId(Optional<JsonString> userInfo){
		JsonObject userData = new JsonObject(userInfo.get().getString());
		String idUser = userData.getString("idUser", "");
		System.out.println("================ ID USER : " + idUser + " =================");
		return idUser;
	}

}
