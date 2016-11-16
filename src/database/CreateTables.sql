CREATE TABLE "NESSUS_STRUCTURE" ("ID" INTEGER PRIMARY KEY NOT NULL, "PARENT_NAME" VARCHAR(100), "NAME" VARCHAR(100));

CREATE TABLE USERS (USER_ID VARCHAR(80) not null,PASSWORD VARCHAR(20) not null,FIRST_NAME VARCHAR(40),MIDDLE_NAME VARCHAR(20),LAST_NAME VARCHAR(40),EMAIL VARCHAR(80),PHONE VARCHAR(20), "ROLE" VARCHAR(5),primary key (USER_ID));

CREATE TABLE "ORGANIZATION" ("ORG_ID" INTEGER PRIMARY KEY NOT NULL, "ORG_NAME" VARCHAR(100) NOT NULL, "DESCRIPTION" VARCHAR(200));

CREATE TABLE "LOAD_CYCLE" ("LOAD_CYCLE_ID" INTEGER PRIMARY KEY  NOT NULL, "ORG_ID" INTEGER REFERENCES "ORGNIZATION" ("ORG_ID") ON DELETE CASCADE, "LOAD_TIME" TIME, "LOAD_BY" VARCHAR(80) REFERENCES "USERS" ("USER_ID") ON DELETE CASCADE);

CREATE TABLE "POLICY" ("POLICY_ID" INTEGER PRIMARY KEY NOT NULL, "POLICY_NAME" VARCHAR(400), "LOAD_CYCLE_ID" INTEGER REFERENCES "LOAD_CYCLE" ("LOAD_CYCLE_ID") ON DELETE CASCADE);

CREATE TABLE "REPORT" ("REPORT_ID" INTEGER PRIMARY KEY, "LOAD_CYCLE_ID" INTEGER REFERENCES "LOAD_CYCLE" ("LOAD_CYCLE_ID") ON DELETE CASCADE, "REPORT_NAME" VARCHAR(400), "XMLNS_CM" VARCHAR(400));

CREATE TABLE "PREFERENCE" ("PREFERENCE_ID" INTEGER PRIMARY KEY, "POLICY_ID" INTEGER REFERENCES "POLICY" ("POLICY_ID") ON DELETE CASCADE);

CREATE TABLE "SERVER_PREFERENCE" ("SERVER_PREFERENCE_ID" INTEGER PRIMARY KEY NOT NULL, "NAME" VARCHAR(40), "VALUE" CLOB, "PREFERENCE_ID" INTEGER REFERENCES "PREFERENCE" ("PREFERENCE_ID") ON DELETE CASCADE);

CREATE TABLE "FAMILY_SELECTION" ("FAMILY_SELECTION_ID" INTEGER PRIMARY KEY, "FAMILY_NAME" VARCHAR(400), "STATUS" VARCHAR(200), "POLICY_ID" INTEGER REFERENCES "POLICY" ("POLICY_ID") ON DELETE CASCADE);

CREATE TABLE "INDIVIDUAL_PLUGIN_SELECTION" ("PLUGIN_ID" INTEGER PRIMARY KEY, "PLUGIN_NAME" VARCHAR(400), "FAMILY" VARCHAR(400), "STATUS" VARCHAR(100), "POLICY_ID" INTEGER REFERENCES "POLICY" ("POLICY_ID") ON DELETE CASCADE, "PLUGIN_ID_DATA" VARCHAR(20));

CREATE TABLE "REPORT_HOST" ("REPORT_HOST_ID" INTEGER PRIMARY KEY, "REPORT_HOST_NAME" VARCHAR(200), "REPORT_ID" INTEGER REFERENCES "REPORT" ("REPORT_ID"));

CREATE TABLE "REPORT_ITEM" ("REPORT_ITEM_ID" INTEGER PRIMARY KEY, "NAME" VARCHAR(100), "VALUE" LONG VARCHAR, "TEXT" CLOB, "REPORT_HOST_ID" INTEGER REFERENCES "REPORT_HOST" ("REPORT_HOST_ID") ON DELETE CASCADE);

CREATE TABLE "HOST_PROPERTIES" ("HOST_PROPERTIES_ID" INTEGER PRIMARY KEY, "LAST_UNAUTHENTICATED_RESULTS" INTEGER, "CREDENTIALED_SCAN" VARCHAR(200), "POLICY_USED" VARCHAR(200), "PATCH_SUMMARY_TOTAL_CVES" INTEGER, "CPE" VARCHAR(200), "OS" VARCHAR(200), "CPE_1" VARCHAR(200), "CPE_0" VARCHAR(200), "SYSTEM_TYPE" VARCHAR(200), "OPERATING_SYSTEM" VARCHAR(200), "TRACEROUTE_HOP_10" VARCHAR(200), "TRACEROUTE_HOP_9" VARCHAR(200), "TRACEROUTE_HOP_8" VARCHAR(200), "TRACEROUTE_HOP_7" VARCHAR(200), "TRACEROUTE_HOP_6" VARCHAR(200), "TRACEROUTE_HOP_5" VARCHAR(200), "TRACEROUTE_HOP_4" VARCHAR(200), "TRACEROUTE_HOP_3" VARCHAR(200), "TRACEROUTE_HOP_2" VARCHAR(200), "TRACEROUTE_HOP_1" VARCHAR(200), "TRACEROUTE_HOP_0" VARCHAR(200), "HOST_END" VARCHAR(200), "HOST_IP" VARCHAR(200), "HOST_START" VARCHAR(200), "REPORT_HOST_ID" INTEGER REFERENCES "REPORT_HOST" ("REPORT_HOST_ID") ON DELETE CASCADE);

CREATE TABLE "REPORT_ITEM_ATTRIBUTE" ("REPORT_ITEM_ID" INTEGER PRIMARY KEY AUTOINCREMENT REFERENCES "REPORT_ITEM" ("REPORT_ITEM_ID") ON DELETE CASCADE, "PORT" INTEGER, "SVC_NAME" VARCHAR, "PROTOCOL" VARCHAR, "SEVERITY" INTEGER, "PLUGIN_ID" INTEGER, "PLUGIN_NAME" VARCHAR, "PLUGIN_FAMILY" VARCHAR, "REPORT_HOST_ID" INTEGER REFERENCES "REPORT_HOST" ("REPORT_HOST_ID") ON DELETE CASCADE);

CREATE TABLE "PLUGINS_PREFERENCE" ("PLUGINS_PREFERENCE_ID" INTEGER PRIMARY KEY NOT NULL, "PLUGIN_NAME" VARCHAR(200), "PLUGIN_ID" VARCHAR(200), "PREFERENCE_NAME" VARCHAR(400), "PREFERENCE_TYPE" VARCHAR(200), "PREFERENCE_VALUE" VARCHAR(200), "SELECTED_VALUE" VARCHAR(200), "PREFERENCE_ID" INTEGER REFERENCES "POLICY" ("POLICY_ID") ON DELETE CASCADE, "FULL_NAME" VARCHAR(200));

