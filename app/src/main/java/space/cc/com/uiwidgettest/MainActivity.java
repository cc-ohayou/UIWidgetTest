package space.cc.com.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText editText01;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Button butProgressAdd;


    private static List<Integer> bgPics = new ArrayList<>();

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
        //初始化按钮的监听事件
        initButSetClickListener(R.id.but01);
        initButSetClickListener(R.id.but02);
        initButSetClickListener(R.id.but03);
        initButSetClickListener(R.id.alertDialogBut);
        initButSetClickListener(R.id.progressDialogBut);

        editText01 = findViewById(R.id.editText01);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        butProgressAdd = findViewById(R.id.butProgressAdd);
        butProgressAdd.setOnClickListener(this);
    }

    private void initButSetClickListener(int butId) {
        Button but03 = findViewById(butId);
        but03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but01:
                Toast.makeText(MainActivity.this,
                        editText01.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.but02:
                Log.i(TAG, "but02 click switch imageView bg");
                imageView.setImageResource(bgPics.get(new Random().nextInt(bgPics.size())));
                break;
            case R.id.but03:
                //空间3种状态 visible(默认的 可见)  invisible（不可见 空间还在 类似于透明）
                // gone （不可见 屏幕空间也不再占有）
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
//                ProgressBarActivity.actionStart(MainActivity.this,null);
                break;
            case R.id.butProgressAdd:
                int progress = progressBar.getProgress();
                progress += 10;
                progressBar.setProgress(progress);
                break;
            case R.id.alertDialogBut:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("alert ? ?");
                dialog.setMessage("what the fuck you want to die?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.progressDialogBut:
                ProgressDialog dialogP = new ProgressDialog(MainActivity.this);
                dialogP.setTitle("alert ? ?");
                dialogP.setMessage("what the fuck you want to die?");
                dialogP.setCancelable(true);
                dialogP.show();
                break;

            default:
                break;


        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.i(TAG, "onPointerCaptureChanged");
    }
}
