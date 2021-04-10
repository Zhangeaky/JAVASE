package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/TRANSPORT_RETRY.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/jenkins/workspace/8-2-build-linux-amd64/jdk8u281/880/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Wednesday, December 9, 2020 12:38:46 PM GMT
*/

public interface TRANSPORT_RETRY
{

  /**
     * Indicates a Transport Retry reply status. One possible value for 
     * <code>RequestInfo.reply_status</code>.
     * @see RequestInfo#reply_status
     * @see SUCCESSFUL
     * @see SYSTEM_EXCEPTION
     * @see USER_EXCEPTION
     * @see LOCATION_FORWARD
     */
  public static final short value = (short)(4);
}
