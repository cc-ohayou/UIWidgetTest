package space.cc.com.uiwidgettest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class ProgressBarActivity extends BaseActivity implements View.OnClickListener{
    private ProgressBar mProgressBarHorizontal;
    private Button mAdd;
    private Button mReduce;
    private Button mReset;
    //第一进度值
    private TextView mFirstProgressTv;
    //第2进度值
    private TextView mSecondProgressTv;
    //每次增减的单位
    private int increase = 10;
    private int decrease = -10;
    //第一进度条初始的进度值
    private int originalFirstPro = 50;
    //第2进度条初始的进度值
    private int originalSecondPro = 80;
    private Context mContext =this;
    //自定义进度条
    private ProgressBar mCustomProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        initView();
        initData();
    }
  /**
     * @description 初始化水平进度条 增加按钮 减少按钮
   *
     * @author CF
     * created at 2018/10/24/024  22:29
     */
    private void initView(){
        mProgressBarHorizontal = (ProgressBar) findViewById(R.id.progressBarHorizontal);
        mAdd = (Button) findViewById(R.id.add);
        mReduce = (Button) findViewById(R.id.reduce);
        mReset = (Button) findViewById(R.id.reset);
        mFirstProgressTv = (TextView) findViewById(R.id.firstProgressTv);
        mSecondProgressTv = (TextView) findViewById(R.id.secondProgressTv);
        mCustomProgressBar = (ProgressBar) findViewById(R.id.customProgressBar);
    }

    private void initData(){
        mAdd.setOnClickListener(this);
        mReduce.setOnClickListener(this);
        mReset.setOnClickListener(this);
        // 自定义彩色进度条
        mCustomProgressBar.incrementProgressBy(80);
    }

    @Override
    public void onClick(View view) {
        int progress;
        int secondaryProgress;
        int max;

        switch (view.getId()){
            case R.id.add:
                mProgressBarHorizontal.incrementProgressBy(increase);
                mProgressBarHorizontal.incrementSecondaryProgressBy(increase);
                break;

            case R.id.reduce:
                mProgressBarHorizontal.incrementProgressBy(decrease);
                mProgressBarHorizontal.incrementSecondaryProgressBy(decrease);
                break;

            case R.id.reset:
                mProgressBarHorizontal.setProgress(originalFirstPro);
                mProgressBarHorizontal.setSecondaryProgress(originalSecondPro);
                break;
        }

        progress = mProgressBarHorizontal.getProgress();
        secondaryProgress = mProgressBarHorizontal.getSecondaryProgress();
        max = mProgressBarHorizontal.getMax();

        mFirstProgressTv.setText( (int)( progress / (float)max*100) + "%");
        mSecondProgressTv.setText( (int)(secondaryProgress / (float)max *100) + "%");
    }

    public void showDialog(View view){
        ProgressDialog dialog = new ProgressDialog(mContext);
        // 设置对话框参数
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("软件下载");
        dialog.setMessage("软件下载进度：");
        dialog.setCancelable(false);
        // 设置进度条参数
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(100);
        dialog.incrementProgressBy(20);
        dialog.setIndeterminate(false); // 填false表示是明确显示进度的 填true表示不是明确显示进度的
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext , "确定" , Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext , "取消" , Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }


    /**
     *
     *@author CF
     *created at 2018/10/21/021  21:59
     */
    public  static void actionStart(Context context, Map<String,String> map){
        startAction(context, map,ProgressBarActivity.class);
    }
}
