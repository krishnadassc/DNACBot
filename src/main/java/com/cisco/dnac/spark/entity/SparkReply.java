package com.cisco.dnac.spark.entity;

import java.util.Arrays;

import org.slf4j.Logger;

import com.cisco.dnac.common.LogUtil;
import com.ciscospark.Message;
import com.ciscospark.Webhook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SparkReply extends Webhook {

	private String createdBy;

	private Message data;

	private Logger logger = LogUtil.getLogger(SparkReply.class);

	public SparkReply() {
		// To initialize the class without initializing the attributes
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Message getData() {
		return data;
	}

	public void setData(Message data) {
		this.data = data;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			return "SparkReply [createdBy=" + createdBy + "Message [id=" + data.getId() + ", roomId="
					+ data.getRoomId() + ", toPersonId=" + data.getToPersonId() + ", toPersonEmail="
					+ data.getToPersonEmail() + ", personId=" + data.getPersonId() + ", personEmail="
					+ data.getPersonEmail() + ", text=" + data.getText() + ", file=" + data.getFile()
					+ ", roomType=" + data.getRoomType() + ", created=" + data.getCreated() + ", files="
					+ Arrays.toString(data.getFiles()) + ", markdown=" + data.getMarkdown() + ", html="
					+ data.getHtml() + ", mentionedPeople=" + Arrays.toString(data.getMentionedPeople())
					+ "]";
		}
	}
}
