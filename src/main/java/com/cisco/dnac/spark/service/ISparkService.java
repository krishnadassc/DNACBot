package com.cisco.dnac.spark.service;

import com.cisco.dnac.error.DNACException;
import com.cisco.dnac.spark.entity.SparkReply;

public interface ISparkService {

  void processReply(SparkReply reply) throws DNACException;

  void createWebhook(String appId) throws Exception;


  public void processWebhook(SparkReply reply) throws DNACException;
}
