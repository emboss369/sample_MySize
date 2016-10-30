package com.example.username.mysize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HeightActivity extends AppCompatActivity {

    private TextView mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);

        mHeight = (TextView) findViewById(R.id.height);


        /// スピナーの処理
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 一覧から１つを選んだ時の処理
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 選ばれた項目を取得してTextViewに表示
                Spinner spinner = (Spinner) parent;
                String item = (String) spinner.getSelectedItem();
                mHeight.setText(item);
            }

            // 一覧で何も選択されなかった時の処理
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(HeightActivity.this, R.string.txt_canceled, Toast.LENGTH_SHORT);
            }
        });

        /// シークバーの処理１
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // シークバーの値が変更された
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 変更された値をintから文字列に変換してTextViewに表示
                String value = String.valueOf(progress);
                mHeight.setText(value);
            }
            // シークバーのスライド開始
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String value = String.valueOf(seekBar.getProgress());
                Toast.makeText(HeightActivity.this, value, Toast.LENGTH_SHORT);
            }
            // シークバーのスライド終了
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String value = String.valueOf(seekBar.getProgress());
                Toast.makeText(HeightActivity.this, value, Toast.LENGTH_SHORT);
            }
        });

        /// シークバーの処理２
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 変更された値をintから文字列に変換してTextViewに表示
                String value = String.valueOf(progress * 10);
                mHeight.setText(value);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String value = String.valueOf(seekBar.getProgress() * 10);
                Toast.makeText(HeightActivity.this, value, Toast.LENGTH_SHORT);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String value = String.valueOf(seekBar.getProgress() * 10);
                Toast.makeText(HeightActivity.this, value, Toast.LENGTH_SHORT);
            }
        });

        /// ラジオグループの処理
        final RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // ラジオグループのチェック状態が変更された時に呼び出されます
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 選択されたラジオボタンのリソースIDより、ラジオボタンを取得する
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String value = radioButton.getText().toString();
                mHeight.setText(value);
            }
        });


    }
}
