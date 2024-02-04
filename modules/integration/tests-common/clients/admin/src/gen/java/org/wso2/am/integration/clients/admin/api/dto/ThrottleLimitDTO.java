/*
 * WSO2 API Manager - Admin
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Admin Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.admin.v1/src/main/resources/admin-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication Our REST APIs are protected using OAuth2 and access control is achieved through scopes. Before you start invoking the the API you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_admin\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown bellow to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_admin\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_admin\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for Admin REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorizations** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_passowrd>&scope=<scopes seperated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<gateway_port>/token ``` **Sample request** ``` curl https://localhost:8243/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:admin apim:tier_view\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:admin apim:tier_view\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/f5ac2ca9fb22afef6ed6) 
 *
 * The version of the OpenAPI document: v4
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.admin.api.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.wso2.am.integration.clients.admin.api.dto.BandwidthLimitDTO;
import org.wso2.am.integration.clients.admin.api.dto.EventCountLimitDTO;
import org.wso2.am.integration.clients.admin.api.dto.RequestCountLimitDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* ThrottleLimitDTO
*/

public class ThrottleLimitDTO {
            /**
* Type of the throttling limit. Allowed values are \&quot;REQUESTCOUNTLIMIT\&quot; and \&quot;BANDWIDTHLIMIT\&quot;. Please see schemas of \&quot;RequestCountLimit\&quot; and \&quot;BandwidthLimit\&quot; throttling limit types in Definitions section. 
*/
    @JsonAdapter(TypeEnum.Adapter.class)
public enum TypeEnum {
        REQUESTCOUNTLIMIT("REQUESTCOUNTLIMIT"),
        
        BANDWIDTHLIMIT("BANDWIDTHLIMIT"),
        
        EVENTCOUNTLIMIT("EVENTCOUNTLIMIT");

private String value;

TypeEnum(String value) {
this.value = value;
}

public String getValue() {
return value;
}

@Override
public String toString() {
return String.valueOf(value);
}

public static TypeEnum fromValue(String value) {
    for (TypeEnum b : TypeEnum.values()) {
    if (b.name().equals(value)) {
        return b;
    }
}
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
}

    public static class Adapter extends TypeAdapter<TypeEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
    jsonWriter.value(enumeration.getValue());
    }

    @Override
    public TypeEnum read(final JsonReader jsonReader) throws IOException {
    String value =  jsonReader.nextString();
    return TypeEnum.fromValue(value);
    }
    }
}

        public static final String SERIALIZED_NAME_TYPE = "type";
        @SerializedName(SERIALIZED_NAME_TYPE)
            private TypeEnum type;

        public static final String SERIALIZED_NAME_REQUEST_COUNT = "requestCount";
        @SerializedName(SERIALIZED_NAME_REQUEST_COUNT)
            private RequestCountLimitDTO requestCount = null;

        public static final String SERIALIZED_NAME_BANDWIDTH = "bandwidth";
        @SerializedName(SERIALIZED_NAME_BANDWIDTH)
            private BandwidthLimitDTO bandwidth = null;

        public static final String SERIALIZED_NAME_EVENT_COUNT = "eventCount";
        @SerializedName(SERIALIZED_NAME_EVENT_COUNT)
            private EventCountLimitDTO eventCount = null;


        public ThrottleLimitDTO type(TypeEnum type) {
        
        this.type = type;
        return this;
        }

    /**
        * Type of the throttling limit. Allowed values are \&quot;REQUESTCOUNTLIMIT\&quot; and \&quot;BANDWIDTHLIMIT\&quot;. Please see schemas of \&quot;RequestCountLimit\&quot; and \&quot;BandwidthLimit\&quot; throttling limit types in Definitions section. 
    * @return type
    **/
      @ApiModelProperty(example = "REQUESTCOUNTLIMIT", required = true, value = "Type of the throttling limit. Allowed values are \"REQUESTCOUNTLIMIT\" and \"BANDWIDTHLIMIT\". Please see schemas of \"RequestCountLimit\" and \"BandwidthLimit\" throttling limit types in Definitions section. ")
    
    public TypeEnum getType() {
        return type;
    }


    public void setType(TypeEnum type) {
        this.type = type;
    }


        public ThrottleLimitDTO requestCount(RequestCountLimitDTO requestCount) {
        
        this.requestCount = requestCount;
        return this;
        }

    /**
        * Get requestCount
    * @return requestCount
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public RequestCountLimitDTO getRequestCount() {
        return requestCount;
    }


    public void setRequestCount(RequestCountLimitDTO requestCount) {
        this.requestCount = requestCount;
    }


        public ThrottleLimitDTO bandwidth(BandwidthLimitDTO bandwidth) {
        
        this.bandwidth = bandwidth;
        return this;
        }

    /**
        * Get bandwidth
    * @return bandwidth
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public BandwidthLimitDTO getBandwidth() {
        return bandwidth;
    }


    public void setBandwidth(BandwidthLimitDTO bandwidth) {
        this.bandwidth = bandwidth;
    }


        public ThrottleLimitDTO eventCount(EventCountLimitDTO eventCount) {
        
        this.eventCount = eventCount;
        return this;
        }

    /**
        * Get eventCount
    * @return eventCount
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public EventCountLimitDTO getEventCount() {
        return eventCount;
    }


    public void setEventCount(EventCountLimitDTO eventCount) {
        this.eventCount = eventCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            ThrottleLimitDTO throttleLimit = (ThrottleLimitDTO) o;
            return Objects.equals(this.type, throttleLimit.type) &&
            Objects.equals(this.requestCount, throttleLimit.requestCount) &&
            Objects.equals(this.bandwidth, throttleLimit.bandwidth) &&
            Objects.equals(this.eventCount, throttleLimit.eventCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, requestCount, bandwidth, eventCount);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class ThrottleLimitDTO {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    requestCount: ").append(toIndentedString(requestCount)).append("\n");
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    eventCount: ").append(toIndentedString(eventCount)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}
