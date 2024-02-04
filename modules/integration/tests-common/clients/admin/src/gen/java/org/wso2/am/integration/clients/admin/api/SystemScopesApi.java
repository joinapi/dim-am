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


package org.wso2.am.integration.clients.admin.api;

import org.wso2.am.integration.clients.admin.ApiCallback;
import org.wso2.am.integration.clients.admin.ApiClient;
import org.wso2.am.integration.clients.admin.ApiException;
import org.wso2.am.integration.clients.admin.ApiResponse;
import org.wso2.am.integration.clients.admin.Configuration;
import org.wso2.am.integration.clients.admin.Pair;
import org.wso2.am.integration.clients.admin.ProgressRequestBody;
import org.wso2.am.integration.clients.admin.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.am.integration.clients.admin.api.dto.ErrorDTO;
import org.wso2.am.integration.clients.admin.api.dto.RoleAliasListDTO;
import org.wso2.am.integration.clients.admin.api.dto.ScopeListDTO;
import org.wso2.am.integration.clients.admin.api.dto.ScopeSettingsDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemScopesApi {
    private ApiClient localVarApiClient;

    public SystemScopesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SystemScopesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for systemScopesGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role scope mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesGetCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/system-scopes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call systemScopesGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = systemScopesGetCall(_callback);
        return localVarCall;

    }

    /**
     * Get Role Scope Mappings 
     * This operation is used to get the list of role scope mapping from tenant-conf for the apim admin dashboard 
     * @return ScopeListDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role scope mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public ScopeListDTO systemScopesGet() throws ApiException {
        ApiResponse<ScopeListDTO> localVarResp = systemScopesGetWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Get Role Scope Mappings 
     * This operation is used to get the list of role scope mapping from tenant-conf for the apim admin dashboard 
     * @return ApiResponse&lt;ScopeListDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role scope mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ScopeListDTO> systemScopesGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = systemScopesGetValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<ScopeListDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Role Scope Mappings  (asynchronously)
     * This operation is used to get the list of role scope mapping from tenant-conf for the apim admin dashboard 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role scope mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesGetAsync(final ApiCallback<ScopeListDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = systemScopesGetValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<ScopeListDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for systemScopesRoleAliasesGet
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesRoleAliasesGetCall(final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/system-scopes/role-aliases";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call systemScopesRoleAliasesGetValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = systemScopesRoleAliasesGetCall(_callback);
        return localVarCall;

    }

    /**
     * Retrieve Role Alias Mappings
     * This operation can be used to retreive role alias mapping 
     * @return RoleAliasListDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public RoleAliasListDTO systemScopesRoleAliasesGet() throws ApiException {
        ApiResponse<RoleAliasListDTO> localVarResp = systemScopesRoleAliasesGetWithHttpInfo();
        return localVarResp.getData();
    }

    /**
     * Retrieve Role Alias Mappings
     * This operation can be used to retreive role alias mapping 
     * @return ApiResponse&lt;RoleAliasListDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RoleAliasListDTO> systemScopesRoleAliasesGetWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = systemScopesRoleAliasesGetValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<RoleAliasListDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve Role Alias Mappings (asynchronously)
     * This operation can be used to retreive role alias mapping 
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. The list of role mappings are returned.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesRoleAliasesGetAsync(final ApiCallback<RoleAliasListDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = systemScopesRoleAliasesGetValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<RoleAliasListDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for systemScopesRoleAliasesPut
     * @param roleAliasListDTO role-alias mapping (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Role mapping alias returned  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesRoleAliasesPutCall(RoleAliasListDTO roleAliasListDTO, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = roleAliasListDTO;

        // create path and map variables
        String localVarPath = "/system-scopes/role-aliases";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call systemScopesRoleAliasesPutValidateBeforeCall(RoleAliasListDTO roleAliasListDTO, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'roleAliasListDTO' is set
        if (roleAliasListDTO == null) {
            throw new ApiException("Missing the required parameter 'roleAliasListDTO' when calling systemScopesRoleAliasesPut(Async)");
        }
        

        okhttp3.Call localVarCall = systemScopesRoleAliasesPutCall(roleAliasListDTO, _callback);
        return localVarCall;

    }

    /**
     * Add a New Role Alias
     * This operation can be used to add a new role alias mapping for system scope roles 
     * @param roleAliasListDTO role-alias mapping (required)
     * @return RoleAliasListDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Role mapping alias returned  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public RoleAliasListDTO systemScopesRoleAliasesPut(RoleAliasListDTO roleAliasListDTO) throws ApiException {
        ApiResponse<RoleAliasListDTO> localVarResp = systemScopesRoleAliasesPutWithHttpInfo(roleAliasListDTO);
        return localVarResp.getData();
    }

    /**
     * Add a New Role Alias
     * This operation can be used to add a new role alias mapping for system scope roles 
     * @param roleAliasListDTO role-alias mapping (required)
     * @return ApiResponse&lt;RoleAliasListDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Role mapping alias returned  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RoleAliasListDTO> systemScopesRoleAliasesPutWithHttpInfo(RoleAliasListDTO roleAliasListDTO) throws ApiException {
        okhttp3.Call localVarCall = systemScopesRoleAliasesPutValidateBeforeCall(roleAliasListDTO, null);
        Type localVarReturnType = new TypeToken<RoleAliasListDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Add a New Role Alias (asynchronously)
     * This operation can be used to add a new role alias mapping for system scope roles 
     * @param roleAliasListDTO role-alias mapping (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Role mapping alias returned  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesRoleAliasesPutAsync(RoleAliasListDTO roleAliasListDTO, final ApiCallback<RoleAliasListDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = systemScopesRoleAliasesPutValidateBeforeCall(roleAliasListDTO, _callback);
        Type localVarReturnType = new TypeToken<RoleAliasListDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for systemScopesScopeNameGet
     * @param scopeName scope name to be validated  (required)
     * @param username  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Particular scope exists for the given user.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesScopeNameGetCall(String scopeName, String username, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/system-scopes/{scopeName}"
            .replaceAll("\\{" + "scopeName" + "\\}", localVarApiClient.escapeString(scopeName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (username != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("username", username));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call systemScopesScopeNameGetValidateBeforeCall(String scopeName, String username, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scopeName' is set
        if (scopeName == null) {
            throw new ApiException("Missing the required parameter 'scopeName' when calling systemScopesScopeNameGet(Async)");
        }
        

        okhttp3.Call localVarCall = systemScopesScopeNameGetCall(scopeName, username, _callback);
        return localVarCall;

    }

    /**
     * Retrieve Scopes for a Particular User
     * This operation will return the scope list of particular user In order to get it, we need to pass the userId as a query parameter 
     * @param scopeName scope name to be validated  (required)
     * @param username  (optional)
     * @return ScopeSettingsDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Particular scope exists for the given user.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public ScopeSettingsDTO systemScopesScopeNameGet(String scopeName, String username) throws ApiException {
        ApiResponse<ScopeSettingsDTO> localVarResp = systemScopesScopeNameGetWithHttpInfo(scopeName, username);
        return localVarResp.getData();
    }

    /**
     * Retrieve Scopes for a Particular User
     * This operation will return the scope list of particular user In order to get it, we need to pass the userId as a query parameter 
     * @param scopeName scope name to be validated  (required)
     * @param username  (optional)
     * @return ApiResponse&lt;ScopeSettingsDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Particular scope exists for the given user.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ScopeSettingsDTO> systemScopesScopeNameGetWithHttpInfo(String scopeName, String username) throws ApiException {
        okhttp3.Call localVarCall = systemScopesScopeNameGetValidateBeforeCall(scopeName, username, null);
        Type localVarReturnType = new TypeToken<ScopeSettingsDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve Scopes for a Particular User (asynchronously)
     * This operation will return the scope list of particular user In order to get it, we need to pass the userId as a query parameter 
     * @param scopeName scope name to be validated  (required)
     * @param username  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Particular scope exists for the given user.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not Found. The specified resource does not exist. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call systemScopesScopeNameGetAsync(String scopeName, String username, final ApiCallback<ScopeSettingsDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = systemScopesScopeNameGetValidateBeforeCall(scopeName, username, _callback);
        Type localVarReturnType = new TypeToken<ScopeSettingsDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateRolesForScope
     * @param scopeListDTO Scope list object with updated scope to role mappings  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Successful response with the newly added roles.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRolesForScopeCall(ScopeListDTO scopeListDTO, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = scopeListDTO;

        // create path and map variables
        String localVarPath = "/system-scopes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateRolesForScopeValidateBeforeCall(ScopeListDTO scopeListDTO, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scopeListDTO' is set
        if (scopeListDTO == null) {
            throw new ApiException("Missing the required parameter 'scopeListDTO' when calling updateRolesForScope(Async)");
        }
        

        okhttp3.Call localVarCall = updateRolesForScopeCall(scopeListDTO, _callback);
        return localVarCall;

    }

    /**
     * Update Roles For Scope 
     * This operation is used to update the roles for all scopes 
     * @param scopeListDTO Scope list object with updated scope to role mappings  (required)
     * @return ScopeListDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Successful response with the newly added roles.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public ScopeListDTO updateRolesForScope(ScopeListDTO scopeListDTO) throws ApiException {
        ApiResponse<ScopeListDTO> localVarResp = updateRolesForScopeWithHttpInfo(scopeListDTO);
        return localVarResp.getData();
    }

    /**
     * Update Roles For Scope 
     * This operation is used to update the roles for all scopes 
     * @param scopeListDTO Scope list object with updated scope to role mappings  (required)
     * @return ApiResponse&lt;ScopeListDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Successful response with the newly added roles.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ScopeListDTO> updateRolesForScopeWithHttpInfo(ScopeListDTO scopeListDTO) throws ApiException {
        okhttp3.Call localVarCall = updateRolesForScopeValidateBeforeCall(scopeListDTO, null);
        Type localVarReturnType = new TypeToken<ScopeListDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update Roles For Scope  (asynchronously)
     * This operation is used to update the roles for all scopes 
     * @param scopeListDTO Scope list object with updated scope to role mappings  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK. Successful response with the newly added roles.  </td><td>  * Content-Type - The content type of the body.  <br>  </td></tr>
        <tr><td> 400 </td><td> Bad Request. Invalid request or validation error. </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRolesForScopeAsync(ScopeListDTO scopeListDTO, final ApiCallback<ScopeListDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateRolesForScopeValidateBeforeCall(scopeListDTO, _callback);
        Type localVarReturnType = new TypeToken<ScopeListDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
