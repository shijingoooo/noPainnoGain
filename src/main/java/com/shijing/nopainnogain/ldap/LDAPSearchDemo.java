package com.shijing.nopainnogain.ldap;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class LDAPSearchDemo {

    private String LDAPURL="10.20.29.19";//ldap地址
    private int LDAPPORT=389;
    private String CONNDN="cn=syncrepl,dc=zrtg,dc=com";//账号
    private String PASSWORD="sync@111";//密码
    DirContext CTX=null;
    Hashtable<String, String> ENV=new Hashtable<String, String>();
    boolean RESULT=false;

    /**
     * 初始化ldap
     */
    public void initLdap() {
        this.ENV.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); //记录工JNDI工厂
        this.ENV.put(Context.PROVIDER_URL, "ldap://"+this.LDAPURL+":"+this.LDAPPORT);
        this.ENV.put(Context.SECURITY_AUTHENTICATION, "simple");//默认授权类型
        this.ENV.put(Context.SECURITY_PRINCIPAL, this.CONNDN);
        this.ENV.put(Context.SECURITY_CREDENTIALS, this.PASSWORD);
        try {
            this.CTX = new InitialDirContext(this.ENV);         //初始化LDAP连接
            System.out.println("初始化ldap成功！");
        }catch (NamingException e) {
            e.printStackTrace();
            System.err.println("Throw Exception : " + e);
        }
    }
    /**
     * 关闭ldap
     */
    public void closeLdap(){
        try {
            this.CTX.close();
            System.out.println("已断开ldap断开！");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param args
     */
    /*public static void main(String[] args) {

        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        //10.20.29.19、10.20.29.20
        String ldapHost = "10.20.29.19";
        String loginDN = "cn=tzh264,ou=employee,dc=zrtg,dc=com";
        String password = "8888888";

        String searchBase = "ou=employee,dc=zrtg,dc=com";
        String searchFilter = "objectClass=*";

        // 查询范围
        // SCOPE_BASE、SCOPE_ONE、SCOPE_SUB、SCOPE_SUBORDINATESUBTREE
        int searchScope = LDAPConnection.SCOPE_SUB;

        LDAPConnection lc = new LDAPConnection();
        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("连接成功...");
            lc.bind(LDAPConnection.LDAP_V3, loginDN, password.getBytes("UTF8"));
            System.out.println("绑定成功...");
            LDAPSearchResults searchResults = lc.search(searchBase,
                    searchScope, searchFilter, null, false);

            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                } catch (LDAPException e) {
                    System.out.println("Error: " + e.toString());
                    if (e.getResultCode() == LDAPException.LDAP_TIMEOUT
                            || e.getResultCode() == LDAPException.CONNECT_ERROR) {
                        break;
                    } else {
                        continue;
                    }
                }
                System.out.println("DN =: " + nextEntry.getDN());
                System.out.println("|---- Attributes list: ");
                LDAPAttributeSet attributeSet = nextEntry.getAttributeSet();
                Iterator<LDAPAttribute> allAttributes = attributeSet.iterator();
                while (allAttributes.hasNext()) {
                    LDAPAttribute attribute = allAttributes.next();
                    String attributeName = attribute.getName();

                    Enumeration<String> allValues = attribute.getStringValues();
                    if (null == allValues) {
                        continue;
                    }
                    while (allValues.hasMoreElements()) {
                        String value = allValues.nextElement();
                        if (!Base64.isLDIFSafe(value)) {
                            // base64 encode and then print out
                            value = Base64.encode(value.getBytes());
                        }
                        System.out.println("|---- ---- " + attributeName
                                + " = " + value);
                    }
                }
            }

        } catch (LDAPException e) {
            System.out.println("Error: " + e.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (lc.isConnected()) {
                    lc.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
    public static void main(String[] args) {
        LDAPSearchDemo ldap = new LDAPSearchDemo();
        List<BlueCloudUserInfo> list = ldap.getUserInfo();
        for(BlueCloudUserInfo item: list){
            System.out.println(item.toString());
        }
        System.out.println("size: " + list.size());
    }
    public List<BlueCloudUserInfo> getUserInfo() {
        List<BlueCloudUserInfo> userInfoList = new ArrayList<>();
        try {
            initLdap();
            // 域节点
            String searchBase = "DC=zrtg,DC=com";
            //LDAP搜索过滤器类
            String searchFilter = "(&(objectClass=employee)(DEID=590))";
            //创建搜索控制器
            SearchControls searchCtls = new SearchControls();
            //设置搜索范围
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            //根据设置的域节点、过滤器类和搜索控制器搜索LDAP得到结果
            NamingEnumeration<?> answer = this.CTX.search(searchBase, searchFilter,searchCtls);
            while (answer.hasMoreElements()) {// 遍历结果集
                SearchResult sr = (SearchResult) answer.next();// 得到符合搜索条件的结果
                Attributes Attrs = sr.getAttributes();// 得到符合条件的属性集
                Attribute emname=Attrs.get("cn");
                NamingEnumeration<?> emname2=emname.getAll();
                String loginId=emname2.next().toString();
                emname=Attrs.get("EMNAME");
                emname2=emname.getAll();
                String userName=emname2.next().toString();
                emname=Attrs.get("DEID");
                emname2=emname.getAll();
                String departmentId=emname2.next().toString();
                BlueCloudUserInfo item = new BlueCloudUserInfo(loginId, userName, departmentId);
                userInfoList.add(item);
            }
            System.out.println("已添加/更新"+userInfoList.size()+"条数据");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeLdap();
        }
        return userInfoList;
    }

}
