package com.cisco.dnac.error;

/**
 * MGException is the parent exception class for DNACException
 *
 */
public class DNACException extends RuntimeException {

	private static final long serialVersionUID = -5473587972307133554L;


	@Override
	public String toString() {
		return "DNACException";
	}
}