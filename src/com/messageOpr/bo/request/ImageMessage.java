package com.messageOpr.bo.request;

import com.messageOpr.bo.response.BaseMessage;

public class ImageMessage extends BaseMessage {
	// Í¼Æ¬Á´½Ó
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
