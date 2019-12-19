package com.example.myapplication0001;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.db.MySQLiteOpenHelper;
import com.example.entity.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editUsername;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnReg;
    private MySQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        db = new MySQLiteOpenHelper(this);
        //返回
        imageView = findViewById(R.id.iv_loginactivity_back);
        imageView.setOnClickListener((View view) -> {
            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
            LoginActivity.this.startActivity(intent);
        });
        editUsername = findViewById(R.id.et_loginactivity_username);
        editPassword = findViewById(R.id.et_loginactivity_password);
        //登录
        btnLogin = findViewById(R.id.bt_loginactivity_login);
        btnLogin.setOnClickListener((view) -> {
            System.out.println(1232321);
            //中文空格
            String username = editUsername.getText().toString().trim().replaceAll(" ", "");
            String password = editPassword.getText().toString().trim().replaceAll(" ", "");
            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                User user = db.checkUsername(username);
                System.out.println(user);
                if (user != null) {
                    boolean match = false;
                    if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                        match = true;
                    } else {
                        match = false;
                    }
                    if (match) {
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();//销毁此Activity
                    } else {
                        Toast.makeText(this, "密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "没有此用户，请重新输入", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
            }
        });

        //注册按钮
        btnReg = findViewById(R.id.bt_loginactivity_reg);
        btnReg.setOnClickListener((view) -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            LoginActivity.this.startActivity(intent);
        });
    }
}
