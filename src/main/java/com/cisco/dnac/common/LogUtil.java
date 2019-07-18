package com.cisco.dnac.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
public class LogUtil {

	private LogUtil() {
	}

	public static Logger getLogger(Class<?> classRef) {
		return LoggerFactory.getLogger(classRef);
	}

	public static void chooseFile(String fileName) {
		MDC.put("transport", fileName);
	}

	public static void setTransactionId(String trId, String trRef) {
		MDC.put("transactionId", "{" + trRef + " = " + trId + "}");
	}
}
