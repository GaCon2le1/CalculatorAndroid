package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Float fthamsothu1,fthamsothu2;
    String stoantu,sxuatmanhinh = "";
    EditText etGiaTri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGiaTri = findViewById(R.id.etKetQua);

        int[] idButton = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                            R.id.btncham,R.id.btnchia,R.id.btntru,R.id.btncong,R.id.btnnhan,R.id.btnDelete,R.id.btnbang};

        for(int id : idButton){
            View v = (View)findViewById(id);
            v.setOnClickListener(this);
        }

    }

    private  void Toantu(){
        fthamsothu1 = Float.parseFloat(etGiaTri.getText().toString());
        sxuatmanhinh = "0";
        etGiaTri.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncong:
                stoantu = "+";
                Log.d("","+");
                Toantu();
                break;
            case  R.id.btntru:
                stoantu = "-";
                Log.d("","-");
                Toantu();
                break;
            case R.id.btnnhan:
                stoantu = "*";
                Log.d("","*");
                Toantu();
                break;
            case  R.id.btnchia:
                stoantu = "/";
                Log.d("","/");
                Toantu();
                break;
            case R.id.btnbang:
                //stoantu = "=";
                Float ketqua = null;
                fthamsothu2 = Float.parseFloat(etGiaTri.getText().toString());

                if(stoantu=="+"){
                    ketqua = fthamsothu1+fthamsothu2;
                }

                if(stoantu=="-"){
                    ketqua = fthamsothu1-fthamsothu2;
                }

                if(stoantu=="*"){
                    ketqua = fthamsothu1*fthamsothu2;
                }

                if(stoantu=="/"){
                    ketqua = fthamsothu1/fthamsothu2;
                }



                etGiaTri.setText(String.valueOf(ketqua));
                fthamsothu1 = 0.0f;
                fthamsothu2 = 0.0f;
                sxuatmanhinh = "0";
                break;
            default:
                if(sxuatmanhinh.equals("0")){
                    sxuatmanhinh = "";
                }
                sxuatmanhinh+=((Button)v).getText().toString();
                etGiaTri.setText(sxuatmanhinh);
                break;

        }
    }
}