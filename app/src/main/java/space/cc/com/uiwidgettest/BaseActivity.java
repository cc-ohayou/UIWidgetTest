package space.cc.com.uiwidgettest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import space.cc.com.util.ActivityCollector;

public  class BaseActivity extends AppCompatActivity{
    private static final String TAG = "BaseActivity";
     static final Map EMPTY_MAP =new HashMap();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "taskId is: " + getTaskId());
        Log.d(TAG, "create and add to collector activity is " + getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);

    }

    /**
     * @author CF
     * created at 2018/10/21/021  21:42
     */
    static void startAction(Context context, Map<String, String> map, Class<?> c) {
        Log.i(TAG, "startAction:context is :" + context.getClass().getSimpleName()
                + ",targetActivity is:" + c.getSimpleName());
        Intent intent = new Intent(context, c);
        if (isNotEmpty(map)) {
            Set<Map.Entry<String, String>> set = map.entrySet();
            for (Map.Entry<String, String> entry : set) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        context.startActivity(intent);
    }

    static boolean isNotEmpty(Map map) {
        return map != null && !map.isEmpty();
    }

/**
 *
 *@author CF
 *created at 2018/10/21/021  21:42
 */
    public   void startAction(Context context,String bundlKkey, Bundle bundle){
        Intent intent=new Intent(context,this.getClass());
        intent.putExtra(bundlKkey,bundle);
        context.startActivity(intent);
        }
    }

