package cn.edu.bistu.cs.se.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final View DialogView = inflater.inflate(R.layout.login,null);

                builder.setView(inflater.inflate(R.layout.login, null))
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {



                                EditText edtUserName = (EditText) DialogView.findViewById(R.id.editTextUserId);
                                String strUserName = edtUserName.getText().toString();

                                EditText edtPassword = (EditText) DialogView.findViewById(R.id.editTextPwd);
                                String strPassword = edtPassword.getText().toString();

                               // Log.d("dialog",strUserName);

                                if (strUserName.equals("abc") && strPassword.equals("123")) {
                                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                                } else
                                    Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_LONG).show();


                            }

                        })


                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        });

                builder.show();
            }
        });

        Button btn = (Button) this.findViewById(R.id.buttonTest2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("提示")//显示的消息内容
                        .setTitle("对话框");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });

                builder.show();
            }
        });



    }

}
