
package com.wnc.dubbo.news.qq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wnc.basic.BasicFileUtil;
import com.wnc.tools.FileOp;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QqUserManager
{
    private static final String CERTINFO = "certinfo";
    private static Set<Long> userSet = Collections
            .synchronizedSet( new HashSet<Long>() );
    private static String usersFile = QqConsts.USERS_TXT;
    static
    {
        initUsers();
    }

    private static void initUsers()
    {
        if ( BasicFileUtil.isExistFile( usersFile ) )
        {
            List<String> lines = FileOp.readFrom( usersFile, "UTF-8" );
            for ( String line : lines )
            {
                long uid = JSONObject.parseObject( line )
                        .getLongValue( "userid" );
                userSet.add( uid );
                // System.out.println( uid );
            }
        }
    }

    public static synchronized void addAndWriteUser( JSONObject jsonObject )
    {
        if ( StringUtils.isBlank( jsonObject.getString( "head" ) ) )
        {
            jsonObject.remove( "head" );
        }
        Object obj = jsonObject.get( CERTINFO );
        if ( obj instanceof JSONArray && ((JSONArray)obj).size() == 0
                || obj instanceof JSONObject && ((JSONObject)obj).size() == 0 )
        {
            jsonObject.remove( CERTINFO );
        }

        long uid = jsonObject.getLongValue( "userid" );
        if ( uid == 0 )
        {
            return;
        }

        if ( userSet.add( uid ) )
        {
            BasicFileUtil.writeFileString( usersFile,
                    jsonObject.toJSONString() + "\r\n", null, true );
        } else
        {
            System.out.println( uid + " 用户已经存在!" );
        }
    }

    public static void main( String[] args )
    {
        initUsers();
    }
}
