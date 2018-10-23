package space.cc.com.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private EditText editText01;
    private ImageView imageView;
    private ProgressBar progressBar;


    private static List<Integer> bgPics=new ArrayList<>();
    {
        bgPics.add(R.drawable.image05);
        bgPics.add(R.drawable.image04);
        bgPics.add(R.drawable.image03);
        bgPics.add(R.drawable.image02);
        bgPics.add(R.drawable.image01);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but01=findViewById(R.id.but01);
        but01.setOnClickListener(this);
        //初始化注册按钮的监听事件
        Button but02=findViewById(R.id.but02);
        but02.setOnClickListener(this);
        Button but03=findViewById(R.id.but03);
        but03.setOnClickListener(this);

        editText01=findViewById(R.id.editText01);
        imageView= findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.but01:
                Toast.makeText(MainActivity.this,
                 editText01.getText().toString(), Toast.LENGTH_SHORT).show();
                 break;
            case R.id.but02:
                Log.i(TAG,"but02 click switch imageView bg");
                imageView.setImageResource(bgPics.get(new Random().nextInt(bgPics.size())));
                break;
            case R.id.but03:
                //空间3种状态 visible(默认的 可见)  invisible（不可见 空间还在 类似于透明）
                // gone （不可见 屏幕空间也不再占有）
              /*  if(progressBar.getVisibility()== View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }*/
                ProgressBarActivity.actionStart(MainActivity.this,null);
                break;
            default:
                break;


        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.i(TAG,"onPointerCaptureChanged");
    }
}
