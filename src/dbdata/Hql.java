/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdata;

import org.hibernate.Query;
import org.hibernate.Session;

public class Hql {
    public final static String getUsers = " from Users ";    
    public static String getUser(String userId) {
        return getUsers + " where userId='" + userId + "'";
    }
    
    public static String getUser(String userId, String password) {
        return getUsers + " where userId='" + userId + "' and password='" + password + "'";
    }

    public final static String getOrganizations = " from Organization ";
    static String getOrganizatoin(String orgName) {
        return getOrganizations + " where orgName='" + orgName + "'";
    }

    public final static String getLoadCycle = " from LoadCycle ";
    static String getLoadCycle(String loadCyclelId) {
        return getLoadCycle + " where loadCycleId='" + loadCyclelId + "'";
    }

    public final static String getPolicy = " from Policy ";
    static String getPolicy(Integer loadCyclelId) {
        return getPolicy + " where loadCycleId='" + loadCyclelId + "'";
    }
    
    public final static String getPreference = " from Preference ";
    static String getPreference(Integer policyId) {
        return getPreference + " where policyId='" + policyId + "'";
    }

    public final static String getServerPreference = " from ServerPreference ";
    static String getServerPreference(Integer preferenceId) {
         return getServerPreference + " where preferenceId='" + preferenceId + "'";
    }

    public final static String getPluginsPreference = " from PluginsPreference ";
    static String getPluginsPreference(Integer preferenceId) {
        return getPluginsPreference + " where preferenceId='" + preferenceId + "'";
    }
    
    public final static String getFamilySelection = " from FamilySelection ";
    static String getFamilySelection(Integer policyId) {
        return getFamilySelection + " where policyId='" + policyId + "'";
    }
    
    public final static String getIndividualPluginSelection = " from IndividualPluginSelection ";
    static String getIndividualPluginSelection(Integer policyId) {
        return getIndividualPluginSelection + " where policyId='" + policyId + "'";
    }

    public final static String getReport = " from Report ";
    static String getReport(Integer loadCyclelId) {
        return getReport + " where loadCycleId='" + loadCyclelId + "'";
    }
    
    public final static String getReportHost = " from ReportHost ";
    static String getReportHost(Integer reportId) {
        return getReportHost + " where reportId='" + reportId + "'";
    }
    
    public final static String getHostProperties = " from HostProperties ";
    static String getHostProperties(Integer reportHostId) {
        return getHostProperties + " where reportHostId='" + reportHostId + "'";
    }
    
    public final static String getReportItemAttribute = " from ReportItemAttribute ";
    static String getReportItemAttribute(Integer reportHostId) {
        return getReportItemAttribute + " where reportHostId='" + reportHostId + "'";
    }
    
    public final static String getReportItem = " from ReportItem ";
    static String getReportItem(Integer reportHostId) {
        return getReportItem + " where reportHostId='" + reportHostId + "'";
    }

    public final static String getNessusStructure = " from NessusStructure ";
    static String getNessusStructure(String parentName) {
        return getNessusStructure + " where parentName='" + parentName + "'";
    }
    
    static String getNessusStructureId(String newValue) {
         return getNessusStructure + " where name='" + newValue + "'";
    }
    
    static Query getQuery(Session session, String tableObjectName) throws Exception {
        String hql = " from " + tableObjectName;
        Query query = session.createQuery(hql);
        
        return query;
    }
    
    static Query getQuery(Session session, String tableObjectName, String propertyName, Object obj) throws Exception {
        String hql = " from " + tableObjectName + " o where o." + propertyName + " = :" + propertyName;
        Query query = session.createQuery(hql);
        query.setParameter(hql, obj);
        
        return query;
    }
    
    static Query getQuery(Session session, String tableObjectName, String propertyName1, Object obj1, String propertyName2, Object obj2) throws Exception {
        String hql = " from " + tableObjectName + " where " + propertyName1 + " = :" + propertyName1 + " and " + propertyName2 + " = :" + propertyName2;
        Query query = session.createQuery(hql);
        query.setParameter(hql, obj1);
        query.setParameter(hql, obj2);
        
        return query;
    }

    
}
