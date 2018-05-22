package com.androsys.snkt.searchfilterlistview;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MyDialogFragment extends DialogFragment implements TextWatcher, AdapterView.OnItemClickListener {

    private ListView listView;
    public EditText editTextState;
    private ListViewAdapter adapter;
    private ArrayList<String> arrayListState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_popup,container,false);
        getDialog().setTitle("Tittle Name");
        return  view;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialization(view);
    }

    private void initialization(View view) {
        editTextState = view.findViewById(R.id.editText2);
        listView = view.findViewById(R.id.listView);
        arrayListState = new ArrayList();
        arrayListState.addAll(Arrays.asList(getResources().getStringArray(R.array.stateNames)));
        editTextState.addTextChangedListener(this);
        listView.setOnItemClickListener(this);
        adapter = new ListViewAdapter(getActivity(), arrayListState);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String text = editTextState.getText().toString().toLowerCase(Locale.getDefault());
        adapter.filter(text);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getActivity(), position + "\t " + listView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        ((HomeActivity) getActivity()).setEditTextState(listView.getItemAtPosition(position).toString());
        this.dismiss();

    }
}
