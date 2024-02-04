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
import java.util.ArrayList;
import java.util.List;
import org.wso2.am.integration.clients.admin.api.dto.AdditionalPropertyDTO;
import org.wso2.am.integration.clients.admin.api.dto.GatewayEnvironmentProtocolURIDTO;
import org.wso2.am.integration.clients.admin.api.dto.VHostDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* EnvironmentDTO
*/

public class EnvironmentDTO {
        public static final String SERIALIZED_NAME_ID = "id";
        @SerializedName(SERIALIZED_NAME_ID)
            private String id;

        public static final String SERIALIZED_NAME_NAME = "name";
        @SerializedName(SERIALIZED_NAME_NAME)
            private String name;

        public static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
        @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
            private String displayName;

        public static final String SERIALIZED_NAME_DESCRIPTION = "description";
        @SerializedName(SERIALIZED_NAME_DESCRIPTION)
            private String description;

        public static final String SERIALIZED_NAME_PROVIDER = "provider";
        @SerializedName(SERIALIZED_NAME_PROVIDER)
            private String provider;

        public static final String SERIALIZED_NAME_IS_READ_ONLY = "isReadOnly";
        @SerializedName(SERIALIZED_NAME_IS_READ_ONLY)
            private Boolean isReadOnly;

        public static final String SERIALIZED_NAME_VHOSTS = "vhosts";
        @SerializedName(SERIALIZED_NAME_VHOSTS)
            private List<VHostDTO> vhosts = new ArrayList<VHostDTO>();

        public static final String SERIALIZED_NAME_ENDPOINT_U_R_IS = "endpointURIs";
        @SerializedName(SERIALIZED_NAME_ENDPOINT_U_R_IS)
            private List<GatewayEnvironmentProtocolURIDTO> endpointURIs = null;

        public static final String SERIALIZED_NAME_ADDITIONAL_PROPERTIES = "additionalProperties";
        @SerializedName(SERIALIZED_NAME_ADDITIONAL_PROPERTIES)
            private List<AdditionalPropertyDTO> additionalProperties = null;


        public EnvironmentDTO id(String id) {
        
        this.id = id;
        return this;
        }

    /**
        * Get id
    * @return id
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "ece92bdc-e1e6-325c-b6f4-656208a041e9", value = "")
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


        public EnvironmentDTO name(String name) {
        
        this.name = name;
        return this;
        }

    /**
        * Get name
    * @return name
    **/
      @ApiModelProperty(example = "us-region", required = true, value = "")
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


        public EnvironmentDTO displayName(String displayName) {
        
        this.displayName = displayName;
        return this;
        }

    /**
        * Get displayName
    * @return displayName
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "US Region", value = "")
    
    public String getDisplayName() {
        return displayName;
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


        public EnvironmentDTO description(String description) {
        
        this.description = description;
        return this;
        }

    /**
        * Get description
    * @return description
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Gateway environment in US Region", value = "")
    
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


        public EnvironmentDTO provider(String provider) {
        
        this.provider = provider;
        return this;
        }

    /**
        * Get provider
    * @return provider
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "wso2", value = "")
    
    public String getProvider() {
        return provider;
    }


    public void setProvider(String provider) {
        this.provider = provider;
    }


        public EnvironmentDTO isReadOnly(Boolean isReadOnly) {
        
        this.isReadOnly = isReadOnly;
        return this;
        }

    /**
        * Get isReadOnly
    * @return isReadOnly
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "false", value = "")
    
    public Boolean isIsReadOnly() {
        return isReadOnly;
    }


    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }


        public EnvironmentDTO vhosts(List<VHostDTO> vhosts) {
        
        this.vhosts = vhosts;
        return this;
        }

    /**
        * Get vhosts
    * @return vhosts
    **/
      @ApiModelProperty(required = true, value = "")
    
    public List<VHostDTO> getVhosts() {
        return vhosts;
    }


    public void setVhosts(List<VHostDTO> vhosts) {
        this.vhosts = vhosts;
    }


        public EnvironmentDTO endpointURIs(List<GatewayEnvironmentProtocolURIDTO> endpointURIs) {
        
        this.endpointURIs = endpointURIs;
        return this;
        }

    /**
        * Get endpointURIs
    * @return endpointURIs
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<GatewayEnvironmentProtocolURIDTO> getEndpointURIs() {
        return endpointURIs;
    }


    public void setEndpointURIs(List<GatewayEnvironmentProtocolURIDTO> endpointURIs) {
        this.endpointURIs = endpointURIs;
    }


        public EnvironmentDTO additionalProperties(List<AdditionalPropertyDTO> additionalProperties) {
        
        this.additionalProperties = additionalProperties;
        return this;
        }

    /**
        * Get additionalProperties
    * @return additionalProperties
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(value = "")
    
    public List<AdditionalPropertyDTO> getAdditionalProperties() {
        return additionalProperties;
    }


    public void setAdditionalProperties(List<AdditionalPropertyDTO> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            EnvironmentDTO environment = (EnvironmentDTO) o;
            return Objects.equals(this.id, environment.id) &&
            Objects.equals(this.name, environment.name) &&
            Objects.equals(this.displayName, environment.displayName) &&
            Objects.equals(this.description, environment.description) &&
            Objects.equals(this.provider, environment.provider) &&
            Objects.equals(this.isReadOnly, environment.isReadOnly) &&
            Objects.equals(this.vhosts, environment.vhosts) &&
            Objects.equals(this.endpointURIs, environment.endpointURIs) &&
            Objects.equals(this.additionalProperties, environment.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, displayName, description, provider, isReadOnly, vhosts, endpointURIs, additionalProperties);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class EnvironmentDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    isReadOnly: ").append(toIndentedString(isReadOnly)).append("\n");
    sb.append("    vhosts: ").append(toIndentedString(vhosts)).append("\n");
    sb.append("    endpointURIs: ").append(toIndentedString(endpointURIs)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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

