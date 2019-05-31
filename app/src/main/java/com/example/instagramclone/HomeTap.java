package com.example.instagramclone;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTap extends Fragment {

   private ListView listView;
   private ArrayList arrayList;
   private ArrayAdapter arrayAdapter;
    public HomeTap() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home_tap, container, false);
       listView=(ListView)view.findViewById(R.id.users_list_view);
       arrayList=new ArrayList();
       arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);



        ParseQuery<ParseUser>parseQuery=ParseUser.getQuery();
        parseQuery.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e==null){
                    if (objects.size()>0){
                        for (ParseUser user:objects){
                            arrayList.add(user.getUsername());

                        }
                        listView.setAdapter(arrayAdapter);

                    }



                }
            }
        });





       return view;
    }

}
