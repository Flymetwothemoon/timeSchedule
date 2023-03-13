package com.example.module_homepage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.module_homepage.R;
import com.example.module_homepage.bean.Cheeses;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private SearchView mSearchView;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    private final String[] mStrings = Cheeses.sCheeseStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_search);

        mSearchView = findViewById(R.id.search_view);
        mListView =  findViewById(R.id.list_view);
        mListView.setAdapter(mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                mStrings));
        //设置是否可以通过键盘输入的字符来过滤掉不需要的选项，定位到需要的选项。
        mListView.setTextFilterEnabled(true);
        setupSearchView();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)((TextView) view).getText();
                Toast.makeText(SearchActivity.this, "search_activity", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupSearchView() {
        //设置搜索框直接展开显示。左侧有放大镜(在搜索框中) 右侧有叉叉 可以关闭搜索框
        //mSearchView.setIconified(false);
        //设置搜索框直接展开显示。左侧有放大镜(在搜索框外) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        //mSearchView.setIconifiedByDefault(false);
        //设置搜索框直接展开显示。左侧有无放大镜(在搜索框中) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
        mSearchView.onActionViewExpanded();
        //为 SearchView 中的用户操作设置侦听器。
        mSearchView.setOnQueryTextListener(this);
//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // Toast.makeText(SearchActivity.this, "mSearchVie_submit", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//               // Toast.makeText(SearchActivity.this, "mSearchVie_change", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        //当查询非空时启用显示提交按钮。
        mSearchView.setSubmitButtonEnabled(false);
        //查询提示语句
        mSearchView.setQueryHint(getString(R.string.cheese_hunt_hint));
    }
    //用户输入字符时激发该方法
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mListView.clearTextFilter();
        } else {
            mListView.setFilterText(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}