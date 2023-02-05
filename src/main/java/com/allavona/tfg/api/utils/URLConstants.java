package com.allavona.tfg.api.utils;

public class URLConstants {
    public static final String V1 = "/v1";
    public static final String INCIDENTS = "/incidents";
    public static final String USERS = "/users";

    public static final String RESOURCES = "/resources";
    public static final String INCIDENTS_V1_URL = V1 + INCIDENTS;
    public static final String USERS_V1_URL = V1 + USERS;
    public static final String RESOURCES_V1_URL = V1+ RESOURCES;

    public static final String USERS_AUTHENTICATION_URL = "/authenticate";

    public static final String CLASSIFICATIONS_URL = "/classifications";
    public static final String CLASSIFICATIONS_TEMPLATE_URL = CLASSIFICATIONS_URL + "/{id}/recommended-resources-type-list";

}
