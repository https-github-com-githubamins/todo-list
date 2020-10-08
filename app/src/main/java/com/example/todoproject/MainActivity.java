package com.example.todoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {
    MBottomBar mBottomBar;
    private boolean isOpenMenu2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = new MBottomBar(findViewById(R.id.home_bottom_bar));
        setFabClick();
        setBarItemClick();
    }

    private void setFabClick() {
        mBottomBar.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOpenMenu2 = !isOpenMenu2;
                changeBarMenu();
            }
        });
    }



    private void setBarItemClick() {
        mBottomBar.getBottomBar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bar_search:
                        Toast.makeText(MainActivity.this, "Bar search click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bar_favorite:
                        Toast.makeText(MainActivity.this, "Bar favorite click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bar_notifications:
                        Toast.makeText(MainActivity.this, "Bar notifications click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bar_shopping:
                        Toast.makeText(MainActivity.this, "Bar shopping click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bar_more:
                        Toast.makeText(MainActivity.this, "Bar more click", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

        mBottomBar.getBottomBar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "bar navigation clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void changeBarMenu() {

        if (isOpenMenu2) {
            mBottomBar.getBottomBar().setNavigationIcon(null);
            mBottomBar.getBottomBar().setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            mBottomBar.getBottomBar().replaceMenu(R.menu.bottom_bar_menu_2);
            mBottomBar.fabAnimation(isOpenMenu2);
        }else {
            mBottomBar.getBottomBar().setNavigationIcon(R.drawable.ic_baseline_menu_24);
            mBottomBar.getBottomBar().setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            mBottomBar.getBottomBar().replaceMenu(R.menu.bottom_bar_menu);
            mBottomBar.fabAnimation(isOpenMenu2);



        }
    }
}