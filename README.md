# JOIN DIM-AM
        
---

JOIN Data In Motion API Control ( DIM-AM ) is a powerful platform for creating, managing, consuming, and
monitoring web APIs. It combines tried and tested SOA best practices with modern
day API management principles to solve a wide range of enterprise challenges
associated with API provisioning, governance, and integration.

JOIN DIM-AM consists of several loosely coupled modules.

        * API Control
        * API Developer Portal
        * API Gateway
        * API Mock
        * API Key Manager
        * API Traffic Manager


The API publisher module allows API publishers to easily define APIs and manage them
using a strong governance model that consists of well-established concepts such as,
versioning and lifecycles. API consumers can use the API Developer Portal to discover
published, production-ready APIs and access them in a secure and reliable manner
using unique API keys.  The built-in API Gateway module provides powerful tools to
secure and control the load on individual APIs.

JOIN DIM-AM is based on the revolutionary WSO2 Carbon [Middleware a' la carte]
framework. All the major features have been developed as reusable Carbon
components.

To learn more about WSO2 API Manager please visit https://joinapi.io

Key Features
=============
<details>
<summary>Design and Prototype APIs</summary>
        
    - Design APIs, gather developer's feedback before implementing (API First Design).
    - Design can be done from the publishing interface or by importing an existing Swagger definition.
    - Deploy a prototyped API, provide early access to APIs, and get early feedback.
    - Mock API implementation using Javascript.
    - Support publishing SOAP, REST, JSON, and XML style services as XML. 
</details> 

    
<details>
<summary>Create a Developer Portal of All the Available APIs</summary>
        
    - Graphical experience similar to Android Marketplace or Apple App Store.
    - Browse APIs by provider, tags, or name.
    - Self-registration to developer community to subscribe to APIs.
    - Subscribe to APIs and manage subscriptions on per-application basis.
    - Subscriptions can be at different service tiers based on the expected usage levels.
    - Role based access to API Developer Portal, which helps to manage public and private APIs.
    - Manage subscriptions per-developer.
    - Browse API documentation, download helpers for easy consumption.
    - Comment on and rate APIs.
    - Forum for discussing API usage issues (Available soon in a future version).
    - Try APIs directly on the Developer Portal.
    - Internationalization (i18n) support. 
</details>
    
<details>
<summary>Publishing and Governing API use</summary>
        
    - Publish APIs to external consumers and partners, as well as internal users.
    - Supports publishing multiple protocols including SOAP, REST, JSON, and XML style services as APIs.
    - Manage API versions and deployment status by version.
    - Govern the API lifecycle (publish, deprecate, retire).
    - Attach documentation (files, external URLs) to APIs.
    - Provision and Manage API keys.
    - Track consumers per API.
    - One-click deployment to API Gateway for immediate publishing.
</details>
        
<details>
<summary>Control Access and Enforce Security</summary>
        
    - Apply Security policies to APIs (authentication and authorization).
    - Rely on OAuth2 standard for API access (implicit, authorization code, client, SAML, IWA Grant type).
    - Restrict API access tokens to domains/IPs.
    - Block a subscription and restrict a complete application.
    - Associate API available to system defined service tiers.
    - Leverage XACML for entitlements management and fine grained authorization.
    - Configure Single Sign-On (SSO) using SAML 2.0 for easy integration with existing web apps.
    - Powered by WSO2 Enterprise Service Bus (WSO2 ESB).
</details>
        
<details>
<summary>Route API Traffic</summary>
        
    - Supports API authentication with OAuth2.
    - Extremely high performance pass-through message routing with sub-millisecond latency.
    - Enforce rate limiting and throttling policies for APIs by consumer.
    - Horizontally scalable with easy deployment into cluster using proven routing infrastructure.
    - Scales to millions of developers/users.
    - Capture all statistics and push to pluggable analytics system.
    - Configure API routing policies with capabilities of WSO2 Enterprise Service Bus.
    - Powered by WSO2 Enterprise Service Bus.            
</details>
        
<details>
<summary>Manage Developer Community</summary>
        
    - Self-sign up for API consumption.
    - Manage user account including resetting password.
    - Developer interaction with APIs via comments and ratings.
    - Support for developer communication via forums (Available soon in a future version).
    - Powered by WSO2 Identity Server (WSO2 IS).
</details>
        
<details>
<summary>Govern Complete API Lifecycle</summary>  
        
    - Manage API lifecycle from cradle to grave: create, publish, block, deprecate, and retire.
    - Publish both production and sandbox keys for APIs to enable easy developer testing.
    - Publish APIs to partner networks such as ProgrammableWeb (Available soon in a future version).
    - Powered by WSO2 Governance Registry (WSO2 G-Reg).
</details>
        
<details>
<summary>Monitor API Usage and Performance</summary>
        
    - All API usage published to pluggable analytics framework.
    - Out-of-the-box support for the WSO2 Analytics Platform and Google Analytics.
    - View metrics by user, API, and more.
    - Customized reporting via plugging reporting engines.
    - Monitor SLA compliance.
    - Powered by WSO2 Data Analytics Server (WSO2 DAS).      
</details>
    
<details>
<summary>Pluggable, Extensible, and Themeable</summary>  
        
    - All components are highly customizable through styling, theming, and open source code.
    - Developer Portal implemented with React.
    - Pluggable to third-party analytics systems and billing systems (Available soon in a future version).
    - Pluggable to existing user stores including JDBC and LDAP.
    - Components usable separately. 
    - Developer Portal can be used to front APIs that are routed through third-party gateways such as, Intel Expressway Service Gateway.
    - Support for Single Sign On (SSO) using SAML 2.0 for easy integration with existing web apps.
</details>

<details>
<summary>Easily Deployable in Enterprise Settings</summary>
        
    - Role based access control (RBAC) for managing users and their authorization levels.
    - Developer Portal can be deployed in DMZ for external access with the Publisher inside the firewall for private control.
    - Different user stores for developer focused Developer Portal and internal operations in the publisher.
    - Integrates with enterprise identity systems including LDAP and Microsoft Active Directory.
    - Gateway can be deployed in DMZ with controlled access to WSO2 Identity Server (for authentication/authorization) and governance database behind a firewall.
</details>

<details>
<summary>Support for Creating Multi-tenanted APIs</summary>  
        
    - Run a single instance and provide API Management to multiple customers.
    - Share APIs between different departments in a large enterprise.
</details>
 
<details>
<summary>Publishing and Governing API Use</summary> 
        
    - Document an API using Swagger.
    - Restrict API access tokens to domains/IPs.
    - Ability to block a subscription and restricting a complete application.
    - Ability to revoke access tokens.
    - Separate validity period configuration for application access token.
    - OAuth2 authorization code grant type support.
    - Configuring execution point of mediation extensions.
</details>
 
<details>
<summary>Monitor API Usage and Performance</summary>
        
    - Improved dashboard for monitoring usage statistics (Filtering data for a date range, More visually appealing widgets).   
    
</details>    
* Apache Rampart   : http://ws.apache.org/rampart/
* Apache WSS4J     : http://ws.apache.org/wss4j/
* Apache Santuario : http://santuario.apache.org/
* Bouncycastle     : http://www.bouncycastle.org/

--------------------------------------------------------------------------------
(c) Copyright 2024 JOINAPI.