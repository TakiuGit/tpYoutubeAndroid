package fr.takiu.tpyoutube.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import fr.takiu.tpyoutube.R;
import fr.takiu.tpyoutube.adapter.HistoricItemAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mSearch;
    private EditText mSearchText;

private RecyclerView mRecyclerView;
private RecyclerView.LayoutManager mLayoutManager;
private HistoricItemAdapter mAdapter;

    private Set<String> data;


    private void initHisto() {

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view_histo);

        data = new HashSet<>();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HistoricItemAdapter(new ArrayList(data));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearch = (Button) findViewById(R.id.b_search);
        mSearch.setOnClickListener(this);

        mSearchText = (EditText) findViewById(R.id.ed_search);

        initHisto();

        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        data = prefs.getStringSet("historic", new HashSet<String>());

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,  VideoResultActivity.class);
        String searchText = mSearchText.getText().toString();
        i.putExtra("search", searchText);

        data.add(searchText);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet("search",data);

        startActivity(i);
    }
}
