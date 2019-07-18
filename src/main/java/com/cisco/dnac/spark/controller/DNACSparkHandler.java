package com.cisco.dnac.spark.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.dnac.common.CommonUrl;
import com.cisco.dnac.common.LogUtil;
import com.cisco.dnac.common.SparkUrl;
import com.cisco.dnac.error.DNACException;
import com.cisco.dnac.spark.entity.SparkReply;
import com.cisco.dnac.spark.service.ISparkService;

@RestController
@RequestMapping(CommonUrl.BASE_URL)
public class DNACSparkHandler {

	private Logger logger = LogUtil.getLogger(DNACSparkHandler.class);
	  @Autowired
	  @Qualifier("sparkService")
	  private ISparkService sparkService;


	  @RequestMapping(value = SparkUrl.SPARK_WEBHOOK_CALLBACK_URL, method = { RequestMethod.GET,
	          RequestMethod.POST })
	  public void callbackFromWebHook(@RequestBody SparkReply reply) throws Exception {
	    logger.info("SparkController # Got the reply : " + reply);
	    logger.debug("Processing the reply - Start");
	    try {
	      sparkService.processReply(reply);
	    } catch (DNACException mge) {
	      logger.error(mge.getMessage(), mge);
	    }
	    logger.debug("Processing the reply - End");
	  }
	  
	  @RequestMapping(value = SparkUrl.SPARK_TEST_URL, method = { RequestMethod.GET})
	  public String test() throws Exception {
	    logger.info("SparkController #test: " );
	    return "success";
	  }


}