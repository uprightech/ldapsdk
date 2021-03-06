/*
 * Copyright 2016-2018 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2016-2018 Ping Identity Corporation
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.ldap.sdk.unboundidds.tools;




import java.util.Collections;
import java.util.List;

import com.unboundid.ldap.listener.InMemoryExtendedOperationHandler;
import com.unboundid.ldap.listener.InMemoryRequestHandler;
import com.unboundid.ldap.sdk.ExtendedRequest;
import com.unboundid.ldap.sdk.ExtendedResult;
import com.unboundid.ldap.sdk.unboundidds.extensions.
            PasswordPolicyStateExtendedRequest;



/**
 * This class provides an implementation of an extended operation handler for
 * the in-memory directory server that fakes support for the password policy
 * state extended operation and will return a canned response to all requests.
 */
public final class
CannedResponsePWPStateInMemoryExtendedOperationHandler
       extends InMemoryExtendedOperationHandler
{
  // The result code to return.
  private final ExtendedResult result;



  /**
   * Creates a new instance of this extended operation handler that will return
   * the provided result for all requests.
   *
   * @param  result  The result to return for all requests.
   */
  public CannedResponsePWPStateInMemoryExtendedOperationHandler(
              final ExtendedResult result)
  {
    this.result = result;
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public String getExtendedOperationHandlerName()
  {
    return "Password Policy State";
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public List<String> getSupportedExtendedRequestOIDs()
  {
    return Collections.singletonList(
         PasswordPolicyStateExtendedRequest.PASSWORD_POLICY_STATE_REQUEST_OID);
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public ExtendedResult processExtendedOperation(
                             final InMemoryRequestHandler handler,
                             final int messageID, final ExtendedRequest request)
  {
    return result;
  }
}
