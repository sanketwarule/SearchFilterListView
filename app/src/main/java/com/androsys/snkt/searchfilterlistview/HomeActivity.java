package com.androsys.snkt.searchfilterlistview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private AutoCompleteTextView autoCompleteTextView;
    private EditText editTextState;
    private LinearLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        editTextState = findViewById(R.id.editText);
        editTextState.setOnClickListener(this);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.stateNames));


        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View arg0) {
                autoCompleteTextView.showDropDown();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editText:
                showPopupFragment();
                break;
        }
    }

    private void showPopupFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MyDialogFragment dialogFragment = new MyDialogFragment();
//        dialogFragment.show(fm, "Sample Fragment");
        dialogFragment.show(ft, "ListFragment");

    }

    public void setEditTextState(String textState){
        if (editTextState != null){
            editTextState.setText(textState);
        }
    }
}
