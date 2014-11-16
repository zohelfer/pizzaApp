package com.example.pizzaapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class MenuActivity extends ActionBarActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		 
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expList);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new CustomExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        
     // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
        	
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                    int groupPosition, int childPosition, long id) {
                // selected item 
                 Intent i = new Intent(getApplicationContext(), DescActivity.class);
                 startActivity(i);
              return false;
            }
          });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Pizzas");
        listDataHeader.add("Drinks");
        listDataHeader.add("Specials");
 
        // Adding child data
        List<String> pizzas = new ArrayList<String>();
        pizzas.add("TEST Pizza");

 
        List<String> drinks = new ArrayList<String>();
        drinks.add("TEST Drink");

 
        List<String> specials = new ArrayList<String>();
        specials.add("TEST Special");

        
        listDataChild.put(listDataHeader.get(0), pizzas); // Header, Child data
        listDataChild.put(listDataHeader.get(1), drinks);
        listDataChild.put(listDataHeader.get(2), specials);
    }
    
	public void clickOrder (View view)
	{
		Intent intent = new Intent(this, OrderActivity.class);
	    startActivity(intent);
	}
}
