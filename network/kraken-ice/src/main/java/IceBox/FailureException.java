// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.4.1

package IceBox;

// <auto-generated>
//
// Generated from file `IceBox.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


/**
 * This exception is a general failure notification. It is thrown
 * for errors such as a service encountering an error during
 * initialization, or the service manager being unable
 * to load a service executable.
 * 
 **/
public class FailureException extends Ice.LocalException
{
    public FailureException()
    {
    }

    public FailureException(String reason)
    {
        this.reason = reason;
    }

    public String
    ice_name()
    {
        return "IceBox::FailureException";
    }

    /**
     * The reason for the failure.
     * 
     **/
    public String reason;
}